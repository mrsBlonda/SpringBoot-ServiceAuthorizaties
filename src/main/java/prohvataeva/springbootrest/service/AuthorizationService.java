package prohvataeva.springbootrest.service;

import org.springframework.stereotype.Service;
import prohvataeva.springbootrest.exception.InvalidCredentials;
import prohvataeva.springbootrest.exception.UnauthorizedUser;
import prohvataeva.springbootrest.model.Authorities;
import prohvataeva.springbootrest.model.User;
import prohvataeva.springbootrest.repository.UserRepository;

import java.util.List;
@Service
public class AuthorizationService{
    final private UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
