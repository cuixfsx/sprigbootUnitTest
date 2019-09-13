package com.my.springboot.config;

import com.my.springboot.security.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootConfiguration
@ServletComponentScan
public class WebConfig extends WebMvcConfigurationSupport {

    @Autowired
    RestTemplateBuilder builder;

    //1.3 之前
//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

    @Bean
    public RestTemplate restTemplate(){
        return builder.build();
    }

    /**
     * 使用代码注册Servlet（不需要@ServletComponentScan注解）
     *
     * @return
     */
//    @Bean
//    public FilterRegistrationBean filterPageRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new AuthFilter());
//        //设定匹配的路径
//        registration.addUrlPatterns("/*");
//        //添加初始化的参数
//        registration.addInitParameter("pageSize", "100");
//        registration.addInitParameter("pageOrder", "desc");
//        //设定名称
//        registration.setName("encodeFilter");
//        //设定加载的顺序
//        registration.setOrder(2);
//        return registration;
//    }

    /**
     * @return
     */
//    @Bean
//    public FilterRegistrationBean filterCodeRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new EncoderFilter());
//        //设定匹配的路径
//        registration.addUrlPatterns("/*");
//        //设定加载的顺序
//        registration.setOrder(2);
//        return registration;
//    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("cors mapping");
        //允许全部请求跨域
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true)
                .allowedOrigins("*");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("interceptor");
        //添加拦截器
        registry.addInterceptor(new JwtInterceptor()).excludePathPatterns("/sysUser/login");
    }

}
