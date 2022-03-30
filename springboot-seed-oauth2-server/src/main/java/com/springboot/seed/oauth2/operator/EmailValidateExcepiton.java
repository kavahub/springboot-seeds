package com.springboot.seed.oauth2.operator;

import com.springboot.seed.common.util.CommonRuntimeException;

/**
 * 邮箱校验异常
 */
public class EmailValidateExcepiton extends CommonRuntimeException {

    public EmailValidateExcepiton(String email) {
        super(email);
    }
    
}
