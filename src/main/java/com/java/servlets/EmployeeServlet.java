package com.java.servlets;

import com.java.jackson.JacksonUtils;
import com.java.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //  super.doGet(req, resp);

        Employee e= new Employee();
        e.setAge(20);
        e.setName("Abhisek");
        e.setUuid(UUID.randomUUID().toString());

        String json= JacksonUtils.toJson(e);
       // resp.getWriter().write(json);

        InputStream  is= req.getInputStream();
        System.out.println("is type "+is.getClass());
        e= JacksonUtils.toObject(is,Employee.class);
        resp.getWriter().write(e.getName()+"GET");

    }
//create (body)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        InputStream  is= req.getInputStream();
        System.out.println("is type "+is.getClass());
        Employee e= JacksonUtils.toObject(is,Employee.class);
        resp.getWriter().write(e.getName());

    }
//update (body , id)
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPut(req, resp);

        String id=req.getParameter("empId");
        InputStream  is= req.getInputStream();
        System.out.println("is type "+is.getClass());
        Employee e= JacksonUtils.toObject(is,Employee.class);
        resp.getWriter().write(e.getName()+" PUT "+id);
    }
//delete(body,id)
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doDelete(req, resp);
        String id=req.getParameter("empId");
        InputStream  is= req.getInputStream();
        System.out.println("is type "+is.getClass());
        Employee e= JacksonUtils.toObject(is,Employee.class);
        resp.getWriter().write(e.getName()+" DELETE "+id);
    }
}
