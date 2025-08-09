package com.nicolas.card_game.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebApiConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }
}
