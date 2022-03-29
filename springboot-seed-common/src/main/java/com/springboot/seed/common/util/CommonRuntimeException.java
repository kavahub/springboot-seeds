package com.springboot.seed.common.util;

public class CommonRuntimeException extends RuntimeException{

    public CommonRuntimeException() {
    }

    public CommonRuntimeException(String message) {
        super(message);
    }

    public CommonRuntimeException(Throwable cause) {
        super(cause);
    }

    public CommonRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonRuntimeException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
