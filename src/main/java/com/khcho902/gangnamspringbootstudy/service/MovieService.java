package com.khcho902.gangnamspringbootstudy.service;

import com.khcho902.gangnamspringbootstudy.dto.MovieDTO;
import com.khcho902.gangnamspringbootstudy.dto.NaverResponseMovie;
import com.khcho902.gangnamspringbootstudy.repository.NaverSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final NaverSearchRepository<NaverResponseMovie> naverMovieRepository;

    public List<MovieDTO> findByQuery(String query) {

        return naverMovieRepository.findByQuery("movie", query).getItems().stream()
                .map(m -> MovieDTO.builder()
                        .title(m.getTitle().replace("<b>","").replace("</b>",""))
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

    public List<MovieDTO> findByQueryOrderByRating(String query) {

        return findByQuery(query).stream()
                .filter(b -> !((Float)b.getUserRating()).equals(0.0f))
                .sorted((a, b) -> (int)(b.getUserRating() * 100) - (int)(a.getUserRating() * 100))
                .collect(Collectors.toList());
    }
}

