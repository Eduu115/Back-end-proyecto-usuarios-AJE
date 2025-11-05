package aje.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
                // Rutas públicas mínimas (ajusta a tu gusto)
                .requestMatchers("/actuator/health", "/error", "/","/registro","/todos").permitAll()
                // tu API (ajusta prefijos/rutas)
                .requestMatchers("/api/perfiles/**","/rol/**").hasRole("ADMON")
                .requestMatchers("/api/usuarios/**").authenticated()
                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults())
            .authenticationProvider(authProvider);

        return http.build();
    }
    @Bean
    AuthenticationProvider authenticationProvider(UserDetailsService uds) {
        // usar constructor con UserDetailsService (no deprecado)
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(uds);
 //       provider.setPasswordEncoder(encoder);
  //      provider.setHideUserNotFoundExceptions(false); // opcional
        return provider;
    }
   
    /*
   
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // por defecto strength 10
    }
    */
}