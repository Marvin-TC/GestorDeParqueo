package com.intecap.GestorDeParqueo.config;

import com.intecap.GestorDeParqueo.interceptors.inteceptorGeneral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig implements WebMvcConfigurer {

    @Autowired
    private inteceptorGeneral inteceptorGeneral;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("Inteceptoagregado");
       // registry.addInterceptor(inteceptorGeneral).addPathPatterns("/api/vehiculos/**");
       // registry.addInterceptor(inteceptorGeneral).addPathPatterns("/api/registroParqueo/**");
    }
}
