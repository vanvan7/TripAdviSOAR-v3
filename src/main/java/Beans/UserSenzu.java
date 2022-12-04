/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Exceptions.DoesNotExistException;
import Exceptions.AlreadyExistsException;
import Models.Users;
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
@Named(value = "userSenzu")
@SessionScoped
public class UserSenzu implements Serializable {
    
    @PersistenceContext(unitName = "t_soar_PU")
    private EntityManager em;

    private String username = "";
    private String firstname = "";
    private String lastname = "";
    private String email = "";
    private String password = "";
    
    @Transactional
    public String createAUser() {
        try {
            if (!emailExists() && !usernameExists()) {
                Users newUser = new Users();
                newUser.setUsername(username);
                newUser.setFirstName(firstname);
                newUser.setLastName(lastname);
                newUser.setEmail(email);
                newUser.setPassword(password.hashCode());
                em.persist(newUser);
            } 
        return"/MainPage/LoginPage.xhtml?faces-redirect=true";
            
        } catch (AlreadyExistsException | DoesNotExistException ex) {
            System.out.println(ex.getMessage());
        }
        // empty values
        this.email = "";
        this.username = "";
        this.firstname = "";
        this.lastname = "";
        this.password = "";
       return "/MainPage/LoginPage.xhtml?faces-redirect=true";
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
    
    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
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

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
 
    
}
