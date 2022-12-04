/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author srivathshanparamalingam
 */
@Entity
@Table(name = "users")
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUserId", query = "SELECT u FROM Users u WHERE u.userId = :userId"),
    @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username"),
    @NamedQuery(name = "Users.findByFirstName", query = "SELECT u FROM Users u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "Users.findByRestaurantName", query = "SELECT u FROM Users u WHERE u.restaurantName = :restaurantName"),
    @NamedQuery(name = "Users.findByLastName", query = "SELECT u FROM Users u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")})
public class Users implements Serializable {

    @Size(max = 50)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 50)
    @Column(name = "FIRST_NAME")
    private String firstname;
    @Size(max = 50)
    @Column(name = "RESTAURANT_NAME")
    private String restaurantname;
    @Size(max = 50)
    @Column(name = "LAST_NAME")
    private String lastname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USER_ID")
    private Integer userId;
    @Column(name = "PASSWORD")
    private Integer password;
    @JoinTable(name = "user_rates_restaurants", joinColumns = {
        @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "RESTAURANT_ID", referencedColumnName = "RESTAURANT_ID")})
    @ManyToMany
    private Collection<Restaurants> restaurantsCollection;

    public Users() {
    }

    public Users(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public String getRestaurantName() {
        return restaurantname;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantname = restaurantName;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }
    
      public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Restaurants> getRestaurantsCollection() {
        return restaurantsCollection;
    }

    public void setRestaurantsCollection(Collection<Restaurants> restaurantsCollection) {
        this.restaurantsCollection = restaurantsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Users) obj).getUsername().equals(this.username);
    }

   @Override
    public String toString() {
        String S="";
        if (restaurantname==null){
            S=  "Username: " + this.username
                    + "\nFirst name: " + this.firstname
                    + "\nLast name: " + this.lastname
                    + "\nEmail: " + this.email;  
            
          } else{
            S= "Username: " + this.username
                    + "\nRestaurant Name: " + this.restaurantname
                    + "\nEmail: " + this.email;   
            
            
//            for (int r=0; r<MockDatabase.restaurants.size();r++){
//                       if (restaurantname == MockDatabase.restaurants.get(r).getRestaurantname()){
//                           S = S + MockDatabase.restaurants.get(r).toString();
//                       }                      
//            }              
        }
        return S; 
    }

}
