package com.uniovi.sdi;

/**
 * Clase Comentario. Contiene sus propiedades autor y texto y permite su manejo.
 * 
 * @author Angela UO270318
 *
 */
public class Comentario {

    private String autor;
    private String texto;

    public Comentario() {

    }

    public Comentario(String autor, String texto) {
	this.autor = autor;
	this.texto = texto;
    }

    public String getAutor() {
	return autor;
    }

    public void setAutor(String autor) {
	this.autor = autor;
    }

    public String getTexto() {
	return texto;
    }

    public void setTexto(String texto) {
	this.texto = texto;
    }
}
