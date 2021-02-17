package com.uniovi.sdi;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletBorrarCarrito
 */
// URL del servlet
@WebServlet("/borrarEnCarrito") 
public class ServletBorrarCarrito extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBorrarCarrito() {
	super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	
	HashMap<String, Integer> carrito = (HashMap<String, Integer>) request
		.getSession().getAttribute("carrito");
	
	// No hay carrito, creamos uno y lo insertamos en sesion
	if (carrito == null) {
	    carrito = new HashMap<String, Integer>();
	    request.getSession().setAttribute("carrito", carrito);
	}
	String producto = request.getParameter("producto");
	if (producto != null) {
	    borrarEnCarrito(carrito, producto);
	}
	// Retornar la vista con parámetro "carrito"
	request.setAttribute("paresCarrito", carrito);
	getServletContext().getRequestDispatcher("/vista-carrito.jsp").forward(request, response);
	
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

    // metodos auxiliares
    private void borrarEnCarrito(Map<String, Integer> carrito,
	    String claveProducto) {
	if (carrito.get(claveProducto) != null) {
	    int numeroArticulos = (Integer) carrito.get(claveProducto)
		    .intValue();
	    carrito.put(claveProducto, new Integer(numeroArticulos - 1));
	    // se elimina el producto del carrito
	    if(numeroArticulos == 1) {
		carrito.remove(claveProducto);
	    }
	} else {
	    return; 
	}
    }

}
