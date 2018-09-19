package com.payne.study.repository;

import com.payne.study.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: springboot-jwt
 * @description:
 * @author: Payne Yu
 * @create: 2018-09-19 22:26
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
