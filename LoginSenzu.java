/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Exceptions.DoesNotExistException;
import Models.Restaurant;
import Models.User;
import static Beans.UserSenzu.findByUsername;
import static Beans.RestaurantSenzu.findByRestaurantName;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author chris
 */
@Named(value = "loginSenzu")
@SessionScoped
public class LoginSenzu implements Serializable {

    private String username = "";
    private String password = "";
    private static String restaurantname = "";
    private static User currentUser;
    private static Restaurant currentRestaurant;

    public String userLogsIn() {
        try {
            User user = findByUsername(username);
            if (user != null && user.isPasswordCorrect(password)) {
                currentUser = user;
                return "/UserPage/UserMainPage.xhtml?faces-redirect=true";
            }
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        return "/MainPage/LoginPage.xhtml?faces-redirect=true";
    }
    
    public static void restaurantLogsIn(){
        try {
            Restaurant restaurant = findByRestaurantName (restaurantname);
            if (restaurant != null){
                currentRestaurant = restaurant;
                System.out.println(LoginSenzu.getCurrentRestaurant().toString());

            }
        } catch (DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void userLogsout() {
        currentUser = null;
    }

    public static User getUserLoggedIn() {
        return currentUser;
    }
    
    public static Restaurant getCurrentRestaurant(){
        return currentRestaurant;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public static void setCurrentUser(User currentUser) {
        LoginSenzu.currentUser = currentUser;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public static void setRestaurantName(String restaurantname){
        LoginSenzu.restaurantname = restaurantname;
    }
    
    
}
