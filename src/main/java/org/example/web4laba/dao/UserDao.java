package org.example.web4laba.dao;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.web4laba.entity.User;

import java.util.List;


@Stateless
public class UserDao {
    @PersistenceContext(unitName = "default")
    private EntityManager em;

    @PostConstruct
    public void init() {
        System.out.println("EntityManager injected: " + (em != null));
    }

    public List<User> fillAll(){
        return em.createNamedQuery("User.findAll", User.class).getResultList();
    }

    public User find(int id) {
        return em.find(User.class, id);
    }

    public void delete(int id) {
        User User = em.find(User.class, id);
        em.remove(User);
    }

    public void add(User User) {
        em.persist(User);
    }

    public void update(User User) {
        em.merge(User); // Merge changes into persistence context
    }
}
