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
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.*;

/**
 *
 * @author MENGRU
 */
@WebServlet(name = "Persion", urlPatterns = {"/Persion"})
public class Persion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            if(request.getParameter("msg") != null ){
                String msgstr = request.getParameter("msg");
                JSONObject msgjson = JSONObject.fromObject(msgstr);
                try {
                    Class.forName(config.Config.driver);
                    Connection con = DriverManager.getConnection(config.Config.SQLURI, config.Config.username,config.Config.password);
                    PreparedStatement ps = con.prepareStatement("INSERT INTO customers('uid','uname','password') VALUES(?,?,?)");
                    ps.setString(1, String.valueOf(new Date().getTime()));
                    ps.setString(2, msgjson.getString("username"));
                    ps.setString(3, msgjson.getString("password")); 
                    int rs = ps.executeUpdate();
                    if(rs == 1){
                        JSONObject json = new JSONObject();
                        json.put("status", 1);
                        out.print(json.toString());
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Persion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Persion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }    
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
        processRequest(request, response);
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
