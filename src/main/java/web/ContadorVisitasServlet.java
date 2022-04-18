/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author adseglocdom
 */
@WebServlet("/ContadorVisitasServlet")
public class ContadorVisitasServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Contador
        int contador = 0;
        
        // Revisar si la cookie contador visitas existe
        Cookie[] cookies = req.getCookies();
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("contadorVisitas")) {
                    contador = Integer.parseInt(cookie.getValue());
                }
            }
        }
        
        //Incrementar contador en 1
        contador++;
        
        Cookie cookie = new Cookie("contadorVisitas", Integer.toString(contador));
        //la cookie se almacena en el cliente por 1 hora 3600s
        cookie.setMaxAge(3600);
        resp.addCookie(cookie);
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("Contador de visitas de cada cliente:" + contador);
    }
    
    
    
}
