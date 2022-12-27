package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


//@Repository
public class DaoImp implements Dao {
    @PersistenceContext
    EntityManager entityManager;
    private static int ID;
    private static List<User> list = new ArrayList<>();
    @Override
    public List<User> getListUsers() {
        return list;
    }

    public void setUser(String name, String lastName) {
        list.add(new User(name, lastName));
    }

    public User getUserByID(int id) {
        String HQL = "from User as user where user = :id";
        Query query = entityManager.createQuery(HQL);
        query.setParameter("id", id);
        return (User) query.getSingleResult();
    }




}
