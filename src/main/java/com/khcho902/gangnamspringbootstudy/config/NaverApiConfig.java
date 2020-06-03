package com.khcho902.gangnamspringbootstudy.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties(prefix="naver.openapi")
public class NaverApiConfig {

    private String clientId;
    private String clientSecret;
    private String blogUrl;
    private String movieUrl;
}
