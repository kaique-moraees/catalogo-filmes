package com.example.catalogofilmes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Libera o CORS para todas as origens
                registry.addMapping("/**") 
                        .allowedOrigins("*")  // Permite todas as origens
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Permite todos os métodos
                        .allowedHeaders("*")  // Permite todos os cabeçalhos
                        .allowCredentials(true);  // Permite enviar cookies com a requisição (se necessário)
            }
        };
    }
}
