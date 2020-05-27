package com.khcho902.gangnamspringbootstudy.repository;

import com.khcho902.gangnamspringbootstudy.config.NaverApiConfig;
import com.khcho902.gangnamspringbootstudy.dto.ResponseBlog;
import com.khcho902.gangnamspringbootstudy.dto.ResponseMovie;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;


@Setter
@Repository
@RequiredArgsConstructor
public class SearchRepository<T> {

    private final NaverApiConfig naverApiConfig;
    private final RestTemplate restTemplate;
    private Class<T> typeParameterClass;

    public T findByQuery(String query) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", naverApiConfig.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", naverApiConfig.getClientSecret());

        String baseApiUrl = "";
        if (typeParameterClass == ResponseBlog.class)
            baseApiUrl += naverApiConfig.getBlogUrl();
        else if (typeParameterClass == ResponseMovie.class)
            baseApiUrl += naverApiConfig.getMovieUrl();

        String url = baseApiUrl + "?query=" + query;

        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), typeParameterClass).getBody();
    }

}