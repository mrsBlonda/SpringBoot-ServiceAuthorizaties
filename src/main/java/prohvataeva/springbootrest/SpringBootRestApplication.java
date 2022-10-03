package prohvataeva.springbootrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import prohvataeva.springbootrest.repository.UserRepository;
import prohvataeva.springbootrest.service.AuthorizationService;

@SpringBootApplication
@EnableWebMvc
public class SpringBootRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestApplication.class, args);
    }

//    @Bean
//    public UserRepository userRepository () {
//        return new UserRepository();
//    }
////нужно ли в параметр сервиса добавлять репозиторий?
//    @Bean
//    public AuthorizationService authorizationService () {
//        return new AuthorizationService();
//    }



}
