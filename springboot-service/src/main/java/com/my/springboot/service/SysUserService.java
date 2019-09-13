package com.my.springboot.service;

import com.my.springboot.dao.SysUserRepository;
import com.my.springboot.dao.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    public List<SysUser> list(){

        return sysUserRepository.findAll();

    }
}
