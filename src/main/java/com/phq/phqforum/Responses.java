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
@Table(name = "responses")
@NamedQueries({
    @NamedQuery(name = "Responses.findAll", query = "SELECT r FROM Responses r"),
    @NamedQuery(name = "Responses.findById", query = "SELECT r FROM Responses r WHERE r.id = :id"),
    @NamedQuery(name = "Responses.findByResponder", query = "SELECT r FROM Responses r WHERE r.responder = :responder"),
    @NamedQuery(name = "Responses.findByResponderID", query = "SELECT r FROM Responses r WHERE r.responderID = :responderID"),
    @NamedQuery(name = "Responses.findByReponse", query = "SELECT r FROM Responses r WHERE r.reponse = :reponse"),
    @NamedQuery(name = "Responses.findByDate", query = "SELECT r FROM Responses r WHERE r.date = :date")})
public class Responses implements Serializable {

    @Column(name = "Topic")
    private String topic;
    @Column(name = "user")
    private String user;
    @Column(name = "replies")
    private String replies;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "responder")
    private String responder;
    @Column(name = "responderID")
    private String responderID;
    @Column(name = "reponse")
    private String reponse;
    @Column(name = "date")
    private String date;

    public Responses() {
    }

    public Responses(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResponder() {
        return responder;
    }

    public void setResponder(String responder) {
        this.responder = responder;
    }

    public String getResponderID() {
        return responderID;
    }

    public void setResponderID(String responderID) {
        this.responderID = responderID;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
        if (!(object instanceof Responses)) {
            return false;
        }
        Responses other = (Responses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.phq.phqforum.Responses[ id=" + id + " ]";
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getReplies() {
        return replies;
    }

    public void setReplies(String replies) {
        this.replies = replies;
    }
    
}
