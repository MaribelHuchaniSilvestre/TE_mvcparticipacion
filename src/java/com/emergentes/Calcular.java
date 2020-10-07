package com.emergentes;

import com.emergentes.modelo.Rectangulo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "Calcular", urlPatterns = {"/Calcular"})
public class Calcular extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int base=Integer.parseInt(request.getParameter("base"));
        int altura=Integer.parseInt(request.getParameter("altura"));
        Rectangulo obj= new Rectangulo();
        obj.setBase(base);
        obj.setAltura(altura);
        
        request.setAttribute("miobj",obj);
        
        request.getRequestDispatcher("salida.jsp").forward(request, response);
    }
}
