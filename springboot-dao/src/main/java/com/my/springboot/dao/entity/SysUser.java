package com.my.springboot.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "sys_user")
@Data
public class SysUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  //设置自动增长
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "login_name")
    private String loginName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;




}
