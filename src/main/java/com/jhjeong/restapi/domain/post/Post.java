package com.jhjeong.restapi.domain.post;

import com.jhjeong.restapi.domain.BaseTimeEntity;
import com.jhjeong.restapi.domain.user.User;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Post extends BaseTimeEntity {

  @Id
  @GeneratedValue
  private Long id;

  @Column(length = 500, nullable = false)
  private String title;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String content;

  private String author;

  @ManyToOne
  private User user;

  @Builder
  public Post(String title, String content, String author) {
    this.title = title;
    this.content = content;
    this.author = author;
  }

  public void update(String title, String content) {
    this.title = title;
    this.content = content;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
