package com.jhjeong.restapi.domain.user;

import com.jhjeong.restapi.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Setter
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

  @Builder
  public User(String name, String email, Integer age, Role role) {
    this.name = name;
    this.email = email;
    this.age = age;
    this.role = role;
  }

  public User update(String name, Integer age) {
    this.name = name;
    this.age = age;

    return this;
  }
}
