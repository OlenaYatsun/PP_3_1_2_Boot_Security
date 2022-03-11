package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Role getRoleById(int id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public void save(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void update( Role updatedRole) {
        entityManager.merge(updatedRole);
    }

    @Override
    public void delete(int id) {
        entityManager.createQuery("delete from Role role where role.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public List<Role> getDemandedRoles() {
        List<Role> list1 = entityManager.createQuery("select role from Role role", Role.class).getResultList();
        return list1;
    }

   /* @Override
    public Role getRoleByName(String roleName) {
        return (Role) entityManager.createQuery("select from Role role where role.name=:role")
                .setParameter("role", roleName)
                .getSingleResult();
    }

    @Override
    public Set<Role> setRoleByName(String name, String[] rolesName) {
        Set<Role> roleSet = new HashSet<Role>();
        if (rolesName != null) {
            for (String roleName : rolesName) {
                roleSet.add(getRoleByName(roleName));
            }
        }
        return roleSet;
    }

    */
}
