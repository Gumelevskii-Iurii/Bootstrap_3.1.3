package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface RoleDao {

    public List<Role> listRoles();

    public Role getRoleByName(String name);

    public void addUserRole(User user, String roleAdmin, String roleUser);

}