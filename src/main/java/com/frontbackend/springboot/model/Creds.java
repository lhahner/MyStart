package com.frontbackend.springboot.model;

public class Creds {

    private String groupid;
    private String groupname;

    public Creds(String groupid, String groupname) {
        this.groupid = groupid;
        this.groupname = groupname;
    }

    public String getGroupId() {
        return groupid;
    }

    public void setGroupId(String groupId) {
        this.groupid = groupId;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }
}
