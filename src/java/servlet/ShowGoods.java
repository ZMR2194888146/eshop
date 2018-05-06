/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

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
import model.ShopingCart;

/**
 *
 * @author MENGRU
 */
@WebServlet(name = "ShowGoods", urlPatterns = {"/ShowGoods"})
public class ShowGoods extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShowGoods</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShowGoods at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        PrintWriter out = response.getWriter();
        try{
            Class.forName(config.Config.driver);
            Connection con = DriverManager.getConnection(config.Config.SQLURI,config.Config.username,config.Config.password);
            PreparedStatement ps = con.prepareStatement("SELECT * FROM goods WHERE gid IN (SELECT gid FROM shopingcart WHERE uid = ?)");
            ps.setString(1, request.getParameter("uid"));
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                out.print("<table>");
                out.print("<tr>");
                out.print("<td class='checkBox'>");
                out.print("<input type='checkbox' value='");
                out.print(rs.getFloat("price"));
                out.print("'/>");
                out.print("</td>");
                out.print("<img class='img' src='");
                out.print(rs.getString("smallphoto"));
                out.print("'/></td>");
                out.print("<td class='gname'>");
                out.print("<a href='goodsInfo.jsp?gid=");
                out.print(rs.getString("gid"));
                out.print("' target=_blank>"+rs.getString("gname"));
                out.print("</a>");
                out.print("</td>");
                out.print("<td class='price'>");
                out.print("￥" + rs.getFloat("price") );
                out.print("</td>");
                out.print("<td class='number'>");
                out.print(1);
                out.print("</td>");
                out.print("<td class='delete'>");
                out.print("<a href='javascript:;' onclick='deleteGoods('");
                out.print(rs.getString("gid"));
                out.print("'/>删除");
                out.print("</a>");
                out.print("</td>");
                out.print("</tr>");
                out.print("</table>");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ShopingCart.class.getName()).log(Level.SEVERE, null, ex);
        }
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