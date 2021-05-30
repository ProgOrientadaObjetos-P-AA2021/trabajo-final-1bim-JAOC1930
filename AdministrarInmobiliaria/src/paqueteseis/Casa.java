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
public class Casa implements Serializable{
    private Propietario propietario;
    private double pMetroCuadrado;
    private double nMetroCuadrado;
    private double costoFinal;
    private Ubicacion ubicacion;
    private Ciudad ciudad;
    private int numeroCuartos;
    private Constructora constructora;
    
    public Casa(Propietario p, double pMC, double nMC, Ubicacion u, Ciudad c, int nC,
            Constructora cT){
        propietario = p;
        pMetroCuadrado = pMC;
        nMetroCuadrado = nMC;
        ubicacion = u;
        ciudad = c;
        numeroCuartos = nC;
        constructora = cT;
    }
    
    public void establecerPorpietario(Propietario p){
        propietario = p;
    }
    
    public void establecerPrecioMetrosCua(double pMC){
        pMetroCuadrado = pMC;
    }
    
    public void establecerNumeroMetroCua(double nMC){
        nMetroCuadrado = nMC;
    }
    
    public void calcularCostoFinal(){
        costoFinal = pMetroCuadrado * nMetroCuadrado;
    }
    
    public void establecerUbicacion(Ubicacion u){
        ubicacion = u;
    }
    
    public void establecerCiudad(Ciudad c){
        ciudad = c;
    }
    
    public void establecerNumeroCuartos(int nC){
        numeroCuartos = nC;
    }
    
    public void establecerConstuctora(Constructora cT){
        constructora = cT;
    }
    
    public Propietario obtenerPropietario(){
        return propietario;
    }
    
    public double obtenerPrecioMetroCua(){
        return pMetroCuadrado;
    }
    
    public double obtenerNumeroMetroCua(){
        return nMetroCuadrado;
    }
    
    public double obtenerCostoFinal(){
        return costoFinal;
    } 
    
    public Ubicacion obtenerUbicacion(){
        return ubicacion;
    }
    
    public Ciudad obtenerCiudad(){
        return ciudad;
    }
    
    public int obtenerNumeroCuartos(){
        return numeroCuartos;
    }
    
    public Constructora obtenerConstructora(){
        return constructora;
    }
    
    @Override
    public String toString(){
  
        String cadena = String.format("Propietarios\n\tNombre: %s\n\t"
                + "Apellido: %s\n\tIdentidad: %s\nPrecio metros cuadrados: %.2f\n"
                + "Numero metros cuadrados: %.2f\nCosto final: %.2f\nUbicacion\n"
                + "\tNumero de casa: %d\n\tNombreBarrio: %s\n\tReferencia: %s\n"
                + "Ciudad\n\tCiudad:%s\n\tProvincia: %s\nNumero cuartos: %d\n"
                + "Constructora\n\tNombre constructora: %s\n\tId de empresa: %d\n", 
                propietario.obtenerNombre(), propietario.obtenerApellido(),
                propietario.obtenerIdentifiacion(), pMetroCuadrado, 
                nMetroCuadrado, costoFinal, ubicacion.obtenerNumeroCasa(),
                ubicacion.obtenerNombreBarrio(), ubicacion.obtenerReferencia(),
                ciudad.obtenerCiudad(), ciudad.obtenerProvincia(), numeroCuartos
                , constructora.obtenerNombreC(), constructora.obtenerIdE());
        return cadena;
    }
    
    
    
}
