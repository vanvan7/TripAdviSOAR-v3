/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import static Beans.RestaurantSenzu.findByRestaurantName;
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
    
    @PersistenceContext(unitName = "soar_PU")
    private EntityManager em;
    
    private String restaurantname = "";
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
    

    public static Restaurants findByRestaurantName(String restaurantname) throws DoesNotExistException {
        for (Restaurants restaurant : MockDatabase.getInstance().getRestaurant()) {
            if (restaurant.getRestaurantname().equals(restaurantname)) {
                return restaurant;
            }    
        }
        throw new DoesNotExistException("The restaurant " + restaurantname + " does not exist.");
        
     }
    
    protected Restaurants findByRestaurantName() throws DoesNotExistException {
        Query query = em.createNamedQuery("Users.findByRestaurantName", Restaurants.class);
        List<Restaurants> users = query.setParameter("restaurantname", restaurantname).getResultList();
        if (users.size() > 0) {
            return users.get(0);
        }
        throw new DoesNotExistException("The user " + restaurantname + " does not exist.");
    }
    
    public ArrayList<Restaurant> getRestaurant() {
        return MockDatabase.getInstance().getRestaurant();
       
    }
    
    public String getRestaurantname() {
        return restaurantname;
        
    }

    public void setRestaurantname(String restaurantname) {
        this.restaurantname = restaurantname;
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
