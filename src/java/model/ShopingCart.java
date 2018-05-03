/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.io.PrintWriter;
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
        
    }

    private boolean addGoods(String uid,String gid,HttpServletRequest request){
        boolean isFinsh = false;
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie: cookies){
           if("cart".equals(cookie)){
               String cart = cookie.getValue();
               cart += "uid:"+uid+";gid:"+gid;
               cookie.setValue(cart);
               isFinsh = true;
           } 
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
