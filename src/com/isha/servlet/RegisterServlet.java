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
    // data corruption but for learning purpose here
    private String storedName;
    private String storedEmail;
    private String storedCity;

    // do post method for sending new data
    @Override
    protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException
    {
        // on signing up the servlet would do this

        // getting the request
        storedName= request.getParameter("username");
       storedEmail= request.getParameter("email");
        storedCity=  request.getParameter("city");

       // responding to the request
       response.getWriter().println("user registered!!");
    }

    // do get method for retrieving the data

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {


        String searchName=req.getParameter("searchName");
        String searchEmail=req.getParameter("searchEmail");
        String searchCity=req.getParameter("searchCity");

        if(storedName != null &&
                storedEmail != null &&
                storedCity != null && searchName.equals(storedName) &&
                searchCity.equals(storedCity) &&
                searchEmail.equals(storedEmail))
        {
            resp.getWriter().println("user found");
        }
        else
        {
            resp.getWriter().println("user not found");
        }
    }
}
