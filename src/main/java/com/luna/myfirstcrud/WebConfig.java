//注册拦截器，放行登录和SpingDoc文档路径
package com.luna.myfirstcrud;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor())
                .addPathPatterns("/**")//拦截所有接口
                .excludePathPatterns("/user/login",
                        "/user/add",
                        "/error",
                        "/doc.html",
                        "/webjars/**",
                        "/swagger-ui/**",
                        "/v3/api-docs/**");//放行不需要token的地址
    }
}
