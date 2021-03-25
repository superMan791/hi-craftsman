package com.cloud.br.hicraftsman.common.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Set;

/**
 * @author yzp
 * @date 2020/4/13 0013 8:34
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @Value("${spring.application.name:}")
    private String group;
    @Value("${swagger.title:}")
    private String title;
    @Value("${swagger.description:}")
    private String description;
    @Value("${swagger.contact-name:}")
    private String contactName;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .pathMapping("/")
                // 定义是否开启swagger，false为关闭，可以通过变量控制
                .enable(true)
                // 将api的元信息设置为包含在json ResourceListing响应中。
                .apiInfo(apiInfo())
                // 选择哪些接口作为swagger的doc发布
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dragon.cloud"))
                .paths(PathSelectors.any())
                .build()
                .groupName(group)
                // 支持的通讯协议集合
                .protocols(Set.of("https", "http"))
                ;
    }

    /**
     * API 页面上半部分展示信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .version("1.0.0")
                .title(title)
                .description(description)
                .contact(new Contact(contactName, null, ""))
                .termsOfServiceUrl("https://cloud.dragon.com")
                .license("Apache 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }
}

