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
@Table(name = "topicsSubscribed")
@NamedQueries({
    @NamedQuery(name = "TopicsSubscribed.findAll", query = "SELECT t FROM TopicsSubscribed t"),
    @NamedQuery(name = "TopicsSubscribed.findByUserid", query = "SELECT t FROM TopicsSubscribed t WHERE t.userid = :userid"),
    @NamedQuery(name = "TopicsSubscribed.findByTopicid", query = "SELECT t FROM TopicsSubscribed t WHERE t.topicid = :topicid")})
public class TopicsSubscribed implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "userid")
    private Integer userid;
    @Column(name = "topicid")
    private String topicid;

    public TopicsSubscribed() {
    }

    public TopicsSubscribed(Integer userid) {
        this.userid = userid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getTopicid() {
        return topicid;
    }

    public void setTopicid(String topicid) {
        this.topicid = topicid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TopicsSubscribed)) {
            return false;
        }
        TopicsSubscribed other = (TopicsSubscribed) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.phq.phqforum.TopicsSubscribed[ userid=" + userid + " ]";
    }
    
}
