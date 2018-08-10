package com.leihou.interview.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "hm_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
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