package com.uniovi.sdi;

import java.util.LinkedList;
import java.util.List;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

/**
 * Clase ProductossService. 
 * Permite manejar una nueva base de datos llamada
 * bdProductos. Para ello existen dos métodos: 
 * - getProductos() accede a la BBDD y devuelve todos los productos 
 * existentes 
 * - setNuevoProducto() inserta un comentario pasado como parámetro a la 
 * BBDD
 * 
 * @author Angela UO270318
 *
 */
public class ProductosService {
    public List<Producto> getProductos() {
	List<Producto> productos = new LinkedList<Producto>();
	ObjectContainer db = null;
	try {
	    db = Db4oEmbedded.openFile("bdProductos");
	    List<Producto> respuesta = db.queryByExample(Producto.class);
	    // no se debe retornar la lista que devuelve la BBDD
	    productos.addAll(respuesta);
	} finally {
	    db.close();
	}
	return productos;
    }

    public void setNuevoProducto(Producto nuevoProducto) {
	ObjectContainer db = null;
	try {
	    db = Db4oEmbedded.openFile("bdProductos");
	    db.store(nuevoProducto);
	} finally {
	    db.close();
	}
    }
}
