package com.springboot.seed.oauth2.operator;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * 操作员
 */
@Data
@Entity(name = "SBS_OPERATOR")
@GenericGenerator(name = "UUID", strategy = "uuid")
public class Operator implements Serializable {

    /** 用户ID */
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(length = 32)
    private String id;

    @Version
    private Integer version;

    /** 用户名 */
    @Column(length = 32, unique = true, updatable = false, nullable = false)
    private String username;

    /** 密码 */
    @Column(length = 255)
    private String password;

    /** 昵称 */
    @Column(length = 255, nullable = false)
    private String nickname;

    /** 邮箱 */
    @Column(length = 255, nullable = false)
    private String email;

    public Operator() {
    }

    public Operator(String username, String nickname, String email) {
        this.username = username;
        this.email = email;
        this.nickname = nickname;
    }

    @PrePersist
    @PreUpdate
    public void setDefualt() {
        if (username != null) {
            username = username.toUpperCase();
        }
        if (version == null) {
            version = 0;
        }
    }
}
