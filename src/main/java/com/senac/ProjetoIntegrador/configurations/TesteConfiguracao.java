package com.senac.ProjetoIntegrador.configurations;

import com.senac.ProjetoIntegrador.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class TesteConfiguracao implements WebMvcConfigurer {

    @Autowired
    DBService dbService;

    private boolean instanciar() {
        try {
            this.dbService.instanciarDB();
        } catch (Exception e) {
            e.printStackTrace(); // ou logue, ou trate de forma adequada
            return false;
        }
        return true;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // libera todas as rotas
                .allowedOrigins("http://localhost:4200") // origem do seu Angular
                .allowedMethods("*") // métodos permitidos
                .allowedHeaders("*"); // qualquer cabeçalho
    }
}
