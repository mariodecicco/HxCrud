/*
 *   File      : UserService.java
 *   Author    : Mario De Cicco
 *   Created   : 09-Oct-2017
 * 
 *   History
 *     09-Oct-2017 The initial version.
 */
package com.hx.hxcrud.service;

import com.hx.hxcrud.model.User;
import com.hx.hxcrud.DAO.UserDAO;
import java.math.BigDecimal;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 */
@ManagedBean
@SessionScoped
@Path("/users")
public class UserService {
    private static UserDAO userDAO = new UserDAO();
    private User user = new User();
    boolean editUser = false;
    
    /**
     * @return list of all users 
     */
    public List<User> getUsers() {
        return userDAO.getUsers();
    }
    
    /**
     * @return the currently selected user
     */
    public User getUser() {
        return this.user;
    }
    
    /**
     * add the current user
     */
    public void addUser() {
        userDAO.addUser(user);
        user = new User();
    }
    
    /**
     * Clear the current user
     */
    public void cancelUser() {
        user = new User();
        editUser = false;
    }
    
    /**
     * @param item set the current user to a copy of the selected user
     */
    public void editUser(User item) {
        user = item.clone();
        editUser = true;
    }
    
    /**
     * @return is the current user being edited 
     */
    public boolean isEditUser() {
        return editUser;
    }
    
    /**
     * update the list with the current user
     */
    public void updateUser() {
        userDAO.updateUser(user);
        cancelUser();
    }
    
    /**
     * 
     * @param item the user to delete
     */
    public void deleteUser(User item) {
        userDAO.deleteUser(item);
    }
    
    /**
     * @return list of all users in XML
     */
    @GET
    @Produces({ MediaType.APPLICATION_XML })
    public List<User> getUsers_XML() {
        return getUsers();
    }
    
    /**
     * @param userId
     * @return XML for user required
     */
    @GET
    @Path("/{userId}")
    @Produces({ MediaType.APPLICATION_XML })
    public User getUser(@PathParam("userId") BigDecimal userId) {
        return userDAO.getUserById(userId);
    }
    
    /**
     * @param user add the user
     * @return the XML user list
     */
    @POST
    @Produces({ MediaType.APPLICATION_XML })
    public List<User> addUser(User user) {
        userDAO.addUser(user);
        return getUsers();
    }

    /**
     * @param user user to update
     * @return the XML user list
     */
    @PUT
    @Produces({ MediaType.APPLICATION_XML })
    public List<User> updateUser(User user) {
        userDAO.updateUser(user);
        return getUsers();
    }

    /**
     * @param userId id of the user to remove 
     */
    @DELETE
    @Path("/{userId}")
    @Produces({ MediaType.APPLICATION_XML })
    public void deleteUser(@PathParam("userId") BigDecimal userId) {
        User userToDelete = userDAO.getUserById(userId);
        userDAO.deleteUser(userToDelete);
    }
}
