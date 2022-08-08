package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.User;
import java.util.List;

public interface UserService extends UserDetailsService {

    public List<User> listUsers();

    public void addUser(User user);

    public User deleteUser(long id);

    public User changeUser(User user);

    public User getUserById(long id);

}
