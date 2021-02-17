package com.uniovi.sdi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletSaludo
 */
// URL  del servlet
@WebServlet("/ServletSaludo")
public class ServletSaludo extends HttpServlet {
    private static final long serialVersionUID = 1L;
    int contador = 0; // para verificar que se ejecutan en la misma instancia
		      // del servlet

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSaludo() {
	super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	// generado
	response.getWriter().append("Served at: ")
		.append(request.getContextPath());
	// implementacion de respuesta doget
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	out.println("<HTML>");
	out.println("<HEAD><TITLE>Hola Mundo!</TITLE></HEAD>");
	out.println("<BODY>");
	String nombre = (String) request.getParameter("nombre");
	if (nombre != null) {
	    out.println("Hola " + nombre + "<br>");
	}
	// para verificar que se ejecuta sobre la misma instancia del servlet
	try{
	    Thread.sleep(15000);
	} catch (InterruptedException e) {}
	out.println("ID del hilo:"+Thread.currentThread().getId()+"<br>");
	contador++;
	out.println("Visitas:"+contador+"<br>");
	
	out.println("</BODY></HTML>");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	// se encarga de que responda a peticiones POST
	doGet(request, response);
    }

}
