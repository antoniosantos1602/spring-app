package com.app.spring_app.config;

import com.app.spring_app.services.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                // CSRF - Desativado para facilitar testes
                .csrf(csrf -> csrf.disable())

                // AUTORIZAÇÕES
                .authorizeHttpRequests(auth -> auth
                        // Permitir acesso público a estas rotas
                        .requestMatchers("/login", "/error", "/css/**", "/js/**", "/images/**").permitAll()
                        // Todas as outras rotas requerem autenticação
                        .anyRequest().authenticated()
                )

                // CONFIGURAÇÃO DO FORM LOGIN
                .formLogin(form -> form
                        // Página de login customizada
                        .loginPage("/login")
                        // URL que processa o login (POST)
                        .loginProcessingUrl("/login")
                        // Redireciona para esta página após login bem-sucedido
                        .defaultSuccessUrl("/list-users", true)
                        // Redireciona para esta página se login falhar
                        .failureUrl("/login?error=true")
                        // Nome dos parâmetros do formulário
                        .usernameParameter("username")
                        .passwordParameter("password")
                        // Permitir acesso a todos
                        .permitAll()
                )

                // CONFIGURAÇÃO DO LOGOUT
                .logout(logout -> logout
                        // URL para fazer logout
                        .logoutUrl("/logout")
                        // Redireciona para login após logout
                        .logoutSuccessUrl("/login?logout=true")
                        // Invalida a sessão HTTP
                        .invalidateHttpSession(true)
                        // Remove cookies de sessão
                        .deleteCookies("JSESSIONID")
                        // Permitir acesso a todos
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(
            BCryptPasswordEncoder encoder,
            CustomUserDetailsService userDetailsService) {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        // Define o encoder de password (BCrypt)
        provider.setPasswordEncoder(encoder);
        // Define o serviço que carrega os detalhes do utilizador
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }
}