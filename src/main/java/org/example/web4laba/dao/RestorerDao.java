package org.example.web4laba.dao;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.web4laba.entity.Restorer;

import java.util.List;


@Stateless
public class RestorerDao {
    @PersistenceContext(unitName = "default")
    private EntityManager em;

    @PostConstruct
    public void init() {
        System.out.println("EntityManager injected: " + (em != null));
    }

    public List<Restorer> fillAll(){
        return em.createNamedQuery("Restorer.findAll", Restorer.class).getResultList();
    }

    public Restorer find(int id) {
        return em.find(Restorer.class, id);
    }

    public void delete(int id) {
        Restorer Restorer = em.find(Restorer.class, id);
        em.remove(Restorer);
    }

    public void add(Restorer Restorer) {
        em.persist(Restorer);
    }

    public void update(Restorer Restorer) {
        em.merge(Restorer); // Merge changes into persistence context
    }
}
