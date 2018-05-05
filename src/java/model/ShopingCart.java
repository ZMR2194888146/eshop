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
@WebServlet(name = "ShopingCart", urlPatterns = {"/ShopingCart"})
public class ShopingCart extends HttpServlet {


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
        try(PrintWriter out = response.getWriter()){
            String requestType = request.getParameter("RT");
            switch(requestType){
                case "addGoods":
                    if(!"null".equals(request.getParameter("uid"))){
                        if(addGoods(request.getParameter("uid"),request.getParameter("gid"),request,response)){
                            out.print(1);
                        }else{
                            out.print(0);
                        }
                    }
                    break;
            }
        }
    }

    private boolean addGoods(String uid,String gid,HttpServletRequest request,HttpServletResponse response){
        boolean isFinsh = false;
        try {
            Class.forName(config.Config.driver);
            Connection con = DriverManager.getConnection(config.Config.SQLURI, config.Config.username, config.Config.password);
            PreparedStatement ps = con.prepareStatement("INSERT INTO shopingcart VALUES(?,?,?,?)");
            ps.setString(1, String.valueOf(new Date().getTime()));
            ps.setString(2, gid);
            ps.setString(3, uid);
            ps.setInt(4, 1);
            int rs = ps.executeUpdate();
            if(rs == 1){
                isFinsh = true;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ShopingCart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isFinsh;
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
