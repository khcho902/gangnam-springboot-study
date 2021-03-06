package com.khcho902.gangnamspringbootstudy.repository;

import com.khcho902.gangnamspringbootstudy.dto.ResponseBlog;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@RequiredArgsConstructor
public class BlogRepository {

    @Value("${naver.openapi.blogUrl}")
    private String naverOpenApiUrl;
    @Value("${naver.openapi.clientId}")
    private String naverOpenApiClientId;
    @Value("${naver.openapi.clientSecret}")
    private String naverOpenApiClientSecret;

    private final RestTemplate restTemplate;

    public ResponseBlog findByQuery(String query) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", naverOpenApiClientId);
        httpHeaders.add("X-Naver-Client-Secret", naverOpenApiClientSecret);

        String url = naverOpenApiUrl + "?query=" + query;

        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), ResponseBlog.class).getBody();
    }
}