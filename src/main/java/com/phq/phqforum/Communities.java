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
@Table(name = "communities")
@NamedQueries({
    @NamedQuery(name = "Communities.findAll", query = "SELECT c FROM Communities c"),
    @NamedQuery(name = "Communities.findByCommunity", query = "SELECT c FROM Communities c WHERE c.community = :community"),
    @NamedQuery(name = "Communities.findById", query = "SELECT c FROM Communities c WHERE c.id = :id")})
public class Communities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "community")
    private Integer community;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;

    public Communities() {
    }

    public Communities(String id) {
        this.id = id;
    }

    public Integer getCommunity() {
        return community;
    }

    public void setCommunity(Integer community) {
        this.community = community;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        if (!(object instanceof Communities)) {
            return false;
        }
        Communities other = (Communities) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.phq.phqforum.Communities[ id=" + id + " ]";
    }
    
}
