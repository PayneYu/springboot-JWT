package com.payne.study.component;

/**
 * @program: springboot-jwt
 * @description:
 * @author: Payne Yu
 * @create: 2018-09-19 23:24
 */
public class CustomGrantedAuthority implements org.springframework.security.core.GrantedAuthority {
    private String authority;

    public CustomGrantedAuthority(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
