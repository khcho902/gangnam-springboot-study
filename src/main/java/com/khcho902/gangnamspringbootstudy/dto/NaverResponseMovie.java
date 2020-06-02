package com.khcho902.gangnamspringbootstudy.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NaverResponseMovie {

    private List<MovieItem> items;

    @Getter
    public static class MovieItem {
        String title;
        String link;
        String image;
        String subtitle;
        String pubDate;
        String director;
        String actor;
        float userRating;
    }
}
