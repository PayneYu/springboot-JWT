package com.payne.user.mapper;

import com.payne.user.model.User;

import java.util.List;

/**
 * @program: Supply Center
 * @description:
 * @author: Huizhe Yu
 * @create: 2020-03-12 11:00
 */
public interface UserMapper {
    /**
     * 保存
     */
    void save(User user);

    /**
     * 查询
     * @param id
     * @return
     */
    User get(Long id);

    List<User> selectAll();
}
