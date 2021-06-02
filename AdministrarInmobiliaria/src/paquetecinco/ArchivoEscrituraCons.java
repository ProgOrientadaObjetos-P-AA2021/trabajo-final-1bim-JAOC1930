/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecinco;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ArchivoEscrituraCons {

    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Constructora registroConstuctora;
    private ArrayList<Constructora> listaConstructora;

    public ArchivoEscrituraCons(String nombreArc) {
        nombreArchivo = nombreArc;
        establecerListaConstructora();
        try {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            if (obtenerListaConstructora().size() > 0) {
                for (int i = 0; i < obtenerListaConstructora().size(); i++) {
                    establecerRegistroConstructora(obtenerListaConstructora().get(i));
                    establecerSalida();
                }
            }
        } catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerRegistroConstructora(Constructora c) {
        registroConstuctora = c;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registroConstuctora);
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerListaConstructora() {
        ArchivoLecturaCons l = new ArchivoLecturaCons(obtenerNombreArchivo());
        l.establecerConstrutora();
        listaConstructora = l.obtenerConstructora();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Constructora> obtenerListaConstructora() {
        return listaConstructora;
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
