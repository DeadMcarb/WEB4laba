package org.example.web4laba;


import jakarta.annotation.PostConstruct;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.web4laba.entity.Painting;


import java.util.List;

@Stateless
public class PaintingDao {

    @PersistenceContext(unitName = "default")
    private EntityManager em;

    @PostConstruct
    public void init() {
        System.out.println("EntityManager injected: " + (em != null));
    }

    public List<Painting> fillAll(){
        return em.createNamedQuery("Painting.findAll", Painting.class).getResultList();
    }

    public Painting find(int id) {
        return em.find(Painting.class, id);
    }

    public void delete(int id) {
        Painting Painting = em.find(Painting.class, id);
        em.remove(Painting);
    }

    public void add(Painting Painting) {
        em.persist(Painting);
    }

    public void update(Painting Painting) {
        em.merge(Painting); // Merge changes into persistence context
    }
}
