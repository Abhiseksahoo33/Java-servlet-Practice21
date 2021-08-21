package com.java.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AboutUsServlet extends HttpServlet {

    // browser -> machine IP -> process (8080) -> application ( servlet-helloworld )->   filter (s) -> servlet

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.service(req, resp);


        System.out.println(this.getClass()+"services method");
    resp.getWriter().write("About Us Page ");
    }
}
