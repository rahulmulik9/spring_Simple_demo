package com.rahul.microservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    //DAO class used to communicate with Database
    private static List<User> users = new ArrayList<>();
    private static int count =0;

    static {
        users.add(new User(++count, "Rahul", LocalDate.now().minusYears(30)));
        users.add(new User(++count, "Abhjit", LocalDate.now().minusYears(20)));
        users.add(new User(++count, "Ram", LocalDate.now().minusYears(25)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }

    public void creatNewUser(User newUser){
        users.add(new User(++count,newUser.getName(),newUser.getBirthDay()));
    }

}
