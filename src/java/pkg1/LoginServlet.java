/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;



/**
 *
 * @author hannah
 */

//@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet1"})
public class LoginServlet extends HttpServlet {

    protected void dbError(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Finished</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>" + "Error occurred with Derby" + "</h3>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String uname = request.getParameter("uname");
        String password = request.getParameter("password");
        String passwordDb = new String();
        Boolean unique = true;
        
        //open the DBMS and check the record
        try{
            ConnectDb cd = new ConnectDb();
            Connection conn;
            conn = cd.getConn();
            
            try (Statement st = conn.createStatement()) {
                ResultSet rs;
                rs = null;
                
                String sql = new String("SELECT password FROM UserInfo WHERE name='"+uname+"' ");
                rs = st.executeQuery(sql);
                rs.next();
                passwordDb = rs.getString("password");
                
                // justiry unique
                if (rs.next()){
                    unique = false;
                }
                
                rs.close();
            }
            conn.close();
        }        
        catch (SQLException se)
        {
            se.printStackTrace();
            dbError(request, response);
        }
        
        // set session
        HttpSession session=request.getSession(true);
        myBean ub = new myBean();
        session.setAttribute("ub",ub);

        if ((password == null ? passwordDb == null : password.equals(passwordDb)) && unique){
            // set session
            ub.setName(uname);
            ub.setStatus("LOGIN SUCCESS");
            
            // forward to vegetable page
            RequestDispatcher rd = request.getRequestDispatcher("vegetable.jsp");
            rd.forward(request, response);
        }
        else{
            ub.setStatus("LOGIN FAILURE");
            request.setAttribute("hint", "Wrong username or password");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }

    }
}
