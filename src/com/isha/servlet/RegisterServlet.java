package com.isha.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;

import static java.lang.Class.forName;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet
{/*
    // data corruption but for learning purpose here
    private String storedName;
    private String storedEmail;
    private String storedCity;
    */

    // do post method for sending new data
    @Override
    protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException
    {
        // on signing up the servlet would do this

        // getting the request
       String storedName= request.getParameter("username");
        String storedEmail= request.getParameter("email");
        String storedCity=  request.getParameter("city");


        // connectiong to the database and storing these there
try {
    // this loads the MySQL JDBC driver.
    Class.forName("com.mysql.cj.jdbc.Driver");
    // Connection
    Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/tomcatregistrationdb",
            "root",
            "Lovealarm@123"
    );

    // query
    // username, email, and city must match the column names in your database table, not the servlet variable names.
    String query = "INSERT INTO registrationdata(username,email,city) VALUES(?,?,?)";
    // PreparedStaement for safety
    PreparedStatement pstmt = con.prepareStatement(query);
    // storing the data
    pstmt.setString(1, storedName);
    pstmt.setString(2, storedEmail);
    pstmt.setString(3, storedCity);
    // updating
    pstmt.executeUpdate();//runs every time someone submits the form
    // closing the PrepareStatement
    pstmt.close();
    // closing the connection
    con.close();
}
catch (Exception e)
{
    e.printStackTrace();//Print the error details so the developer can debug the problem.
}

        // responding to the request
       //response.getWriter().println("user registered!!");

        //redirecting to the jsp file registrationsuccess

        // Store in application scope
        /*
        ServletContext is shared across entire web application.
        Think of it like:
        Global memory box for your web app
         */
        //ServletContext context = getServletContext();
        /*
        Store this data inside application memory.
        Now ANY servlet can access it.
         */
        //context.setAttribute("storedName", storedName);
        //context.setAttribute("storedEmail", storedEmail);
        //context.setAttribute("storedCity", storedCity);


        //  Create session for this user
       /*
        HttpSession session = request.getSession();

        // Store data inside this user's session
        session.setAttribute("storedName", storedName);
        session.setAttribute("storedEmail", storedEmail);
        session.setAttribute("storedCity", storedCity);

*/
        response.sendRedirect("/FirstDynamicWebAppTomcat/registrationsuccess.jsp");



    }

    // do get method for retrieving the data

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

/*
        String searchName=req.getParameter("searchName");
        String searchEmail=req.getParameter("searchEmail");
        String searchCity=req.getParameter("searchCity");

        if(storedName != null &&
                storedEmail != null &&
                storedCity != null && searchName.equals(storedName) &&
                searchCity.equals(storedCity) &&
                searchEmail.equals(storedEmail))
        {
          //  resp.getWriter().println("user found");
            // redirecting to the userfound.jsp file
            resp.sendRedirect("/FirstDynamicWebAppTomcat/userfound.jsp");
        }
        else
        {
            resp.sendRedirect("/FirstDynamicWebAppTomcat/usernotfound.jsp");
        }*/


    }
}
