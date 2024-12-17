package org.example.web4laba;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.example.web4laba.dao.ArtistDao;
import org.example.web4laba.dao.PaintingDao;
import org.example.web4laba.entity.Painting;


import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Named
@SessionScoped
public class PaintingBean implements Serializable {

    @EJB
    private PaintingDao paintingDao;

    @EJB
    private ArtistDao artistDao;

    private Painting painting = new Painting();

    public List<Painting> getPaintings() {
        return paintingDao.fillAll();
    }

    public String showOrders(int id) {
        painting = paintingDao.find(id);
        return "orders";
    }

    public void delete(int id) {
        paintingDao.delete(id);
    }

    public void add() {
        paintingDao.add(painting);
        painting = new Painting();
    }



    public String editById(int id) {
        painting = paintingDao.find(id);
        return "edit_painting.xhtml";
    }

    public String update() {
        paintingDao.update(painting); // Update Painting in the database
        painting = new Painting(); // Reset the form
        return "index.xhtml?faces-redirect=true";
    }

    public String cancelEdit() {
        painting = new Painting(); // Reset the form
        return "index.xhtml?faces-redirect=true";
    }
}
