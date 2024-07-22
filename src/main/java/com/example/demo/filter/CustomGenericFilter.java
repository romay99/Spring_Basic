package com.example.demo.filter;

import jakarta.servlet.*;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

public class CustomGenericFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Generic Filter");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
