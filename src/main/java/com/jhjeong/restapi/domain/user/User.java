package com.jhjeong.restapi.domain.user;

import com.jhjeong.restapi.domain.BaseTimeEntity;
import com.jhjeong.restapi.domain.posts.Posts;
import java.util.HashSet;
import java.util.Set;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

  @Id
  @GeneratedValue
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  @Email
  private String email;

  @Min(0)
  @Max(200)
  private Integer age;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Role role;

  @OneToMany(mappedBy = "user")
  private Set<Posts> posts = new HashSet<>();

  @Builder
  public User(String name, String email, Integer age, Role role) {
    this.name = name;
    this.email = email;
    this.age = age;
    this.role = role;
  }

  public User changeName(String name) {
    this.name = name;

    return this;
  }

  public User changeEmail(String email) {
    this.email = email;

    return this;
  }

  public User changeAge(Integer age) {
    this.age = age;

    return this;
  }

  public User addPosts(Posts posts) {
    this.posts.add(posts);
    posts.setUser(this);

    return this;
  }
}
