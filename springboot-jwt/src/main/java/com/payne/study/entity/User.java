package com.payne.study.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: springboot-jwt
 * @description:
 * @author: Payne Yu
 * @create: 2018-09-19 22:24
 */
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String password;

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
