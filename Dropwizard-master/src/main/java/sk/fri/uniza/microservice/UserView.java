/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.fri.uniza.microservice;

import io.dropwizard.views.View;
import java.util.List;

/**
 *
 * @author hudik1
 */
public class UserView extends View {

    private User user;
    private List<User> listUser;

    public User getUser() {
        return user;
    }

    public List<User> getListUser() {
        return listUser;
    }

    /**
     * zobrazenie jedneho uzitela na stranke
     * @param person 
     */
    public UserView(User person) {
        super("user.ftl");
        this.user = person;
    }
    
    public UserView() {
        super("user_1.ftl");
    }

    /**
     * zobrazenie listu uzivatela na stranke
     * @param listUser 
     */
    public UserView(List<User> listUser) {
        super("user_1.ftl");
        this.listUser = listUser;
    }

    
    
    
    
}
