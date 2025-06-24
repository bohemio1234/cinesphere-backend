package com.bohemio.cinespherebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CinesphereBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run( CinesphereBackendApplication.class, args );
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
