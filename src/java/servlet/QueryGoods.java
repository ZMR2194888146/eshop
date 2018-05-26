/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import tools.Config;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "QueryGoods", urlPatterns = {"/QueryGoods"})
public class QueryGoods extends HttpServlet {


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
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
//        out.print("this this response");
        try { 
            Connection cn = DriverManager.getConnection(Config.SQLURI,Config.username,Config.password);
            PreparedStatement ps = cn.prepareStatement("select * from goods where category = ?");
            ps.setString(1,request.getParameter("cid"));
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                out.print("<li>");
                out.print("<table>");
                out.print("<tr>");
                out.print("<td width=100px;>");
                out.print("<img style='width:100px;height:100px' src='images/");
                out.print(rs.getString("smallphoto"));
                out.print(".jpg'/>");
                out.print("</td>");
                out.print("<td style='text-argin:left;'>");
                out.print("<a href='goodsInfo.jsp?gid=");
                out.print(rs.getString("gid"));
                out.print("' target='_blank'>");
                out.print(rs.getString("gname"));
                out.print("</a></br>");                
                out.print("单价:"+rs.getString("price"));
                out.print("&nbsp;型号:"+rs.getString("model"));
                out.print("&nbsp;品牌:"+rs.getString("brand"));
                out.print("</td>");
                out.print("</table>");
                out.print("</li>");    
            }
            rs.close();
            ps.cancel();
            cn.close();     
        } catch (SQLException ex) {
            ex.printStackTrace();
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
