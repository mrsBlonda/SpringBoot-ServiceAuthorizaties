package prohvataeva.springbootrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import prohvataeva.springbootrest.model.Authorities;
import prohvataeva.springbootrest.model.User;
import prohvataeva.springbootrest.service.AuthorizationService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AuthorizationController {
    @Autowired
    AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Validated User user) {
        return service.getAuthorities(user);
    }


}
