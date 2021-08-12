package com.jhjeong.restapi.web.dto;

import lombok.Getter;

@Getter
public class PostResponseDto {

  private Long id;
  private String title;
  private String content;
  private String author;

  public PostResponseDto(Long id, String title, String content, String author) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.author = author;
  }
}
