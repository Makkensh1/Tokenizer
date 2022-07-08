package com.inside24.Tokenizer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class AuditorConfig {

    @Bean
    public CustomAuditorAware auditorProvider(){
        return new CustomAuditorAware();
    }
}
