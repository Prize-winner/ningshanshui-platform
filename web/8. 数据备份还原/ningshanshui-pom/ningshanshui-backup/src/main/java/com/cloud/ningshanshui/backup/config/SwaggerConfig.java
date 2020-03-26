package com.cloud.ningshanshui.backup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>Title: Swagger配置</p>
 * <p>Company: 纬度网络能源</p>
 *
 * @version 1.0
 * @KaiFaAuthor 宁山水
 * @date 2020-03-26 14:15
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
    }

}
