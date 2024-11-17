package com.yuri.clima_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClimaConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
