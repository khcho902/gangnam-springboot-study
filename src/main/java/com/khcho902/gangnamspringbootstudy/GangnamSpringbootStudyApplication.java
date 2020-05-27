package com.khcho902.gangnamspringbootstudy;

import com.khcho902.gangnamspringbootstudy.config.NaverApiConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(NaverApiConfig.class)
public class GangnamSpringbootStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(GangnamSpringbootStudyApplication.class, args);
    }

}
