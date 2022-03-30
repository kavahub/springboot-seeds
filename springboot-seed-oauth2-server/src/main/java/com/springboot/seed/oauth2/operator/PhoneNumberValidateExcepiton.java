package com.springboot.seed.oauth2.operator;

import com.springboot.seed.common.util.CommonRuntimeException;

/**
 * 手机号校验异常
 */
public class PhoneNumberValidateExcepiton extends CommonRuntimeException {

    public PhoneNumberValidateExcepiton(String phoneNumber) {
        super(phoneNumber);
    }
    
}
