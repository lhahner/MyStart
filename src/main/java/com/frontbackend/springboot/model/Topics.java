package com.frontbackend.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "topics")
public class Topics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String topicsid;
    private String topicsinfo;

    public Topics() {}

    public Topics(String topicsid, String topicsinfo) {
        this.topicsid = topicsid;
        this.topicsinfo = topicsinfo;
    }

    public String getTopicId() {
        return topicsid;
    }

    public void setTopicId(String topicsid) {
        this.topicsid = topicsid;
    }

    public String getTopicInfo() {
        return topicsinfo;
    }

    public void setTopicInfo(String topicsinfo) {
        this.topicsinfo = topicsinfo;
    }
}