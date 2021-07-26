package com.jhjeong.restapi.domain.user;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    public void userCreateTest() {
        // given
        String name = "jhjeong";
        String email = "kkiu1756@gmail.com";
        Integer age = 99;

        // when
        User user = User.builder()
                .name(name)
                .email(email)
                .age(age)
                .build();

        // then
        assertThat(user.getName()).isEqualTo(name);
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getAge()).isEqualTo(age);
    }

}