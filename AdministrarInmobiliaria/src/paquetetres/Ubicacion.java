/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetetres;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Ubicacion implements Serializable {

    private int numeroCasa;
    private String nombreBarrio;
    private String referencia;

    public Ubicacion(int nC, String nB, String r) {
        numeroCasa = nC;
        nombreBarrio = nB;
        referencia = r;
    }

    public void establecerNumeroCasa(int nC) {
        numeroCasa = nC;
    }

    public void establecerNombreBarrio(String nB) {
        nombreBarrio = nB;
    }

    public void establecerReferencia(String r) {
        referencia = r;
    }

    public int obtenerNumeroCasa() {
        return numeroCasa;
    }

    public String obtenerNombreBarrio() {
        return nombreBarrio;
    }

    public String obtenerReferencia() {
        return referencia;
    }

    @Override
    public String toString() {

        String cadena = String.format("Numero casa: %d\nNombre de barrio: %s\n"
                + "Referencia: %s", numeroCasa, nombreBarrio, referencia);
        return cadena;
    }
}
