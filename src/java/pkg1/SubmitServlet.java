/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author hannah
 */
//@WebServlet(name = "SubmitServlet", urlPatterns = {"/SubmitServlet"})
public class SubmitServlet extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String hint)
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
            out.println("<h3>" + hint + "</h3>");

            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // get session and username
        HttpSession session = request.getSession(false);
        if (session == null){
            String hint = new String("error occurred with Session");
            processRequest(request, response, hint);
        }
        myBean ub = (myBean)session.getAttribute("ub");
        String uname = ub.getName();
        
        // get the choice
        Boolean carrot = false;
        Boolean cucumber = false;
        Boolean cabbage = false;
        Boolean coriander = false;
        String vegetables[] =request.getParameterValues("vegetables");
        if (vegetables != null){
            for(int i=0;i<vegetables.length;i++){
                switch(vegetables[i]){
                    case "carrot":
                        carrot = true;
                        break;
                    case "cucumber":
                        cucumber = true;
                        break;
                    case "cabbage":
                        cabbage = true;
                        break;
                    case "coriander":
                        coriander = true;
                        break;
                    default:
                        String hint = new String("Error occurred with Derby");
                        processRequest(request, response, hint);
                }
            }
        }
                
        //get current time
        Timestamp submit_time = new Timestamp(System.currentTimeMillis());

        //open the DBMS and check the record
        try{
            ConnectDb cd = new ConnectDb();
            Connection conn;
            conn = cd.getConn();
            
            try (Statement st = conn.createStatement()) {
                // INSERT INTO HANNAH.VEGETABLE (ID, CARROT, CUCUMBER, CABBAGE, CORIANDER, "TIME") 
                // VALUES (0, false, false, false, false, '2018-11-04 20:02:46.968');
                String sqlInsert = new String("INSERT INTO HANNAH.VEGETABLE (SUBMIT_TIME, CARROT, CUCUMBER, CABBAGE, CORIANDER, NAME) VALUES"
                        + "("+"'"+submit_time+"'"+","+carrot+","+cucumber+","+cabbage+","+coriander+","+"'"+uname+"'"+")");
                st.executeUpdate(sqlInsert);
            }
            conn.close();
        }catch (SQLException se){
            se.printStackTrace();
            String hint = new String("Error occurred with Derby");
            processRequest(request, response, hint);
        }
       
        String hint = "Finished. Thank you.";
        processRequest(request, response, hint);
    }
}
