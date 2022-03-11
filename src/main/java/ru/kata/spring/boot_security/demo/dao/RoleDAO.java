package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

public interface RoleDAO {
    Role getRoleById(int id);
    void save(Role role);
    void update(Role updatedRole);
    void delete(int id);
    List<Role> getDemandedRoles();
}
