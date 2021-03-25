package com.cloud.br.hicraftsman.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yzp
 * @date 2020/8/19 17:28
 */
@Component
@Primary
public class SwaggerProvider implements SwaggerResourcesProvider {
    private final String API_URI = "/v3/api-docs";
    @Value("#{'${swagger.services}'.split(',')}")
    private List<String> swaggerServices;

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        Set<String> set = new HashSet<>();
        swaggerServices.forEach(instance -> {
            // 拼接url，样式为/serviceId/v2/api-info，当网关调用这个接口时，会自动通过负载均衡寻找对应的主机
            String url = "/" + instance + API_URI + "?group=" + instance;
            if (!set.contains(url)) {
                set.add(url);
                SwaggerResource swaggerResource = new SwaggerResource();
                swaggerResource.setUrl(url);
                swaggerResource.setName(instance);
                resources.add(swaggerResource);
            }
        });
        return resources;
    }

}