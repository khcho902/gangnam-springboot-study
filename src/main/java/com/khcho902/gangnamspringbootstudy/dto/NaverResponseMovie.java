package com.khcho902.gangnamspringbootstudy.dto;

import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NaverResponseMovie {

    private List<MovieItem> items;

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
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
