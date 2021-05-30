/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteseis;

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
public class ArchivoLecturaCasa {

    private ObjectInputStream entrada;
    private ArrayList<Casa> casas;
    private String nombreArchivo;

    public ArchivoLecturaCasa(String n) {
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

    public void establecerCasas() {
        casas = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Casa registro = (Casa) entrada.readObject();
                    casas.add(registro);
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

    public ArrayList<Casa> obtenerCasas() {
        return casas;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "Lista de Casa\n";
        for (int i = 0; i < obtenerCasas().size(); i++) {
            Casa c = obtenerCasas().get(i);
            cadena = String.format("%s%d-Propietarios\n%s\nPrecio por metros "
                    + "cuadrados: .2f\nNumero de metros cuadrados: %.2f\nCosto "
                    + "final: %.2f\nUbicacion:\n%s\nciudad\n%s\nNumero de "
                    + "cuartos: %d\nConstructora\n%s\n", cadena,
                    i + 1, c.obtenerPropietario(),
                    c.obtenerPrecioMetroCua(), c.obtenerNumeroMetroCua(),
                    c.obtenerCostoFinal(), c.obtenerUbicacion(),
                    c.obtenerCiudad(), c.obtenerNumeroCuartos(),
                    c.obtenerConstructora());

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
