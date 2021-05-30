/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetedos;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Propietario implements Serializable {

    private String nombre;
    private String apellido;
    private String identificacion;

    public Propietario(String n, String a, String i) {
        nombre = n;
        apellido = a;
        identificacion = i;
    }

    public void estabkecerNombre(String n) {
        nombre = n;
    }

    public void establecerApellido(String a) {
        apellido = a;
    }

    public void establecerIdentificacion(String i) {
        identificacion = i;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerApellido() {
        return apellido;
    }

    public String obtenerIdentifiacion() {
        return identificacion;
    }

    @Override
    public String toString() {

        String cadena = String.format("Nombre: %s\nApellido: %s\n"
                + "Identificacion: %s", nombre, apellido, identificacion);
        return cadena;
    }
}
