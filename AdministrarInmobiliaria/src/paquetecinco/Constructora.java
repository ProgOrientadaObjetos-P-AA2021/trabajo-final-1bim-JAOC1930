/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecinco;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Constructora implements Serializable {

    private String nombreC;
    private int idE;

    public Constructora(String nC, int id) {
        nombreC = nC;
        idE = id;
    }

    public void establecerNombreC(String nC) {
        nombreC = nC;
    }

    public void establecerIdE(int id) {
        idE = id;
    }

    public String obtenerNombreC() {
        return nombreC;
    }

    public int obtenerIdE() {
        return idE;
    }

    @Override
    public String toString() {

        String cadena = String.format("Nombre constructora: %s\nId de empresa: %d",
                nombreC, idE);
        return cadena;
    }

}
