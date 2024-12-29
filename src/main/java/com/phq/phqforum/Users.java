/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phq.phqforum;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author evanredmond
 */
@Entity
@Table(name = "users")
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByAccessLevel", query = "SELECT u FROM Users u WHERE u.accessLevel = :accessLevel"),
    @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username"),
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"),
    @NamedQuery(name = "Users.findByIp", query = "SELECT u FROM Users u WHERE u.ip = :ip"),
    @NamedQuery(name = "Users.findByEmailSetting", query = "SELECT u FROM Users u WHERE u.emailSetting = :emailSetting"),
    @NamedQuery(name = "Users.findByLastVisit", query = "SELECT u FROM Users u WHERE u.lastVisit = :lastVisit")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "AccessLevel")
    private Integer accessLevel;
    @Column(name = "username")
    private String username;
    @Lob
    @Column(name = "password")
    private byte[] password;
    @Column(name = "email")
    private String email;
    @Column(name = "id")
    private String id;
    @Column(name = "ip")
    private String ip;
    @Column(name = "emailSetting")
    private String emailSetting;
    @Column(name = "lastVisit")
    private String lastVisit;

    public Users() {
    }

    public Users(Integer accessLevel) {
        this.accessLevel = accessLevel;
    }

    public Integer getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(Integer accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getEmailSetting() {
        return emailSetting;
    }

    public void setEmailSetting(String emailSetting) {
        this.emailSetting = emailSetting;
    }

    public String getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(String lastVisit) {
        this.lastVisit = lastVisit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessLevel != null ? accessLevel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.accessLevel == null && other.accessLevel != null) || (this.accessLevel != null && !this.accessLevel.equals(other.accessLevel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.phq.phqforum.Users[ accessLevel=" + accessLevel + " ]";
    }
    
}
