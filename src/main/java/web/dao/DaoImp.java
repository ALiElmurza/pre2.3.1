package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class DaoImp {
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getListUsers() {
        Query query = entityManager.createQuery("from User ");
        return query.getResultList();
    }
    @Transactional
    public void save(String name, String lastName) {
        User user = new User();
        user.setFirstName(name);
        user.setLastName(lastName);
        entityManager.persist(user);
    }

    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    public User getUserByID(Long id) {
        String HQL = "from User as user where user.id = :id";
        Query query = entityManager.createQuery(HQL);
        query.setParameter("id", id);
        try {
            return (User) query.getSingleResult();
        } catch (Exception ignore) {

        }
        return null;
    }



}
