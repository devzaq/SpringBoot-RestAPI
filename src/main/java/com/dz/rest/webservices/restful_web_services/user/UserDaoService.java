package com.dz.rest.webservices.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static final List<User> users;
    public static int id;

    static{
        id = 0;
        users = new ArrayList<>(
                List.of(
                        new User(++id, "Ankit", LocalDate.now().minusYears(18)),
                        new User(++id, "Ram", LocalDate.of(2002, 10, 5)),
                        new User(++id, "Mandi", LocalDate.now().minusYears(14))
                )
        );
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(int id){
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    public User save(User user){
        user.setId(++id);
        users.add(user);
        return user;
    }

    public void deleteById(int id){
        users.removeIf(user -> user.getId().equals(id));
    }
}
