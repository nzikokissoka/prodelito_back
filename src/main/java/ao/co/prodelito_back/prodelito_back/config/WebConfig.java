package ao.co.prodelito_back.prodelito_back.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            //.allowedOrigins("http://localhost:4200")  // Ou "*" se necessário   .allowedOrigins("http://localhost:4200")
            .allowedOriginPatterns("*")  // Usando patterns em vez de origins
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            .allowedHeaders("*")
            .allowCredentials(true);
    }
    
}
