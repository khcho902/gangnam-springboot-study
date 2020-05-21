package com.khcho902.gangnamspringbootstudy.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BlogDTO {

    private String title;
    private String link;
    private String description;
    private String bloggername;
    private String bloggerlink;
    private String postdate;
}