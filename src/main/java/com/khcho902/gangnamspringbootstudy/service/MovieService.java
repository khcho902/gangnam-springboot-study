package com.khcho902.gangnamspringbootstudy.service;

import com.khcho902.gangnamspringbootstudy.dto.ResponseMovie;
import com.khcho902.gangnamspringbootstudy.dto.MovieDTO;
import com.khcho902.gangnamspringbootstudy.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final SearchRepository<ResponseMovie> movieRepository;

    public List<MovieDTO> findByQuery(String query) {

        movieRepository.setTypeParameterClass(ResponseMovie.class);

        List<MovieDTO> movie_list = movieRepository.findByQuery(query).getItems().stream()
                                    .map(m -> MovieDTO.builder()
                                        .title(m.getTitle())
                                        .link(m.getLink())
                                        .image(m.getImage())
                                        .subtitle(m.getSubtitle())
                                        .pubDate(m.getPubDate())
                                        .director(m.getDirector())
                                        .actor(m.getActor())
                                        .userRating(m.getUserRating())
                                        .build())
                                    .collect(Collectors.toList());

        movie_list.sort(new Comparator<MovieDTO>() {
            @Override
            public int compare(MovieDTO o1, MovieDTO o2) {
                return (int)(o2.getUserRating() * 100 - o1.getUserRating() * 100);
            }
        });

        return movie_list;
    }
}

