package prohvataeva.springbootrest.repository;

import org.springframework.stereotype.Component;
import prohvataeva.springbootrest.model.Authorities;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authoritiesList = new ArrayList<>();
        if (user.equals("Anna") && (password.equals("Anna"))) {
            authoritiesList.add(Authorities.READ);
        } else if (user.equals("Maksim") && (password.equals("Maksim"))) {
            authoritiesList.add(Authorities.WRITE);
            authoritiesList.add(Authorities.DELETE);
        }
        return authoritiesList;
    }
}
