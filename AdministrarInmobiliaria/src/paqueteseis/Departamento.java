/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteseis;

import java.io.Serializable;
import paquetecinco.Constructora;
import paquetecuatro.Ciudad;
import paquetedos.Propietario;
import paquetetres.Ubicacion;

/**
 *
 * @author reroes
 */
public class Departamento implements Serializable{
    private Propietario propietario;
    private double pMetroCuadrado;
    private double nMetroCuadrado;
    private double vAliCuotaMensual;
    private double costoFinal;
    private double precio;
    private Ubicacion ubicacion;
    private Ciudad ciudad;
    private String nombreEdificio;
    private String ubicacionDE;
    private Constructora constructora;
    
    public Departamento(Propietario p, double pMC, double nMC, double vCuotaM, 
            double prec, Ubicacion ubi, Ciudad ciu, String nEdif, String 
                    ubiDE, Constructora cons){
        propietario = p;
        pMetroCuadrado = pMC;
        nMetroCuadrado = nMC;
        vAliCuotaMensual = vCuotaM;
        precio = prec;
        ubicacion = ubi;
        ciudad = ciu;
        nombreEdificio = nEdif;
        ubicacionDE = ubiDE;
        constructora = cons;   
    }
    
    public void establecerPropietario(Propietario p){
        propietario = p;
    }
    
    public void establecerPrecioMetroCuadrado(double pMC){
        pMetroCuadrado = pMC;
    }
    
    public void establecerNumeroMetroCuadrado(double nMC){
        nMetroCuadrado = nMC;
    }
    
    public void establecerValorCuotaMensual(double vCuotaM){
        vAliCuotaMensual = vCuotaM;
    }
    
    public void calcularCostoFinal(){
        costoFinal = (nMetroCuadrado * pMetroCuadrado) + (vAliCuotaMensual * 12);
    }
    
    public void establecerPrecio(double prec){
        precio = prec;
    }
    
    public void establecerUbicacion(Ubicacion ubi){
        ubicacion = ubi;
    }
    
    public void establecerCiudad(Ciudad ciu){
        ciudad = ciu;
    }
    
    public void establecerNombreEdificio(String nEdif){
        nombreEdificio = nEdif;
    }
    
    public void establecerUbicacioDepartamentoE(String ubiDE){
        ubicacionDE = ubiDE;
    }
    
    public void establecerConstructora(Constructora cons){
        constructora = cons;
    }
    
    public Propietario obtenerPropietario(){
        return propietario;
    }
    
    public double obtenerPrecioMetroCuadrado(){
        return pMetroCuadrado;
    }
    
    public double obtenerNumeroMetroCuadrado(){
        return nMetroCuadrado;
    }
    
    public double obtenerValorCuotaMensual(){
        return vAliCuotaMensual;
    }
    
    public double obtenerCostoFinal(){
        return costoFinal;
    }
    
    public double obtenerPrecio(){
        return precio;
    }
    
    public Ubicacion obtenerUbicacion(){
        return ubicacion;
    }
    
    public Ciudad obtenerCiudad(){
        return ciudad;
    }
    
    public String obtenerNombreEdificio(){
        return nombreEdificio;
    }
    
    public String obtenerUbicacionDepartamentoE(){
        return ubicacionDE;
    }
    
    public Constructora obtenerConstructora(){
        return constructora;
    }
    
    @Override
    public String toString(){
        String cadena = String.format("Propierario\n\tNombre %s\nApellido: %s\n"
                + "Identificacion: %s\nPrecio de metro cuadrado: %.2f\nnumero de "
                + "metros cuadrados: %.2f\nValro de alicuota mensual: %.2f\n"
                + "Costo final: %.2f\nPrecio: %.2f\nUbicacions\n\tNumero de "
                + "casa: %d\n\tNombre de barrio: %s\n\tReferencia: %s\n"
                + "Ciudad\n\tCiudad: %s\n\tProvincia: %s\nNombre edificio: %s\n"
                + "Ubicacion de departamento: %s\nConstrucotra\n\tNombre "
                + "constructora: %s\n\tid de la empresa: %s\n", 
                propietario.obtenerNombre(), propietario.obtenerApellido(),
                propietario.obtenerIdentifiacion(), pMetroCuadrado, nMetroCuadrado,
                );
        return cadena;
    }
}
