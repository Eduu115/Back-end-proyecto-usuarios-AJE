package aje.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity // si vas a usar @PreAuthorize/@Secured
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http,
                                            AuthenticationProvider authProvider) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .cors(Customizer.withDefaults())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/usuarios/login", "/usuarios/register").permitAll()
                .requestMatchers("/perfiles/","/perfiles/**","/usuarios/").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults())
            .authenticationProvider(authProvider);

        return http.build();
    }
    @Bean
    AuthenticationProvider authenticationProvider(UserDetailsService uds) {
//        usar constructor con UserDetailsService (no deprecado)
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(uds);
//        provider.setPasswordEncoder(encoder);
//        provider.setHideUserNotFoundExceptions(false); // opcional
        return provider;
    }
   
    /*
   
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // por defecto strength 10
    }
    */
}