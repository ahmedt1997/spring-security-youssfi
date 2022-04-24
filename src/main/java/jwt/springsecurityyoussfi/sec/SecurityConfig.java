package jwt.springsecurityyoussfi.sec;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        ici on specifie les utilisateurs qui ont le droit d'acceder a cette application
        super.configure(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        on specifie les droit d'acces
//        on declare dans un premier temps a spring que tous les utilisateurs ont le droit d'acces
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.authorizeRequests().anyRequest().permitAll();
    }
}
