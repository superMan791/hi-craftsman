package com.cloud.br.hicraftsman.common.core.config.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * TODO
 * mybatis配置
 *
 * @author yzp
 * @date 2021/1/21 8:34
 */
@Configuration
@MapperScan("com.tech.biran.**.dao")
public class MybatisPlusConfig {

    @Bean
    public PaginationInnerInterceptor paginationInterceptor() {
        PaginationInnerInterceptor paginationInterceptor = new PaginationInnerInterceptor();
        paginationInterceptor.setDbType(DbType.MYSQL);
        paginationInterceptor.setMaxLimit(500L);
        return paginationInterceptor;
    }

}