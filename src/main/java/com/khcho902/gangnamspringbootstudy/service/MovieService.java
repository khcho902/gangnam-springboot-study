package com.khcho902.gangnamspringbootstudy.service;

import com.khcho902.gangnamspringbootstudy.repository.MovieRepository;
import com.khcho902.gangnamspringbootstudy.dto.MovieDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<MovieDTO> findByQuery(String query) {
        return movieRepository.findByQuery(query).getItems().stream()
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
    }
}
