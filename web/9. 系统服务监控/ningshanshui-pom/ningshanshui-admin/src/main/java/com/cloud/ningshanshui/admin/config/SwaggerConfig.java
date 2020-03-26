package com.cloud.ningshanshui.admin.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>Title: Swagger配置</p>
 * <p>Company: 纬度网络能源</p>
 *
 * @version 1.0
 * @KaiFaAuthor 宁山水
 * @date 2020-03-24 10:35
 */

@Configuration
@ComponentScan(basePackages = {"com.cloud.ningshanshui.admin.controller"})
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("《集成Swagger文档》")   //标题
                .description("description:项目摘要")  //描述
                .termsOfServiceUrl("https://github.com/Prize-winner/ningshanshui-platform")  //（不可见）条款地址，公司内部使用的话不需要配
                .contact(new Contact("宁山水", "https://github.com/Prize-winner/ningshanshui-platform", "419201270@qq.com")) //作者信息
                .version("1.0.0") //版本号
                .build();
    }

}
