package idat.edu.pe;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity  
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails admin = User
            .withUsername("admin@gmail.com")
            .password("$2a$10$58ADReiaGGmODeDx/HwvN.gAfpacaS0/ME0CgvnAZIyTL2Al35fbC")
            .roles("ADMIN")
            .build();

        UserDetails edit = User
            .withUsername("edit@gmail.com")
            .password("$2a$10$G62q3y0wE2K8VxbokksXsOF1/1tuxHd30g.SXnmHSSoTcHWqU.V1K")
            .roles("EDIT")
            .build();

        UserDetails user = User
            .withUsername("user@gmail.com")
            .password("$2a$10$CS7r8ZIB.aKXaPERWxvjXuTtXvAHvHVhpjCPVriqBXHWy8V2xtFZO")
            .roles("USER")
            .build();

        return new InMemoryUserDetailsManager(admin, edit, user);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/dashboard", "/", "/usuario/**", "/prodetalle/**", "/assets/**", "/images/**").permitAll()
        .antMatchers("/rest/**").permitAll()
        .antMatchers("/rest/rol**").permitAll()
        .antMatchers("/rest/rol/**").permitAll()
        .antMatchers("/mecanicaduenas/saveData").permitAll()
        .antMatchers("/saveData").permitAll()
        
        .antMatchers("/empleado/**").hasAnyRole("ADMIN", "EDIT")
        .antMatchers("/garantia/**").hasAnyRole("ADMIN", "EDIT")
        .antMatchers("/producto/**").hasAnyRole("ADMIN", "EDIT")
        .antMatchers("/proveedor/**").hasAnyRole("ADMIN", "EDIT")

        .anyRequest().authenticated()
        .and()
        .logout()
        .and()
        .formLogin(form -> form
        .loginPage("/login")
        .failureUrl("/login?error").permitAll());
    }

}