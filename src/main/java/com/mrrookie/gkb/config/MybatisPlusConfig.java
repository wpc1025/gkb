package com.mrrookie.gkb.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author PengchengWang
 * @className com.mrrookie.gkb.config.MybatisPlusConfig
 * @createDate 2020/7/28 15:25
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.mrrookie.gkb.mapper")
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
