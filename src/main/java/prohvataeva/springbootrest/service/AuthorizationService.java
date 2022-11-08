package prohvataeva.springbootrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import prohvataeva.springbootrest.exception.InvalidCredentials;
import prohvataeva.springbootrest.exception.UnauthorizedUser;
import prohvataeva.springbootrest.model.Authorities;
import prohvataeva.springbootrest.model.User;
import prohvataeva.springbootrest.repository.UserRepository;

import java.util.List;
@Component
public class AuthorizationService{
    @Autowired
    UserRepository userRepository;

    public List<Authorities> getAuthorities(User user) {
        if (isEmpty(user.getUser()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials();
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
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
