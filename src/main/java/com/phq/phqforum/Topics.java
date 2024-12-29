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
@Table(name = "topics")
@NamedQueries({
    @NamedQuery(name = "Topics.findAll", query = "SELECT t FROM Topics t"),
    @NamedQuery(name = "Topics.findById", query = "SELECT t FROM Topics t WHERE t.id = :id"),
    @NamedQuery(name = "Topics.findByPoster", query = "SELECT t FROM Topics t WHERE t.poster = :poster"),
    @NamedQuery(name = "Topics.findByTopic", query = "SELECT t FROM Topics t WHERE t.topic = :topic"),
    @NamedQuery(name = "Topics.findByDatePosted", query = "SELECT t FROM Topics t WHERE t.datePosted = :datePosted"),
    @NamedQuery(name = "Topics.findByLastPost", query = "SELECT t FROM Topics t WHERE t.lastPost = :lastPost"),
    @NamedQuery(name = "Topics.findByNumViews", query = "SELECT t FROM Topics t WHERE t.numViews = :numViews"),
    @NamedQuery(name = "Topics.findByNumReplies", query = "SELECT t FROM Topics t WHERE t.numReplies = :numReplies")})
public class Topics implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "poster")
    private String poster;
    @Column(name = "topic")
    private String topic;
    @Column(name = "datePosted")
    private String datePosted;
    @Column(name = "lastPost")
    private String lastPost;
    @Column(name = "numViews")
    private String numViews;
    @Column(name = "numReplies")
    private String numReplies;

    public Topics() {
    }

    public Topics(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(String datePosted) {
        this.datePosted = datePosted;
    }

    public String getLastPost() {
        return lastPost;
    }

    public void setLastPost(String lastPost) {
        this.lastPost = lastPost;
    }

    public String getNumViews() {
        return numViews;
    }

    public void setNumViews(String numViews) {
        this.numViews = numViews;
    }

    public String getNumReplies() {
        return numReplies;
    }

    public void setNumReplies(String numReplies) {
        this.numReplies = numReplies;
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
        if (!(object instanceof Topics)) {
            return false;
        }
        Topics other = (Topics) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.phq.phqforum.Topics[ id=" + id + " ]";
    }
    
}
