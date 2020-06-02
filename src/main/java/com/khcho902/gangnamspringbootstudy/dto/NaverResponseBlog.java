package com.khcho902.gangnamspringbootstudy.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NaverResponseBlog {

    private List<BlogItem> items;

    @Getter
    public static class BlogItem{
        String title;
        String link;
        String description;
        String bloggername;
        String bloggerlink;
        String postdate;
    }
}