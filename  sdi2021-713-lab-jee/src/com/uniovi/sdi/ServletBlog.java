package com.uniovi.sdi;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletBlog
 */
// URL del servlet
@WebServlet("/blog")
public class ServletBlog extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBlog() {
	super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	
	// llamamos al servicio 
	ComentariosService cs = new ComentariosService();
	// obtenemos la lista de comentarios de la bbdd
	List<Comentario> comentarios = cs.getComentarios();
	// Retornar la vista con parámetro "comentarios"
	request.setAttribute("comentarios", comentarios);
	getServletContext().getRequestDispatcher("/blog.jsp").forward(request, response);
	
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
