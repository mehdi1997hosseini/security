package ir.mehdihosseini.security.securityCore;

import ir.mehdihosseini.security.urlApp.UrlAppEntity;
import ir.mehdihosseini.security.urlApp.service.AccessibilityUrlService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity

public class AbstractSecurityConfig {
    private final AccessibilityUrlService accessibilityUrlService;

    public AbstractSecurityConfig(AccessibilityUrlService accessibilityUrlService) {
        this.accessibilityUrlService = accessibilityUrlService;
    }

    @Bean
    public SecurityFilterChain securityFilter(HttpSecurity security) throws Exception {
        List<UrlAppEntity> permitAll = accessibilityUrlService.isPermitAll();
        String[] listUrls;
        if (!permitAll.isEmpty()) {
            listUrls
                    = (String[]) permitAll.stream().map(x -> x.urlComplete).toArray();
        } else {
            listUrls = null;
        }
        return security.csrf().disable()
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(http -> http.requestMatchers("/admin/**")
                        .permitAll()
                        .anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .exceptionHandling(ex -> )
                .build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


}
