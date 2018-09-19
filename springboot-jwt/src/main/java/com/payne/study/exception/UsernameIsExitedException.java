package com.payne.study.exception;

/**
 * @program: springboot-jwt
 * @description:
 * @author: Payne Yu
 * @create: 2018-09-19 22:29
 */
public class UsernameIsExitedException extends RuntimeException{

    public UsernameIsExitedException(String msg) {
        super(msg);
    }

    public UsernameIsExitedException(String msg, Throwable t) {
        super(msg, t);
    }
}
