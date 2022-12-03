/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Exceptions.DoesNotExistException;
import Exceptions.AlreadyExistsException;
import Database.MockDatabase;
import Models.User;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author chris
 */
@Named(value = "userSenzu")
@SessionScoped
public class UserSenzu implements Serializable {

    private String username = "";
    private String firstname = "";
    private String lastname = "";
    private String email = "";
    private String password = "";
    
    
    public void createAUser() {
        try {
            if (!emailExists() && !usernameExists()) {
                MockDatabase.getInstance().addAUser(new User(username, firstname, lastname, email, password));
            } //add to mock databese if User created
        } catch (AlreadyExistsException | DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        // empty values
        this.email = "";
        this.username = "";
        this.firstname = "";
        this.lastname = "";
        this.password = "";
    }    


    protected static User findByUsername(String username) throws DoesNotExistException {
        for (User user : MockDatabase.getInstance().getUsers()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        throw new DoesNotExistException("The user " + username + " does not exist.");
    }

    
    private boolean emailExists() throws AlreadyExistsException {
        for (User user : MockDatabase.getInstance().getUsers()) {
            if (user.getEmail().equals(email)) {
                throw new AlreadyExistsException("The email " + email + " already in use.");
            }
        }
        return false;
    }

    private boolean usernameExists() throws DoesNotExistException {
        for (User user : MockDatabase.getInstance().getUsers()) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
        
    }
    
    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
 
    
}
