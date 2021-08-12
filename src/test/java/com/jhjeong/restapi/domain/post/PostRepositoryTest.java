package com.jhjeong.restapi.domain.post;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostRepositoryTest {

  @Autowired
  PostRepository postRepository;

  @AfterEach
  public void cleanup() {
    postRepository.deleteAll();
  }

  // 게시글 저장
  @Test
  public void writeAndReadPost() {
    // given
    String title = "title";
    String content = "content";
    String author = "author";

    // when
    postRepository.save(Post.builder()
        .title(title)
        .content(content)
        .author(author)
        .build());
    List<Post> all = postRepository.findAll();

    // then
    assertThat(all.get(0).getTitle()).isEqualTo(title);
    assertThat(all.get(0).getContent()).isEqualTo(content);
    assertThat(all.get(0).getAuthor()).isEqualTo(author);
  }

  // 시간 등록
  @Test
  public void storeBaseTimeEntity() {
    // given
    LocalDateTime now = LocalDateTime.now();
    postRepository.save(Post.builder()
        .title("title")
        .content("content")
        .author("author")
        .build());

    // when
    List<Post> all = postRepository.findAll();

    // then
    assertThat(all.get(0).getCreatedDate()).isAfterOrEqualTo(now);
    assertThat(all.get(0).getModifiedDate()).isAfterOrEqualTo(now);
  }
}