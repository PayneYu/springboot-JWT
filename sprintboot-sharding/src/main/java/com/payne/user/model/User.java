package com.payne.user.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @program: Supply Center
 * @description:
 * @author: Huizhe Yu
 * @create: 2020-03-12 11:01
 */
@Getter
@Setter
@ToString
public class User {
    private Long id;
    private String name;
    private Long cityId;
    private String sex;
}
