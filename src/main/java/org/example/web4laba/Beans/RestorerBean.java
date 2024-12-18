package org.example.web4laba.Beans;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.example.web4laba.dao.RestorerDao;
import org.example.web4laba.entity.Restorer;

import java.io.Serializable;
import java.util.List;



@Getter
@Setter
@Named
@SessionScoped
public class RestorerBean implements Serializable {

    @EJB
    private org.example.web4laba.dao.RestorerDao RestorerDao;


    private org.example.web4laba.entity.Restorer Restorer = new Restorer();

    public List<Restorer> getRestorers() {
        return RestorerDao.fillAll();
    }

    public String showOrders(int id) {
        Restorer = RestorerDao.find(id);
        return "orders";
    }

    public void delete(int id) {
        RestorerDao.delete(id);
    }

    public void add() {
        RestorerDao.add(Restorer);
        Restorer = new Restorer();
    }



    public String editById(int id) {
        Restorer = RestorerDao.find(id);
        return "edit_restorer.xhtml";
    }

    public String update() {
        RestorerDao.update(Restorer); // Update Restorer in the database
        Restorer = new Restorer(); // Reset the form
        return "index.xhtml?faces-redirect=true";
    }

    public String cancelEdit() {
        Restorer = new Restorer(); // Reset the form
        return "index.xhtml?faces-redirect=true";
    }
}
