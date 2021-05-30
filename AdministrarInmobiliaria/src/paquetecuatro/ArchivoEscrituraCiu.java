/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecuatro;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ArchivoEscrituraCiu {

    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Ciudad registroCiudad;
    private ArrayList<Ciudad> listaCiudad;

    public ArchivoEscrituraCiu(String nArchivo) {
        nombreArchivo = nArchivo;
        establecerListaCiudad();

        try {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            if (obtenerListaCiudad().size() > 0) {
                for (int i = 0; i < obtenerListaCiudad().size(); i++) {
                    establecerRegistroCiudad(obtenerListaCiudad().get(i));
                    establecerSalida();
                }
            }
        } catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        }

    }

    public void establecerNombreArchivo(String nArchivo) {
        nombreArchivo = nArchivo;
    }

    public void establecerRegistroCiudad(Ciudad rCiudad) {
        registroCiudad = rCiudad;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registroCiudad);
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerListaCiudad() {
        ArchivoLecturaCiu lectura = new ArchivoLecturaCiu(nombreArchivo);
        lectura.establecerCiudad();
        listaCiudad = lectura.obtenerCiudad();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Ciudad> obtenerListaCiudad() {
        return listaCiudad;
    }

    public ObjectOutputStream obtenerSalida() {
        return salida;
    }

    public void cerrarArchivo() {
        try {
            if (salida != null) {
                salida.close();
            }
        } catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");

        }
    }

}
