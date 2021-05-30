/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecuatro;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Ciudad implements Serializable {

    private String ciudad;
    private String provincia;

    public Ciudad(String c, String p) {
        ciudad = c;
        provincia = p;
    }

    public void establecerCiudad(String c) {
        ciudad = c;
    }

    public void establecerProvincia(String p) {
        provincia = p;
    }

    public String obtenerCiudad() {
        return ciudad;
    }

    public String obtenerProvincia() {
        return provincia;
    }

    @Override
    public String toString() {

        String cadena = String.format("Ciudad: %s\nProvincia: %s", ciudad,
                provincia);
        return cadena;
    }
}
