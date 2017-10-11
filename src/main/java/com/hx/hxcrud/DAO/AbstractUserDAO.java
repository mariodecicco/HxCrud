/*
 *   File      : AbstractUserDAO.java
 *   Author    : Mario De Cicco
 *   Created   : 08-Oct-2017
 * 
 *   History
 *     08-Oct-2017 The initial version.
 */
package com.hx.hxcrud.DAO;

import com.hx.hxcrud.model.User;
import java.util.List;

public abstract class AbstractUserDAO {
    
    public abstract List<User> getUsers();
    public abstract void addUser(User user);
    public abstract void updateUser(User user);
    public abstract void deleteUser(User user);
}
