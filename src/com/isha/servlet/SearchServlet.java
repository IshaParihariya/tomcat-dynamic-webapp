package com.isha.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import java.sql.*;

@WebServlet("/search")
public class SearchServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        String searchName = req.getParameter("searchName");
        String searchEmail = req.getParameter("searchEmail");
        String searchCity = req.getParameter("searchCity");

// if user directly opens /search without submitting form
        if(searchName == null || searchEmail == null || searchCity == null)
        {
            resp.sendRedirect("search.html");
            return;
        }

        //HttpSession
        /*
        // Get existing session (don't create new)
        HttpSession session = req.getSession(false);
       false means:
       “Don’t create new session if none exists.”


        if (session != null)
        {

            String storedName = (String) session.getAttribute("storedName");
            String storedEmail = (String) session.getAttribute("storedEmail");
            String storedCity = (String) session.getAttribute("storedCity");

            if (storedName != null &&
                    storedName.equals(searchName) &&
                    storedEmail.equals(searchEmail) &&
                    storedCity.equals(searchCity))
            {

                RequestDispatcher rd =
                        req.getRequestDispatcher("userfound.jsp");
                rd.forward(req, resp);

            }
            else
            {

                RequestDispatcher rd =
                        req.getRequestDispatcher("usernotfound.jsp");
                rd.forward(req, resp);
            }

        }
        else
        {
            resp.sendRedirect("register.jsp");
        }
        */


        // connecting to database

        try
        {
          // loading
            Class.forName("com.mysql.cj.jdbc.Driver");
            // connection
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tomcatregistrationdb",
                    "root",
                    "Lovealarm@123"
            );
            //query
            String query="SELECT * FROM registrationdata WHERE username=? AND email=? AND city=?";

            //PreparedStatement
            PreparedStatement pstmt=con.prepareStatement(query);

            pstmt.setString(1,searchName);
            pstmt.setString(2,searchEmail);
            pstmt.setString(3,searchCity);

            // storing the results
            ResultSet rs=pstmt.executeQuery();

            if(rs.next())
            {
                // inside web the jsp files
                RequestDispatcher rd=req.getRequestDispatcher("/userfound.jsp");
                rd.forward(req,resp);
            }
            else
            {
                RequestDispatcher rd=req.getRequestDispatcher("/usernotfound.jsp");
                rd.forward(req,resp);
            }
            pstmt.close();
            con.close();

        } catch (Exception e)
        {
          e.printStackTrace();
        }

    }
}
