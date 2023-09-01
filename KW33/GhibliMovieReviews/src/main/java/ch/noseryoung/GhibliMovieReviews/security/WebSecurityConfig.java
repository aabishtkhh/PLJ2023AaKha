package ch.noseryoung.GhibliMovieReviews.security;

import ch.noseryoung.GhibliMovieReviews.domain.users.UserService;
import io.jsonwebtoken.JwtBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private final UserService userService;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    // for future project make this method in a different file with annotation @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userService);
        return new ProviderManager(provider);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                request -> request.requestMatchers(HttpMethod.POST, "/reviews/sign-in")
                        .permitAll()
                        .requestMatchers(HttpMethod.GET, "/reviews/**")
                        .permitAll()
                .anyRequest()
                        .authenticated()
            )
            .addFilterAfter(new JWTAuthenticationFilter(new AntPathRequestMatcher("/reviews/sign-in", "POST"),
                    authenticationManager(), jwtProperties), UsernamePasswordAuthenticationFilter.class)
            .addFilterAfter(new JWTAuthorizationFilter(userService, jwtProperties),
                    UsernamePasswordAuthenticationFilter.class)
            .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .cors( value -> value.configurationSource(corsConfigurationSource()))
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
        configuration.setExposedHeaders(List.of("Authorization"));

        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**", configuration);

        return configurationSource;
    }

}