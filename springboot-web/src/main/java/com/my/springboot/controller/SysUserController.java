package com.my.springboot.controller;

import com.my.springboot.dao.entity.SysUser;
import com.my.springboot.security.JwtUtil;
import com.my.springboot.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.List;

@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/list")
    public List<SysUser> list(){

        return sysUserService.list();

    }

    @GetMapping("/login")
    public String login(SysUser user) throws ServletException {
        String name = user.getLoginName();
        String pass = user.getPassword();
        if (!"admin".equals(name)) {
            throw new ServletException("no such user");
        }
        if (!"admin".equals(pass)) {
            throw new ServletException("wrong password");
        }
        return JwtUtil.getToken(name);
    }
}
