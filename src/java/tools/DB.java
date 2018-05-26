/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ZHAO
 */
public class DB {
   private static Connection con = null;
   public static Connection getConnection(){     
       try {
           Class.forName(tools.Config.driver);
           con = DriverManager.getConnection(tools.Config.SQLURI,tools.Config.username,tools.Config.password);
       } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
       }
       return con;
   }
         
}
