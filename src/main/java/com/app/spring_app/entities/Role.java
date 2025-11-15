package com.app.spring_app.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleid;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    public Role() {}

    public Role(Long roleid, String name) {
        this.roleid = roleid;
        this.name = name;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role [roleid=" + roleid + ", name=" + name + "]";
    }
}
