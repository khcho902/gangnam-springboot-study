package com.khcho902.gangnamspringbootstudy.service;

import com.khcho902.gangnamspringbootstudy.dto.MovieDTO;
import com.khcho902.gangnamspringbootstudy.dto.NaverResponseMovie;
import com.khcho902.gangnamspringbootstudy.repository.NaverSearchRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    private MovieService movieService;

    @Mock
    private NaverSearchRepository<NaverResponseMovie>  movieNaverSearchRepository;

    @Test
    @DisplayName("사용자 평점 순으로 정렬이 잘 되는지 확인")
    void arranged_well_in_user_ratings() {

        // given
        float expectedUserRating = 9.7f;
        Mockito.when(movieNaverSearchRepository.findByQuery(any(), any())).thenReturn(getStubMovieList());
        movieService = new MovieService(movieNaverSearchRepository);

        // when
        List<MovieDTO> actualList = movieService.findByQueryOrderByRating("쿼리");

        // then
        assertEquals(expectedUserRating, actualList.stream().findFirst().get().getUserRating());
    }

    private NaverResponseMovie getStubMovieList(){

        List<NaverResponseMovie.MovieItem> items = Arrays.asList(
                NaverResponseMovie.MovieItem.builder().title("<b>영화1</영화> 제목").actor("배우1").userRating(9.3f).build(),
                NaverResponseMovie.MovieItem.builder().title("<b>영화1</영화> 제목").actor("배우1").userRating(9.7f).build(),
                NaverResponseMovie.MovieItem.builder().title("<b>영화1</영화> 제목").actor("배우1").userRating(0.0f).build(),
                NaverResponseMovie.MovieItem.builder().title("<b>영화1</영화> 제목").actor("배우1").userRating(7.5f).build(),
                NaverResponseMovie.MovieItem.builder().title("<b>영화1</영화> 제목").actor("배우1").userRating(1.0f).build(),
                NaverResponseMovie.MovieItem.builder().title("<b>영화1</영화> 제목").actor("배우1").userRating(9.7f).build(),
                NaverResponseMovie.MovieItem.builder().title("<b>영화1</영화> 제목").actor("배우1").userRating(0.0f).build()
        );
        return NaverResponseMovie.builder().items(items).build();
    }


}