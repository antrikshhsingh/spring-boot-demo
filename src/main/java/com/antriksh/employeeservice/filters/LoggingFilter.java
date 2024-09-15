package com.antriksh.employeeservice.filters;


/*In Spring Boot, filters and interceptors are powerful tools for adding logic to the request and response cycle.
They can be used for tasks like logging, authentication, request validation, or performance monitoring.
A filter is used to modify the request and response and can be used for things like security,
logging, or changing headers.*/


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoggingFilter implements Filter {

    Logger LOG = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        LOG.info("Inside doFilter Method");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        long startTime = System.currentTimeMillis();
        chain.doFilter(request, response);
        long duration = System.currentTimeMillis() - startTime;

        System.out.println("Request URI: " + req.getRequestURI() + " | Time Taken: " + duration + " ms");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
