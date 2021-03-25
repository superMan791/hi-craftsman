package com.cloud.br.hicraftsman;

import org.springframework.boot.SpringApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableCaching
@EnableDiscoveryClient
@EnableOpenApi
public class MainClass {

    public static void main(String[] args) {
        SpringApplication.run(MainClass.class, args);
    }

}
