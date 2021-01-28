/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VINOTHKUMAR
 */
import java.sql.*;
/**
 *
 * @author VINOTHKUMAR
 */
public class DBconnect {
    public static Connection connect()
    {
        Connection con=null;
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pms","root","");
    
        }
        catch(ClassNotFoundException | SQLException exp)
        {
            System.out.println(exp);
        }
   return con;
    }
}
