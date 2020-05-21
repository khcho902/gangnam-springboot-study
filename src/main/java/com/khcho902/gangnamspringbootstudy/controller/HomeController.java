package com.khcho902.gangnamspringbootstudy.controller;

import com.khcho902.gangnamspringbootstudy.dto.BlogDTO;
import com.khcho902.gangnamspringbootstudy.service.BlogService;
import com.khcho902.gangnamspringbootstudy.dto.MovieDTO;
import com.khcho902.gangnamspringbootstudy.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HomeController {

    private final BlogService blogService;
    private final MovieService movieService;

    @GetMapping("/blog")
    public List<BlogDTO> searchBlogByQuery(@RequestParam(name = "query") String query){
        return blogService.findByQuery(query);
    }

    @GetMapping("/movie")
    public List<MovieDTO> searchMovieByQuery(@RequestParam(name = "query") String query) {
        return movieService.findByQuery(query);
    }
}