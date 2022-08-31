package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> listRoles() {
        return entityManager.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public Role getRoleByName(String name) {
        Role role = null;
        try {
            role = entityManager
                    .createQuery("SELECT r FROM Role r WHERE r.name=:name", Role.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (Exception e) {
            System.out.println("Роли с таким именем не существует!");
        }
        return role;
    }

    @Override
    public void addUserRole(User user, String roleAdmin, String roleUser) {
        Collection<Role> roles = new ArrayList<>();
        if (roleUser != null && roleUser.equals("ROLE_USER") && (roleAdmin != null && roleAdmin.equals("ROLE_ADMIN"))) {
            roles.add(getRoleByName("ROLE_USER"));
            roles.add(getRoleByName("ROLE_ADMIN"));
        } else if (roleAdmin != null && roleAdmin.equals("ROLE_ADMIN")) {
            roles.add(getRoleByName("ROLE_ADMIN"));
        } else if (roleUser != null && roleUser.equals("ROLE_USER")) {
            roles.add(getRoleByName("ROLE_USER"));
        }
        user.setRoles(roles);
    }

}