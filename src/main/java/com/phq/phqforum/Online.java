/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phq.phqforum;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author evanredmond
 */
@Entity
@Table(name = "online")
@NamedQueries({
    @NamedQuery(name = "Online.findAll", query = "SELECT o FROM Online o"),
    @NamedQuery(name = "Online.findByUsername", query = "SELECT o FROM Online o WHERE o.username = :username"),
    @NamedQuery(name = "Online.findByOnine", query = "SELECT o FROM Online o WHERE o.onine = :onine")})
public class Online implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "username")
    private Integer username;
    @Column(name = "onine")
    private Integer onine;

    public Online() {
    }

    public Online(Integer username) {
        this.username = username;
    }

    public Integer getUsername() {
        return username;
    }

    public void setUsername(Integer username) {
        this.username = username;
    }

    public Integer getOnine() {
        return onine;
    }

    public void setOnine(Integer onine) {
        this.onine = onine;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Online)) {
            return false;
        }
        Online other = (Online) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.phq.phqforum.Online[ username=" + username + " ]";
    }
    
}
