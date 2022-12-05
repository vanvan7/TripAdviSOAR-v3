/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Exceptions.DoesNotExistException;
import Models.Restaurants;
import java.util.ArrayList;
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
 */
@Named(value = "restaurantSenzu")
@SessionScoped
public class RestaurantSenzu implements Serializable {
    
    @PersistenceContext(unitName = "t_soar_PU")
    private EntityManager em;
    
    private String restaurantName = "";
    private String owner = "";
    private String address = "";
    private String datetime = "";
    private String price = "";
    private String cookingtype = "";
    private String contact = "";
    private String menu = "";
    private String specialdiet = "";
    private Integer ratings;
    private ArrayList<Integer> ratinglist;
    

    
    protected Restaurants findByRestaurantName() throws DoesNotExistException {
        Query query = em.createNamedQuery("Users.findByRestaurantName", Restaurants.class);
        List<Restaurants> users = query.setParameter("restaurantName", restaurantName).getResultList();
        if (users.size() > 0) {
            return users.get(0);
        }
        throw new DoesNotExistException("The user " + restaurantName + " does not exist.");
    }
    
    public List<Restaurants> getRestaurant() {
        List<Restaurants> restaurant = null;
        return restaurant;
       
    }
    
    public String getRestaurantName() {
        return restaurantName;
        
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }
    
    public void setRatings(Integer ratings)  {
        this.ratings=ratings;
    }
    
    public void setRatinglist (ArrayList<Integer> ratinglist){
        this.ratinglist=ratinglist;
    }
    

    public String getOwnerName() {
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
    
    public String getMenu() {
        return menu;
    }
    
    public String getSpecialdiet() {
        return specialdiet;
    }
    
    public Integer getRatings() {
        return ratings;
    }
    
    public ArrayList<Integer> getRatinglist() {
        return ratinglist;
    }
}
