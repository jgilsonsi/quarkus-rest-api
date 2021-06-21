package com.jgdev.service;

import com.jgdev.model.User;
import com.jgdev.repository.UserRepository;
import io.quarkus.elytron.security.common.BcryptUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

import static com.jgdev.enums.RoleType.ADMIN_ROLE;
import static com.jgdev.enums.RoleType.USER_ROLE;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    public void create(User user) {
        user.setPassword(BcryptUtil.bcryptHash(user.getPassword()));
        user.setRole(validateUsername(user.getUsername()));
        userRepository.persist(user);
    }

    public List<User> getAll() {
        return userRepository.listAll();
    }

    private String validateUsername(String username) {
        return username.equals("jgilson") ? ADMIN_ROLE : USER_ROLE;
    }
}
