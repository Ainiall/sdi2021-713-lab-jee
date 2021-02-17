package com.uniovi.sdi;

import java.util.LinkedList;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

/**
 * Clase ComentariosService. 
 * Permite manejar una nueva base de datos llamada bdComentarios. 
 * Para ello existen dos métodos: 
 * - getComentarios() accede a la BBDD y devuelve todos los comentarios 
 * existentes 
 * - setNuevoComentario() inserta un comentario pasado como parámetro a la 
 * BBDD
 * 
 * @author Angela UO270318
 *
 */
public class ComentariosService {
    public List<Comentario> getComentarios() {
	List<Comentario> comentarios = new LinkedList<Comentario>();
	ObjectContainer db = null;
	try {
	    db = Db4oEmbedded.openFile("bdComentarios");
	    List<Comentario> respuesta = db.queryByExample(Comentario.class);
	    // no se debe retornar la lista que devuelve la BBDD
	    comentarios.addAll(respuesta);
	} finally {
	    db.close();
	}
	return comentarios;
    }

    public void setNuevoComentario(Comentario nuevoComentario) {
	ObjectContainer db = null;
	try {
	    db = Db4oEmbedded.openFile("bdComentarios");
	    db.store(nuevoComentario);
	} finally {
	    db.close();
	}
    }
}
