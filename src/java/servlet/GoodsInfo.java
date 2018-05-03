/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import config.Config;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "GoodsInfo", urlPatterns = {"/GoodsInfo"})
public class GoodsInfo extends HttpServlet {

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
        PrintWriter out = response.getWriter();
         try { 
            String gid = request.getParameter("gid");
            Connection cn = DriverManager.getConnection(Config.SQLURI,Config.username,Config.password);
            PreparedStatement ps = cn.prepareStatement("select * from goods where gid = ?");
            ps.setString(1,gid);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                out.print("<table id='content-inner'>");
                out.print("<tr>");
                out.print("<td  class='img'>");
                out.print("<img src='");
                out.print(rs.getString("largephoto"));
                out.print("'/>");
                out.print("</td>");
                out.print("<td class='info'>");
                out.print("<h1>"+rs.getString("gname")+"</h1>");
                out.print("单价:"+rs.getString("price")+"<br/>");
                out.print("&nbsp;型号:"+rs.getString("model")+"<br/>");
                out.print("&nbsp;品牌:"+rs.getString("brand"));
                out.print("<button value='加入购物车' onclick='addtioncart(\"");
                out.print(gid);
                out.print("\")'>加入购物车</button>");
                out.print("</td>");
                out.print("</tr>");
                out.print("</table>");
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
