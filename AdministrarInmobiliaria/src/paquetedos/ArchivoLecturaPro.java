/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetedos;

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
public class ArchivoLecturaPro {

    private ObjectInputStream entrada;
    private ArrayList<Propietario> propietarios;
    private String nombreArchivo;
    private Propietario propietarioObjeto;

    public ArchivoLecturaPro(String n) {
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

    public void establecerPropietarioObjeto(String id) {
        for (int i = 0; i < obtenerPropietarios().size(); i++) {
            if (propietarios.get(i).obtenerIdentifiacion().equals(id)) {
                propietarioObjeto = propietarios.get(i);
            }
        }
    }

    public void establecerPropietarios() {
        propietarios = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Propietario registro = (Propietario) entrada.readObject();
                    propietarios.add(registro);
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

    public ArrayList<Propietario> obtenerPropietarios() {
        return propietarios;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public Propietario obtenerPropietariosObjeto() {
        return propietarioObjeto;
    }

    @Override
    public String toString() {
        String cadena = "";
        for (int i = 0; i < obtenerPropietarios().size(); i++) {
            Propietario p = obtenerPropietarios().get(i);
            cadena = String.format("%sLista propietario %d\nNombre: %s\nApellido: %s\n"
                    + "Identificacion: %s\n", cadena,
                    i + 1,
                    p.obtenerNombre(),
                    p.obtenerApellido(),
                    p.obtenerIdentifiacion());
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
