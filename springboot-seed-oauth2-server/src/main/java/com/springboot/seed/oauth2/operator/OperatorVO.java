package com.springboot.seed.oauth2.operator;

import java.io.Serializable;

import lombok.Data;

@Data
public class OperatorVO implements Serializable {

    private String id;

    private String username;

    private String nickname;

    private String email;
}
