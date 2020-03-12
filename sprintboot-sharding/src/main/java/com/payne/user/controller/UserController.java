package com.payne.user.controller;

import com.github.pagehelper.PageHelper;
import com.payne.user.mapper.UserMapper;
import com.payne.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @program: Supply Center
 * @description:
 * @author: Huizhe Yu
 * @create: 2020-03-12 11:03
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/save")
    public String save() {
        for (int i = 0; i <10 ; i++) {
            User user=new User();
            user.setName("test"+i);
            user.setSex(i%2==0?"M":"F");
            userMapper.save(user);
        }

        return "success";
    }

    @GetMapping("/get/{id}")
    public User get(@PathVariable Long id) {
        User user =  userMapper.get(id);
        System.out.println(user.getId());
        return user;
    }
    @GetMapping("/all/{pageNumber}/{pageSize}")
    public List<User> selectAll(@PathVariable Integer pageNumber,@PathVariable Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        List<User> list =  userMapper.selectAll();
        return list;
    }
}
