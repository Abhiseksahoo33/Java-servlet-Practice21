package com.java.servlets;

import com.java.jackson.JacksonUtils;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class SignUpServlet extends HttpServlet {


    public static class User{
        private String email;
        private String password;
        private String fullName;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }
    }

    public static Map<String,User> emailUserMapping = new HashMap<>();


    @Override
    public void init() throws ServletException {
       // super.init();
    User U1 = new User();
    U1.setEmail("U1@gmail.com");
    U1.setFullName("Abhisek Sahoo");
    U1.setPassword("abcd");
    emailUserMapping.putIfAbsent(U1.getEmail(),U1);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPost(req, resp);
        InputStream is= req.getInputStream();
        //System.out.println("is type "+is.getClass());
        User e= JacksonUtils.toObject(is,User.class);
       emailUserMapping.putIfAbsent(e.getEmail(),e);

       resp.getWriter().write("user registered "+emailUserMapping.size());
    }
}
