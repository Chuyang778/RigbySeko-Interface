package com.rigby.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ChuYang
 * @version 1.0
 */
@Configuration
@EnableSwagger2
public class Knife4jConfig {
    @Bean
    public Docket defaultApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("API接口")
                        .description("服务端接口文档")
                        .version("1.0")
                        .build())
                .select()
                // 指定 Controller 扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.rigby.api.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
