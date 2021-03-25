package com.cloud.br.hicraftsman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableCaching
@EnableDiscoveryClient
@EnableOpenApi
@SpringBootApplication
public class StartMain {

    public static void main(String[] args) {
        SpringApplication.run(StartMain.class, args);
    }

}
