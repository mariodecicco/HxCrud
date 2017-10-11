/*
 *   File      : User.java
 *   Author    : Mario De Cicco
 *   Created   : 07-Oct-2017
 * 
 *   History
 *     07-Oct-2017 The initial version.
 */
package com.hx.hxcrud.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * 
 */
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
    private BigDecimal id;
    private String email;
    private String forename;
    private String surname;
    private Date dateCreated;

    /**
     * Default Constructor
     */
    public User() {
    }
    
    /**
     * Constructor
     * @param id
     * @param email
     * @param forename
     * @param surname
     * @param dateCreated 
     */
    public User(BigDecimal id, String email, String forename, String surname, 
            Date dateCreated) {
        this.id = id;
        this.email = email;
        this.forename = forename;
        this.surname = surname;
        this.dateCreated = dateCreated;
    }
    
    /**
     * @return the id
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(BigDecimal id) {
        this.id = id;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the forename
     */
    public String getForename() {
        return forename;
    }

    /**
     * @param forename the forename to set
     */
    public void setForename(String forename) {
        this.forename = forename;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the dateCreated
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * @param dateCreated the dateCreated to set
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    
    /**
     * @return copy of user 
     */
    @Override
    public User clone() {
        return new User(id, email, forename, surname, dateCreated);
    }
}
