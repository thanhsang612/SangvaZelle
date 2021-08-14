package love;

import java.util.NoSuchElementException;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import love.entity.Account;

import love.service.AccountService;


@Configuration 
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean
    @Override
    public UserDetailsService userDetailsService() {
        // Tạo ra user trong bộ nhớ
        // lưu ý, chỉ sử dụng cách này để minh họa
        // Còn thực tế chúng ta sẽ kiểm tra user trong csdl
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(
                User.withDefaultPasswordEncoder() // Sử dụng mã hóa password đơn giản
                    .username("sang612")
                    .password("12021202")
                    .roles("ADMIN") // phân quyền là người dùng.
                    .build()
        );
        return manager;
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/create").authenticated() // Cho phép tất cả mọi người truy cập vào 2 địa chỉ này
                    .anyRequest().permitAll() // Tất cả các request khác đều cần phải xác thực mới được truy cập
                    .and()
                .formLogin() // Cho phép người dùng xác thực bằng form login
                    .defaultSuccessUrl("/")
                    .permitAll() // Tất cả đều được truy cập vào địa chỉ này
                    .and()
                .logout() // Cho phép logout
                    .permitAll();
    }
	
}
