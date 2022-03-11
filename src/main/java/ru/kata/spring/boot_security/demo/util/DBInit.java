package ru.kata.spring.boot_security.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public DBInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @Override
    public void run(String... args) {
        Role role1 = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_USER");
        roleService.save(role1);
        roleService.save(role2);

        List<Role> u1roles = new ArrayList<>();
        u1roles.add(role2);
        u1roles.add(role1);
        User user1 = new User("admin", "Olga", 29, "admin",u1roles);
        User user2 = new User("user", "Ivan", 35, "user", u1roles);

        userService.saveUser(user1);
        userService.saveUser(user2);
    }
}