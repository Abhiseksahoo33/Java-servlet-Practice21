package com.java.servlets;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.service(req, resp);
        String emailValue="abhiseksahoo33@gmail.com";
        String nameValue="Abhisek sahoo";
        resp.getWriter().write(emailValue+nameValue);

    }
}


