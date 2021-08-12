package com.jhjeong.restapi.domain.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserRepositoryTest {

  @Autowired
  private UserRepository userRepository;

  @Test
  public void createUser() {
    // given
    int age = 20;
    String name = "jhjeong";
    String email = "kkiu1756@gmail.com";

    System.out.println("test");
    // when
    userRepository.save(User.builder()
        .age(age)
        .name(name)
        .email(email)
        .role(Role.USER)
        .build());

    List<User> all = userRepository.findAll();
    User one = all.get(0);

    // then
    assertThat(one.getAge()).isEqualTo(age);
    assertThat(one.getName()).isEqualTo(name);
    assertThat(one.getEmail()).isEqualTo(email);
  }

}