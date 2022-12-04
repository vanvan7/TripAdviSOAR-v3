/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Exceptions.DoesNotExistException;
import Models.Restaurants;
import Models.Users;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author chris
 **/
@Named(value = "loginSenzu")
@SessionScoped
public class LoginSenzu implements Serializable {
    
    @PersistenceContext(unitName = "t_soar_PU")
    private EntityManager em;

    private String username = "";
    private String password = "";
    private String restaurantname = "";
    private Users currentUser;
    private Restaurants currentRestaurant;

    public String userLogsIn() {
        try {
            Users user = findByUsername();
            if (user != null && user.isPasswordCorrect(password)) {
                currentUser = user;
                return "/UserPage/UserMainPage.xhtml?faces-redirect=true";
            }             
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return "/MainPage/LoginPage.xhtml?faces-redirect=true";
    }
    protected Users findByUsername() throws DoesNotExistException {
        Query query = em.createNamedQuery("Users.findByUsername", Users.class);
        List<Users> users = query.setParameter("username", username).getResultList();
        if (users.size() > 0) {
            return users.get(0);
        }
        throw new DoesNotExistException("The user " + username + " does not exist.");
    }
    
    public void restaurantLogsIn(){
        try {
            Restaurants restaurant = findByRestaurantName();
            if (restaurant != null){
                currentRestaurant = restaurant;
                System.out.println(this.getCurrentRestaurant().toString());
        
            }
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }

    }
        protected Restaurants findByRestaurantName() throws DoesNotExistException {
        Query query = em.createNamedQuery("Restaurants.findByRestaurantName", Restaurants.class);
        List<Restaurants> users = query.setParameter("restaurantname", restaurantname).getResultList();
        if (users.size() > 0) {
            return users.get(0);
        }
        throw new DoesNotExistException("The user " + restaurantname + " does not exist.");
    }
    
    public String RestaurantLogIn() {
        try {
            Users user = findByUsername();
            if (user != null && user.isPasswordCorrect(password)) {
                currentUser = user;
                currentRestaurant = findByRestaurantName();
                return "/RestaurantPage/RestaurantMainPage.xhtml?faces-redirect=true";
            }          
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return "LoginPageRestaurant.xhtml?faces-redirect=true";
    }
    
    

    public String userLogsout() {
        currentUser = null;
        return "/MainPage/MainPage.xhtml?faces-redirect=true";
    }

    public Users getCurrentUser() {
        return currentUser;
    }
    
    public Restaurants getCurrentRestaurant(){
        return currentRestaurant;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
    
     public String getRestaurantname() {
        return restaurantname;
    }
    public void setCurrentUser(Users currentUser) {
        this.currentUser = currentUser;
    }
    
    public void setCurrentRestaurant(Restaurants currentRestaurant) {
        this.currentRestaurant = currentRestaurant;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setRestaurantname(String restaurantname){
        this.restaurantname = restaurantname;
    }
    
}