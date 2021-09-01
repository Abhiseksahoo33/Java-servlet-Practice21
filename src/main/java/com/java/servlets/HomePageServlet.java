package com.java.servlets;

import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class HomePageServlet extends HttpServlet {

    private static final org.slf4j.Logger LOGGER= LoggerFactory.getLogger(HomePageServlet.class);
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.service(req, resp);

        LOGGER.info(this.getClass()+ " Service started ");
        resp.getWriter().write("Home Page");
        Thread currentThread = Thread.currentThread();
        System.out.println("current thread: "+currentThread);


    }
}
