/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetetres;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ArchivoLecturaUbi {

    private ObjectInputStream entrada;
    private ArrayList<Ubicacion> ubicaciones;
    private String nombreArchivo;
    private Ubicacion ubicacionObjeto;
    
    public ArchivoLecturaUbi(String n) {
        nombreArchivo = n;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } catch (IOException ioException) {
                System.err.println("Error al abrir el archivo." + ioException);
            }
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }
    
    public void establecerUbicacionObjeto(int nC){
        for(int i= 0; i < ubicaciones.size(); i++){
            if(ubicaciones.get(i).obtenerNumeroCasa() == nC){
                ubicacionObjeto = ubicaciones.get(i);
            }
        }
    }

    public void establecerUbicaciones() {
        ubicaciones = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Ubicacion registro = (Ubicacion) entrada.readObject();
                    ubicaciones.add(registro);
                } catch (EOFException endOfFileException) {
                    return;
                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    System.err.println("No hay datos en el archivo: " + ex);

                }
            }
        }
    }

    public ArrayList<Ubicacion> obtenerUbicaciones() {
        return ubicaciones;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    
    public Ubicacion obtenerUbicacionObjeto(){
        return ubicacionObjeto;
    }

    @Override
    public String toString() {
        String cadena = "";
        for (int i = 0; i < obtenerUbicaciones().size(); i++) {
            Ubicacion u = obtenerUbicaciones().get(i);
            cadena = String.format("%sLista ubicacion %d\nNumero casa %s\n"
                    + "Nombre del barrio: %s\nReferencia: %s\n", cadena,
                    i + 1,
                    u.obtenerNumeroCasa(),
                    u.obtenerNombreBarrio(),
                    u.obtenerReferencia());
        }
        return cadena;
    }

    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        } catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        }
    }
}
