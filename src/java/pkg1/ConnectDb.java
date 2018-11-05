/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

import java.sql.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author hannah
 */
public class ConnectDb{
    private Connection conn;
    private final String connectionURL = "jdbc:derby://localhost:1527/PreferVegetable";
    private final String userDb = "Hannah";
    private final String passwordDb = "Tangziqi1996";
    
    public Connection getConn(){
        try{
        conn = DriverManager.getConnection(this.connectionURL, userDb, passwordDb);
        }catch (SQLException se){
            se.printStackTrace();  
        }
        return conn;
    }
    
    public static void main(String[] args) throws SQLException{
        ConnectDb db = new ConnectDb();
        Connection conn = db.getConn();
        
        Boolean carrot = false;
        Boolean cucumber = false;
        Boolean cabbage = false;
        Boolean coriander = false;
        Timestamp submit_time = new Timestamp(System.currentTimeMillis());
        String uname = "Ryan";
        
        try (Statement st = conn.createStatement()) {
            String sqlInsert = new String("INSERT INTO HANNAH.VEGETABLE (SUBMIT_TIME, CARROT, CUCUMBER, CABBAGE, CORIANDER, NAME) VALUES"
                        + "("+"'"+submit_time+"'"+","+carrot+","+cucumber+","+cabbage+","+coriander+","+"'"+uname+"'"+")");
            System.out.println(sqlInsert);
            st.executeUpdate(sqlInsert);
        }catch(SQLException se){
            se.printStackTrace();
        }
    }
}


