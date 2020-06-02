package com.khcho902.gangnamspringbootstudy.repository;

import com.khcho902.gangnamspringbootstudy.config.NaverApiConfig;
import com.khcho902.gangnamspringbootstudy.dto.NaverResponseBlog;
import com.khcho902.gangnamspringbootstudy.dto.NaverResponseMovie;
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
public class NaverSearchRepository<T> {

    private final NaverApiConfig naverApiConfig;
    private final RestTemplate restTemplate;

    public T findByQuery(String searchType, String query) {

        Class<T> typeParameterClass = null;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", naverApiConfig.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", naverApiConfig.getClientSecret());

        String baseApiUrl = "";
        if (searchType.equalsIgnoreCase("blog")){
            typeParameterClass = (Class<T>) NaverResponseBlog.class;
            baseApiUrl += naverApiConfig.getBlogUrl();
        } else if (searchType.equalsIgnoreCase("movie")) {
            typeParameterClass = (Class<T>) NaverResponseMovie.class;
            baseApiUrl += naverApiConfig.getMovieUrl();
        }

        String url = baseApiUrl + "?query=" + query;

        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(httpHeaders), typeParameterClass).getBody();
    }

}
