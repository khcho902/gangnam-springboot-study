package com.khcho902.gangnamspringbootstudy.repository;

import com.khcho902.gangnamspringbootstudy.config.NaverApiConfig;
import com.khcho902.gangnamspringbootstudy.dto.ResponseMovie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@RequiredArgsConstructor
public class MovieRepository {

    private final NaverApiConfig naverApiConfig;
    private final RestTemplate restTemplate;

    public ResponseMovie findByQuery(String query) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", naverApiConfig.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", naverApiConfig.getClientSecret());

        String url = naverApiConfig.getMovieUrl() + "?query=" + query;

        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), ResponseMovie.class).getBody();
    }
}
