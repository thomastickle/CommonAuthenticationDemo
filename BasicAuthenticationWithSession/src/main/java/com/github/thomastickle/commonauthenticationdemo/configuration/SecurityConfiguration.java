package com.github.thomastickle.commonauthenticationdemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.DelegatingSecurityContextRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(requests -> requests.requestMatchers("/").permitAll().requestMatchers("/**")
                                                               .authenticated())
                    .securityContext(securityContext -> securityContext.securityContextRepository(new DelegatingSecurityContextRepository(
                            new RequestAttributeSecurityContextRepository(),
                            new HttpSessionSecurityContextRepository()))).formLogin(withDefaults());
        return httpSecurity.build();
    }


}
