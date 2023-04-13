
package com.tienda;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 
@Configuration
public class MvcConfig implements WebMvcConfigurer {
 
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/")
                .setViewName("index");
        registry.addViewController("/index")
                .setViewName("index");
        registry.addViewController("/login") //cuando pide login devuelve vista de login, 
                //no esta en controler porque es una pagina informativa, no se traen recursos de bases de datos
                .setViewName("login");
        registry.addViewController("/errores/403")
                .setViewName("/errores/403");
    }
}
