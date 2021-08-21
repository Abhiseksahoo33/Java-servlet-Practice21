package com.java.filters;

        import javax.servlet.*;
        import java.io.IOException;

public class HomePageRequestFilter implements Filter {  // it should implements javax.servlet , there are many filters


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // executes one time only
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // execute every request if url matches (/* )
        System.out.println("before"+ this.getClass());

        //validate / modify request
        filterChain.doFilter(servletRequest,servletResponse); // either to next filter if present or else to the servlet

        //validate /modify response
        System.out.println("after"+ this.getClass());

    }

    @Override
    public void destroy() {
        // only one time executes
    }
}
