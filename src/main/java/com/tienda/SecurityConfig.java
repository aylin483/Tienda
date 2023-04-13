package com.tienda;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//esta java class es para manejar usuarios en memoria
@Configuration // archivo de configuración
@EnableWebSecurity
public class SecurityConfig {

    @Bean //objeto
    public UserDetailsService users() {
        UserDetails admin = User.builder()
                .username("admin") // tiene permiso a todo
                .password("{noop}123") //noop es para no encriptar contraseña (en memoria)
                .roles("USER", "VENDEDOR", "ADMIN")
                .build();
        UserDetails sales = User.builder()
                .username("vendedor") // este usuario solo tiene roles de usuario y vendedor, tiene un poco más de permisos
                .password("{noop}123")
                .roles("USER", "VENDEDOR")
                .build();
        UserDetails user = User.builder()
                .username("user") //rol de usuario
                .password("{noop}123")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user, sales, admin);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests //autorizar peticiones
                .requestMatchers(
                        "/", //cuando venga ruta base, index, **. permitir a cualquiera, todos pueden ver ruta de inicio
                        "/index",
                        "/errores/**",
                        "/error",
                        "/webjars/**").permitAll() // hay que poner CSS y boostrap porque si no están, el usuario no va a tener acceso y se va a ver en blanco
                .requestMatchers( //para todos los patrones de abajo,solo tienen acceso los que tienen rol de admin, solo admin puede ejecutar estas acciones
                        "/articulo/nuevo",
                        "/articulo/guardar",
                        "/articulo/modificar/**",
                        "/articulo/eliminar/**",
                        "/categoria/nuevo",
                        "/categoria/guardar",
                        "/categoria/modificar/**",
                        "/categoria/eliminar/**",
                        "/cliente/nuevo",
                        "/cliente/guardar",
                        "/cliente/modificar/**",
                        "/cliente/eliminar/**")
                .hasRole("ADMIN")
                .requestMatchers(
                        "/articulo/listado", //solo tienen acceso los admin y vendedor
                        "/categoria/listado",
                        "/cliente/listado")
                .hasAnyRole("ADMIN", "VENDEDOR")
                )
                .formLogin((form) -> form
                .loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll())
                .exceptionHandling()
                .accessDeniedPage("/errores/403"); //si no tiene acceso, se redirecciona al error de acceso
        return http.build();
    }
}
