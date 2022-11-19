package prohvataeva.springbootrest.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import prohvataeva.springbootrest.model.Authorities;
import prohvataeva.springbootrest.model.User;
import prohvataeva.springbootrest.service.AuthorizationService;
import java.util.List;

@RestController
public class AuthorizationController {
    final private AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Validated User user) {
        return service.getAuthorities(user);
    }


}
