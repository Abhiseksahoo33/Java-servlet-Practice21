package com.java.servlets;

import com.java.jackson.JacksonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPost(req, resp);
        InputStream is= req.getInputStream();
        //System.out.println("is type "+is.getClass());
        SignUpServlet.User LoginUserRequest= JacksonUtils.toObject(is, SignUpServlet.User.class);

       SignUpServlet.User registeredUser= SignUpServlet.emailUserMapping.get(LoginUserRequest.getEmail());

       boolean LoginSuccess=false;

        if (registeredUser!=null){
            if (LoginUserRequest.getPassword().equals(registeredUser.getPassword()))
            {
                LoginSuccess=true;
            }
        }
        if (LoginSuccess)
        {
            resp.getWriter().write("login Success");
            resp.setHeader("Autherization", getAuthHeader(registeredUser));
        }
        else
        {
            resp.getWriter().write("Login Failed !");
        }

      resp.getWriter().write("Login Se=uccessful!");
    }
    public static String getAuthHeader(SignUpServlet.User user)
    {
        String email=user.getEmail();

        //logic
        return  email;
    }

}
