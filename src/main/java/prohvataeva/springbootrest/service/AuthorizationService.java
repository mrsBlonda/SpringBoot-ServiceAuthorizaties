package prohvataeva.springbootrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import prohvataeva.springbootrest.exception.InvalidCredentials;
import prohvataeva.springbootrest.exception.UnauthorizedUser;
import prohvataeva.springbootrest.model.Authorities;
import prohvataeva.springbootrest.repository.UserRepository;

import java.util.List;
@Component
public class AuthorizationService{
    @Autowired
    UserRepository userRepository;

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials();
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser();
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
