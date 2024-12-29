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
@Table(name = "bans")
@NamedQueries({
    @NamedQuery(name = "Bans.findAll", query = "SELECT b FROM Bans b"),
    @NamedQuery(name = "Bans.findById", query = "SELECT b FROM Bans b WHERE b.id = :id"),
    @NamedQuery(name = "Bans.findByIp", query = "SELECT b FROM Bans b WHERE b.ip = :ip"),
    @NamedQuery(name = "Bans.findByUsername", query = "SELECT b FROM Bans b WHERE b.username = :username"),
    @NamedQuery(name = "Bans.findByEmail", query = "SELECT b FROM Bans b WHERE b.email = :email"),
    @NamedQuery(name = "Bans.findByReason", query = "SELECT b FROM Bans b WHERE b.reason = :reason")})
public class Bans implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ip")
    private String ip;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "reason")
    private String reason;

    public Bans() {
    }

    public Bans(Integer id) {
        this.id = id;
    }
    
       public Bans(String ip) {
        this.ip = ip;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bans)) {
            return false;
        }
        Bans other = (Bans) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.phq.phqforum.Bans[ id=" + id + " ]";
    }
    
}
