package com.emergentes.controlador;

import com.emergentes.modelo.Personas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       int op =Integer.parseInt(request.getParameter("op"));
       int id,pos;
       HttpSession ses= request.getSession();
       ArrayList<Personas> lista=(ArrayList<Personas>) ses.getAttribute("listaest");
       if(op==1){
          Personas p =new  Personas();
          request.setAttribute("miPersona",p);
          request.getRequestDispatcher("editar.jsp").forward(request,response);
       }
       if(op==2){
           id=Integer.parseInt(request.getParameter("id"));
           pos=buscarIndice(request,id);
           Personas p1= lista.get(pos);
           request.setAttribute("miPersona",p1);
           request.getRequestDispatcher("editar.jsp").forward(request,response);
       }
       if(op==3){
           id=Integer.parseInt(request.getParameter("id"));
           pos=buscarIndice(request,id);
           lista.remove(pos);
           ses.setAttribute("listaest",lista);
           response.sendRedirect("ejer8.jsp");
       }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       int id= Integer.parseInt(request.getParameter("id"));
       String nombres= request.getParameter("nombres");
       String apellidos= request.getParameter("apellidos");
       int edad= Integer.parseInt(request.getParameter("edad"));
       String nuevo= request.getParameter("nuevo");
       int pos;
       
       Personas per = new Personas();
       per.setId(id);
       per.setNombres(nombres);
       per.setApellidos(apellidos);
       per.setEdad(edad);
       
       HttpSession ses=request.getSession();
       ArrayList<Personas> lista = (ArrayList<Personas>) ses.getAttribute("listaest");
       
       if(nuevo.equals("true")){
           lista.add(per);
       }
       else{
           pos=buscarIndice(request,id);
           lista.set(pos,per);
           
       }
       response.sendRedirect("ejer8.jsp");
    }
    private int buscarIndice(HttpServletRequest request,int id)
    {
        HttpSession ses=request.getSession();
        ArrayList<Personas> lista=(ArrayList<Personas>) ses.getAttribute("listaest");
        int i=0;
        if(lista.size()>0){
            while(i<lista.size()){
                if(lista.get(i).getId()==id){
                    break;
                }
                else{
                    i++;
                }
            }
        }
        return i;
    }
}
