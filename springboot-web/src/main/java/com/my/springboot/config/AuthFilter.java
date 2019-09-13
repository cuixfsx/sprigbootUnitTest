package com.my.springboot.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthFilter implements Filter {

    private String pageSize = "10";
    private String pageOrder = "asc";

    @Override
    public void destroy() {
        System.out.println("销毁过滤器");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse resposne, FilterChain filter)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("sessionId\t"+req.getSession().getId());
        System.out.println("用户ip\t"+req.getRemoteAddr());
        System.out.println("用户名称\t"+req.getRemoteUser());
        System.out.println("请求编码\t"+req.getCharacterEncoding());
        System.out.println("请求访问地址\t"+req.getRequestURI());


        filter.doFilter(request, resposne);
    }

    @Override
    public void init(FilterConfig filter) throws ServletException {

        this.pageSize =filter.getInitParameter("pageSize");
        this.pageOrder = filter.getInitParameter("pageOrder");

        System.out.println("画面初期化");
        System.out.println("页面大小\t"+pageSize);
        System.out.println("页面排序方式\t"+pageOrder);
    }
}