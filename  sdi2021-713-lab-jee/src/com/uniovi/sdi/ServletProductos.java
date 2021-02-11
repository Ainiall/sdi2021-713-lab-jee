package com.uniovi.sdi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletSaludo
 */
// declara  en  el  inicio  de  la  clase  nos  sirve  para  definir  la  URL  del servlet
@WebServlet("/productos")
public class ServletProductos extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProductos() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	
	HttpSession session = request.getSession();
	// llamamos al servicio 
	ProductosService ps = new ProductosService();
	// obtenemos la lista de productos de la bbdd
	List<Producto> productosTienda = ps.getProductos();
	
	// Retornar la vista con parámetro "productosTienda"
	request.setAttribute("productosTienda", productosTienda);
	getServletContext().getRequestDispatcher("/vista-productos.jsp").forward(request, response);
	
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	// generado
	// se encarga de que responda a peticiones POST
	doGet(request, response);
    }

}
