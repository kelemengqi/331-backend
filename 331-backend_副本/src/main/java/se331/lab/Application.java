package se331.lab;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // 添加 CORS 配置
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // 允许跨域访问 '/events' 接口



                // 允许跨域访问 '/events/*' 接口（事件详情）
                // 为简化，允许所有接口的跨域
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5173")
                        .exposedHeaders("x-total-count");
                // 暴露 'x-total-count' 头部供分页使用
            }
        };
    }
}
