package org.example.web4laba.Beans;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.example.web4laba.dao.UserDao;
import org.example.web4laba.entity.User;

import java.io.Serializable;
import java.util.List;



@Getter
@Setter
@Named
@SessionScoped
public class UserBean implements Serializable {

    @EJB
    private UserDao UserDao;


    private User User = new User();

    public List<User> getUsers() {
        return UserDao.fillAll();
    }

    public String showOrders(int id) {
        User = UserDao.find(id);
        return "orders";
    }

    public void delete(int id) {
        UserDao.delete(id);
    }

    public void add() {
        UserDao.add(User);
        User = new User();
    }



    public String editById(int id) {
        User = UserDao.find(id);
        return "edit_user.xhtml";
    }

    public String update() {
        UserDao.update(User); // Update User in the database
        User = new User(); // Reset the form
        return "index.xhtml?faces-redirect=true";
    }

    public String cancelEdit() {
        User = new User(); // Reset the form
        return "index.xhtml?faces-redirect=true";
    }
}
