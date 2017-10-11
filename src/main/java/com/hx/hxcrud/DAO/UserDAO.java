/*
 *   File      : UserDAO.java
 *   Author    : Mario De Cicco
 *   Created   : 08-Oct-2017
 * 
 *   History
 *     08-Oct-2017 The initial version.
 */
package com.hx.hxcrud.DAO;

import com.hx.hxcrud.DAO.AbstractUserDAO;
import com.hx.hxcrud.model.User;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO extends AbstractUserDAO{
    private Map<BigDecimal, User> userList;
    private static BigDecimal id = new BigDecimal(1L);

    /**
     * Default constructor
     */
    public UserDAO() {
    }
    
    /**
     * @return list of all users
     */
    @Override
    public List<User> getUsers() {
        if(userList == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(userList.values());
    }
    
    /**
     * @param user the user to add
     */
    @Override
    public void addUser(User user) {
        if(userList == null) {
            userList = new HashMap<>();
        }
        user.setId(id);
        user.setDateCreated(Calendar.getInstance().getTime());
        userList.put(user.getId(), user);
        id = id.add(new BigDecimal(1L));
    }
    
    /**
     * @param user the user to update
     */
    @Override
    public void updateUser(User user) {
        userList.replace(user.getId(), user);
    }
    
    /**
     * @param user the user to delete 
     */
    @Override
    public void deleteUser(User user) {
        if(userList != null) {
            userList.remove(user.getId());
        }
    }
    
    /**
     * @param id id to locate
     * @return user
     */
    public User getUserById(BigDecimal id) {
        return userList.get(id);
    }
}
