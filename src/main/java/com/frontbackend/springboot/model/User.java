package com.frontbackend.springboot.model;


import javax.persistence.*;

@Entity
@Table(name="pwd_all")
public class User {

    @Id
    @Column(name="groupid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupid;

    @Column(name="pw")
    private String pw;

    @Column(name="groupname")
    private String groupname;

    //Getter + Setter

    public Long getGroupid() {
        return groupid;
    }

    public void setGroupid(Long groupid) {
        this.groupid = groupid;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }
}
