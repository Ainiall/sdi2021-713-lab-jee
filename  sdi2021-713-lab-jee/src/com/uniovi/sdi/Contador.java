package com.uniovi.sdi;

/**
 * Clase contador. Se encarga de manejar un contador utilizado para llevar un
 * recuento del número de visitas
 * 
 * @author Angela UO270318
 *
 */
public class Contador {
    private int total;

    public int getTotal() {
	return total;
    }

    public void setIncremento(int incremento) {
	total += incremento;
    }
}
