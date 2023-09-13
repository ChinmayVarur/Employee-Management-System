/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emplyoee.management.system;
import java.sql.*;
/**
 *
 * @author chinmayvarur
 */
public class Conn {
    
    Connection c;
    Statement stmt;
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///EMS","root","chinmayrv_339");
            stmt = c.createStatement();
        }catch(Exception e){
            e.getMessage();
        }
    }
}
