/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecuatro;

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
public class ArchivoLecturaCiu {

    private ObjectInputStream entrada;
    private ArrayList<Ciudad> ciudad;
    private String nombreArchivo;
    private Ciudad ciudadObjeto;

    public ArchivoLecturaCiu(String n) {
        nombreArchivo = n;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try // abre el archivo
            {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } // fin de try
            catch (IOException ioException) {
                System.err.println("Error al abrir el archivo." + ioException);
            } // fin de catch
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerCiudadObjeto(String nC) {
        for (int i = 0; i < ciudad.size(); i++) {
            if (ciudad.get(i).obtenerCiudad().equals(nC)) {
                ciudadObjeto = ciudad.get(i);
            }
        }
    }

    public void establecerCiudad() {
        // 
        ciudad = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Ciudad registro = (Ciudad) entrada.readObject();
                    ciudad.add(registro);
                } catch (EOFException endOfFileException) {
                    return; // se llegó al fin del archivo
                    // System.err.println("Fin de archivo: " + endOfFileException);

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

    public ArrayList<Ciudad> obtenerCiudad() {
        return ciudad;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public Ciudad obtenerCiudadObjeto() {
        return ciudadObjeto;
    }

    @Override
    public String toString() {
        String cadena = "";
        for (int i = 0; i < obtenerCiudad().size(); i++) {
            Ciudad c = obtenerCiudad().get(i);
            cadena = String.format("%sInfomacion Ciudad %dCiudad: %s\nProvincia: "
                    + "%s\n", cadena, i + 1, c.obtenerCiudad(), c.obtenerProvincia());
        }

        return cadena;
    }

    // cierra el archivo y termina la aplicación
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
