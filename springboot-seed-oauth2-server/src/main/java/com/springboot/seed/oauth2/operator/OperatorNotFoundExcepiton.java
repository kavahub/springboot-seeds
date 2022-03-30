package com.springboot.seed.oauth2.operator;

import com.springboot.seed.common.util.CommonRuntimeException;

/**
 * 操作员不存在异常
 */
public class OperatorNotFoundExcepiton extends CommonRuntimeException {

    public OperatorNotFoundExcepiton(String message) {
        super(message);
    }
    
}
