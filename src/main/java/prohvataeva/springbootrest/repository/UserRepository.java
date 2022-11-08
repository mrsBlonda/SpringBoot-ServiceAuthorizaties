package prohvataeva.springbootrest.repository;

import org.springframework.stereotype.Component;
import prohvataeva.springbootrest.model.Authorities;
import prohvataeva.springbootrest.model.User;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserRepository {
    public List<Authorities> getUserAuthorities(User user) {
        List<Authorities> authoritiesList = new ArrayList<>();
        if (user.getUser().equals("Anna") && (user.getPassword().equals("Anna"))) {
            authoritiesList.add(Authorities.READ);
        } else if (user.getUser().equals("Maksim") && (user.getPassword().equals("Maksim"))) {
            authoritiesList.add(Authorities.WRITE);
            authoritiesList.add(Authorities.DELETE);
        } else if(user.getUser().equals("Elena") && (user.getPassword().equals("Elena"))) {
            authoritiesList.add(Authorities.WRITE);
            authoritiesList.add(Authorities.READ);
        }
        return authoritiesList;
    }
}
