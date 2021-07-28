package com.jhjeong.restapi.domain.posts;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostsRepositoryTest {

  @Autowired
  PostsRepository postsRepository;

  @AfterEach
  public void cleanup() {
    postsRepository.deleteAll();
  }

  // 게시글 저장
  @Test
  public void writeAndReadPost() {
    // given
    String title = "title";
    String content = "content";
    String author = "author";

    // when
    postsRepository.save(Posts.builder()
        .title(title)
        .content(content)
        .author(author)
        .build());
    List<Posts> all = postsRepository.findAll();

    // then
    assertThat(all.get(0).getTitle()).isEqualTo(title);
    assertThat(all.get(0).getContent()).isEqualTo(content);
    assertThat(all.get(0).getAuthor()).isEqualTo(author);
  }
}