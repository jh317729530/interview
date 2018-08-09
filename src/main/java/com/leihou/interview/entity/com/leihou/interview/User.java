package com.leihou.interview;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "JDBC")
    private String id;

    private String username;

    private String loginid;

    private String password;

    private String mobile;

    private String email;

    private String avatar;

    private Date createTime;

    private Date lastUpdateTime;

    private Date lastLoginTime;

    private Long securityLevel;

    private Long type;

    private static final long serialVersionUID = 1L;
}