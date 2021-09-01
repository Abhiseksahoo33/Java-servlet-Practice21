package com.java.filters;

import com.java.servlets.HomePageServlet;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class ApplicationRequestFilter implements Filter {  // it should implements javax.servlet , there are many filters

    private static final org.slf4j.Logger LOGGER= LoggerFactory.getLogger(ApplicationRequestFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // executes one time only

        LOGGER.info("filter () executed {}","init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // execute every request if url matches (/* )
        LOGGER.info("filter () executed {}","dofilter()");
        System.out.println("before"+ this.getClass());

        //validate / modify request
         filterChain.doFilter(servletRequest,servletResponse); // either to next filter if present or else to the servlet

        //validate /modify response
        System.out.println("after"+ this.getClass());

    }

    @Override
    public void destroy() {
        // only one time executes
        LOGGER.info("filter () executed {}","delete()");
    }
}
