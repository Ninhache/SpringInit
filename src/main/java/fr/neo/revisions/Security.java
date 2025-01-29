package fr.neo.revisions;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class Security {
    @Bean
    public SecurityFilterChain authorizationFilter(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
        MvcRequestMatcher.Builder mvc = new MvcRequestMatcher.Builder(introspector);
        return http.authorizeHttpRequests((authorize) -> authorize
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
//                        .requestMatchers(mvc.pattern("**")).permitAll()
//                        .requestMatchers(mvc.pattern("api/public/ping")).permitAll()
                        .anyRequest().permitAll()
                )
                .formLogin( Customizer.withDefaults() )
                .logout( customizer ->
                        customizer.logoutSuccessUrl("/public")
                )
                .rememberMe( customizer ->
                        customizer.rememberMeParameter("remember")
                                .useSecureCookie(true)
                )
                .build();
    }

    @Bean
    public JdbcUserDetailsManager users(DataSource datasource) {
        UserDetails user1 = User.withUsername("user")
                .password(encoder().encode("password"))
                .roles("ADMIN")
                .build();

        JdbcUserDetailsManager udm = new JdbcUserDetailsManager(datasource);
        udm.createUser(user1);
        return udm;
    }


    @Bean
    public PasswordEncoder encoder() {
        /* bcrypt                      ldap
           scrypt@SpringSecurity_v5_8  scrypt
           MD4                         SHA-1
           MD5                         SHA-256
           noop                        sha256
           argon2@SpringSecurity_v5_8  argon2
           pbkdf2@SpringSecurity_v5_8  pbkdf2
        */
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}