package com.isha.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException
    {
        // on signing up the servlet would do this

        // getting the request
       String name= request.getParameter("username");
       String email= request.getParameter("email");
       String city=  request.getParameter("city");

       // responding to the request
       PrintWriter writer= response.getWriter();
       writer.println("Hello "+name);
       writer.println("I know you are from "+city);
       writer.println("And this is your "+email);

       writer.close();
    }
}
