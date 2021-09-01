package com.java.servlets;

import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletLifeCycle extends HttpServlet {

    public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ServletLifeCycle.class);
    @Override
    public void init() throws ServletException {

        //executes only once
       LOGGER.info("method executed {}" , "init()");
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //executes on every request
        LOGGER.info("method executed {}" , "service()");
        super.service(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("method executed {}" , "doGet()");
        //super.doGet(req, resp);
        resp.getWriter().write("doGet servlet Life cycle");
    }

    @Override
    public void destroy() {

        //executes only once
        LOGGER.info("method executed {}" , "destroy()");
        super.destroy();
    }
}
