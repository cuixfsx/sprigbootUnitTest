package com.my.springboot.config;

import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@ServletComponentScan扫描Servlet组件时 ,
//Servlet、过滤器和监听器可以是通过@WebServlet、@WebFilter和@WebListener自动注册

@WebFilter(filterName="encoderFilter",urlPatterns="/*")
public class EncoderFilter implements Filter {

    @Override
    public void destroy() {
        System.out.println("销毁过滤器");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse resposne, FilterChain filter)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("sessionId\t"+req.getSession().getId());
        System.out.println(req.getRemoteAddr()+"设定编码");
        request.setCharacterEncoding("UTF-8");
        filter.doFilter(request, resposne);
    }

    @Override
    public void init(FilterConfig filter) throws ServletException {
        System.out.println("画面初期化");
    }
}
