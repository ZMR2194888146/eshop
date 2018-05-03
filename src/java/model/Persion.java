/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MENGRU
 */
@WebServlet(name = "Persion", urlPatterns = {"/Persion"})
public class Persion extends HttpServlet {


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if("register".equals(request.getParameter("type"))){
            toRegister(request,response);
        }else if("login".equals(request.getParameter("type"))){
            toLogin(request,response);
        }
    }
    
    /**
     * that is to register account ,no return
     * 
     * @param request
     * @param response 
     */
    private void toRegister(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            if(request.getParameter("username") != null ){      
                try {     
                    Class.forName(config.Config.driver);
                    Connection con = DriverManager.getConnection(config.Config.SQLURI, config.Config.username,config.Config.password);  
                    PreparedStatement ps = con.prepareStatement("INSERT INTO customers(uid,uname,password) VALUES(?,?,?)");
                    ps.setString(1, String.valueOf(new Date().getTime()));
                    ps.setString(2, request.getParameter("username"));
                    ps.setString(3, request.getParameter("password")); 
                    int rs = ps.executeUpdate();
                    if(rs == 1){
                        out.print(1);
                        Cookie cookie = new Cookie("username",request.getParameter("username"));
                        cookie.setMaxAge(3600);
                        response.addCookie(cookie);
                    } else {
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(Persion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }    
        } catch (IOException ex) {
            Logger.getLogger(Persion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void toLogin(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            try {
                Class.forName(config.Config.driver);
                Connection con = DriverManager.getConnection(config.Config.SQLURI, config.Config.username,config.Config.password);
                PreparedStatement ps = con.prepareStatement("SELECT * FROM customers WHERE uname = ?");
                ps.setString(1, request.getParameter("username")); 
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    out.print(1);
                    Cookie cookie = new Cookie("username",request.getParameter("username"));
                    cookie.setMaxAge(3600);
                    response.addCookie(cookie);
                }else{
                    out.print(2);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Persion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Persion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
