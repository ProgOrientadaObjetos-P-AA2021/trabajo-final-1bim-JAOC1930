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
public class ArchivoLecturaDepa {

    private ObjectInputStream entrada;
    private ArrayList<Departamento> departamento;
    private String nombreArchivo;

    public ArchivoLecturaDepa(String n) {
        nombreArchivo = n;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try 
            {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } 
            catch (IOException ioException) {
                System.err.println("Error al abrir el archivo." + ioException);
            } 
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerDepartamento() {
        departamento = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Departamento registro = (Departamento) entrada.readObject();
                    departamento.add(registro);
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

    public ArrayList<Departamento> obtenerDepartamento() {
        return departamento;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "";
        for (int i = 0; i < obtenerDepartamento().size(); i++) {
            Departamento d = obtenerDepartamento().get(i);
            cadena = String.format("%sDepartamento %d\nPropietario\n%s\nPrecio"
                    + " metro cuadrado: %.2f\nNumero de metros cuadrado: %.2f\n"
                    + "Valor de alicuota mensual: %.2f\nCoato final: %.2f\n"
                    + "Precio: %.2f\nUbicacion\n%s\nCiudad\n%s\nNombre del "
                    + "edficio: %s\nUbicacion de departamento: %s\n"
                    + "Constructora \n%s", cadena, i+1, d.obtenerPropietario(),
                    d.obtenerPrecioMetroCuadrado(), d.obtenerNumeroMetroCuadrado(),
                    d.obtenerValorCuotaMensual(), d.obtenerCostoFinal(),
                    d.obtenerPrecio(), d.obtenerUbicacion(), d.obtenerCiudad(),
                    d.obtenerNombreEdificio(), d.obtenerUbicacionDepartamentoE(),
                    d.obtenerConstructora());
        }

        return cadena;
    }

 
    public void cerrarArchivo() {
        try 
        {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        }
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        } 
    } 
}
