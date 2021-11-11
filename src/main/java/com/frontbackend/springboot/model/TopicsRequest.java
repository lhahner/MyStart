package com.frontbackend.springboot.model;

public class TopicsRequest {

    private String topicsid;
    private String topicsinfo;

    public TopicsRequest() {
    }

    public String getTopicsid() {
        return topicsid;
    }

    public void setTopicsID(String topicsid) {
        this.topicsid = topicsid;
    }

    public String getTopicsinfo() {
        return topicsinfo;
    }

    public void setTopicsInfo(String topicsinfo) {
        this.topicsinfo = topicsinfo;
    }
}
