package com.payne;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @program: Supply Center
 * @description:
 * @author: Huizhe Yu
 * @create: 2020-03-12 11:28
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.payne.*.mapper"})
public class BootShardingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootShardingApplication.class, args);
    }
}
