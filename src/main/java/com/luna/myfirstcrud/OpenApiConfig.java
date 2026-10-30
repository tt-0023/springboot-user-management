package com.luna.myfirstcrud;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("用户管理CRUD接口文档")
                        .version("1.0.0")
                        .description("一个简单的crud项目，包含用户增删改查、登录认证、参数校验、逻辑删除等"));
    }
}
