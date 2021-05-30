/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecinco;

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
public class ArchivoLecturaCons {

    private ObjectInputStream entrada;
    private ArrayList<Constructora> constructora;
    private String nombreArchivo;
    private Constructora constructoraObjeto;

    public ArchivoLecturaCons(String n) {
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

    public void establecerConstructoraObjeto(int idE) {
        for (int i = 0; i < constructora.size(); i++) {
            if (constructora.get(i).obtenerIdE() == idE) {
                constructoraObjeto = constructora.get(i);
            }
        }
    }

    public void establecerConstrutora() {
        // 
        constructora = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Constructora registro = (Constructora) entrada.readObject();
                    constructora.add(registro);
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

    public ArrayList<Constructora> obtenerConstructora() {
        return constructora;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public Constructora obtenerConstructoraObjeto() {
        return constructoraObjeto;
    }

    @Override
    public String toString() {
        String cadena = "";
        for (int i = 0; i < obtenerConstructora().size(); i++) {
            Constructora p = obtenerConstructora().get(i);
            cadena = String.format("%sConstuctra %d\nsNombre constructora: %s\nIdentificacion: "
                    + "%d\n", cadena, i + 1, p.obtenerNombreC(), p.obtenerIdE());
        }

        return cadena;
    }

    // cierra el archivo y termina la aplicación
    public void cerrarArchivo() {
        try // cierra el archivo y sale
        {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método cerrarArchivo
}
