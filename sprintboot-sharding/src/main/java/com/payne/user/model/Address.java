package com.payne.user.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @program: Supply Center
 * @description:
 * @author: Huizhe Yu
 * @create: 2020-03-12 11:01
 */
@Getter
@Setter
@ToString
public class Address {

    private Long id;
    private String code;
    private String name;
    private String pid;
    private Integer type;
    private Integer lit;
}
