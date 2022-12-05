/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Exceptions.DoesNotExistException;
import Exceptions.AlreadyExistsException;
import Models.Restaurants;
import Models.Users;
import java.util.ArrayList;
import java.util.Arrays;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author chris
 *
 */
@Named(value = "restaurantUserSenzu")
@SessionScoped
public class RestaurantUserSenzu implements Serializable {
    
    @PersistenceContext(unitName = "t_soar_PU")
    private EntityManager em;

    private String username = "";
    private String password = "";
    private String email = "";
    private String restaurantName = "";
    private String owner = "";
    private String address = "";
    private String datetime = "";
    private String price = "";
    private String cookingtype = "";
    private String contact = "";
    private String dish = "";
    //----------------------------------------------------added
    private ArrayList<String> menu;
    private ArrayList<String> specialdiet;
    //-----------------------------------------------------added
    @Transactional
    public String createARestaurantUser() {
        try {
            if (!emailExists() && !usernameExists()) {
                Users newUser = new Users();
                newUser.setUsername(username);
                newUser.setPassword(password.hashCode());
                newUser.setEmail(email);
                newUser.setRestaurantName(restaurantName);
                em.persist(newUser);
            } //add to mock databese if User created
            return "/MainPage/LoginPageRestaurant.xhtml?faces-redirect=true";
        } catch (AlreadyExistsException | DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        // empty values
        this.username = "";
        this.password = "";
        this.email = "";
        this.restaurantName = "";
        this.owner = "";
        this.address = "";
        this.datetime = "";
        this.price = "";
        this.cookingtype = "";
        this.contact = "";
        this.dish = "";
        this.menu = new ArrayList<>();
        this.specialdiet = new ArrayList<>();
        
        return "/MainPage/LoginPageRestaurant.xhtml?faces-redirect=true";
    }

    private boolean emailExists() throws AlreadyExistsException {
        Query query = em.createNamedQuery("Users.findByEmail");
        List<Users> users = query.setParameter("email", email).getResultList();
        return users.size() > 0;
    }

    private boolean usernameExists() throws DoesNotExistException {
        Query query = em.createNamedQuery("Users.findByUsername");
        List<Users> users = query.setParameter("username", username).getResultList();
        return users.size() > 0;
    }

    //GET
    public String getEmail() {
        return email;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getOwner() {
        return owner;
    }

    public String getAddress() {
        return address;
    }

    public String getDatetime() {
        return datetime;
    }

    public String getPrice() {
        return price;
    }

    public String getCookingtype() {
        return cookingtype;
    }

    public String getContact() {
        return contact;
    }
    
    public String getDish() {
        return dish;
    }
  

    //public static ArrayList<Menu> getMenu() {
    //    return MockDatabase.getInstance().getMenu();
    //}
    //public static ArrayList<SpecialDiet> getSpecialdiet() {
    //    return MockDatabase.getInstance().getSpecialdiet();
    //}
    //----------------------------------------------added => don't return error on NEtbeans
    public ArrayList<String> getMenu() {
        return menu;
    }

    public ArrayList<String> getSpecialdiet() {
        return specialdiet;
    }

    //---------------------------------------------------added
    //SET
    public void setEmail(String email) {
        this.email = email;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCookingtype(String cookingtype) {
        this.cookingtype = cookingtype;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
    public void setDish(String dish) {
        this.dish = dish;
        setMenu(new ArrayList<String>(Arrays.asList(dish.split(", "))));
    }

    public void setMenu(ArrayList<String> menu) {
        this.menu = menu;
    }

    public void setSpecialdiet(ArrayList<String> specialdiet) {
        this.specialdiet = specialdiet;
    }

    //-----------------------------------------------------------------------added  
}
