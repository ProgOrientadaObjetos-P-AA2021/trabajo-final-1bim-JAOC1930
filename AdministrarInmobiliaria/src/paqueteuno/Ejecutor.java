/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteuno;

import java.util.Scanner;
import paquetecinco.ArchivoEscrituraCons;
import paquetecinco.ArchivoLecturaCons;
import paquetecinco.Constructora;
import paquetecuatro.ArchivoEscrituraCiu;
import paquetecuatro.ArchivoLecturaCiu;
import paquetecuatro.Ciudad;
import paquetedos.ArchivoEscrituraPro;
import paquetedos.ArchivoLecturaPro;
import paquetedos.Propietario;
import paqueteseis.ArchivoEscribirCasa;
import paqueteseis.ArchivoEscrituraDepa;
import paqueteseis.ArchivoLecturaCasa;
import paqueteseis.ArchivoLecturaDepa;
import paqueteseis.Casa;
import paqueteseis.Departamento;
import paquetetres.ArchivoEscrituraUbi;
import paquetetres.ArchivoLecturaUbi;
import paquetetres.Ubicacion;

/**
 *
 * @author reroes
 */
public class Ejecutor {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int op;
        boolean var = true;
        while (var) {
            System.out.println("1 para propietarios\n2 para Ubicaciones\n3 para ciudades\n"
                    + "4 para constructoras\n5 para casas\n6 para departamentos");
            op = entrada.nextInt();
            if (op == 1) {
                propietarios();
            } else {
                if (op == 2) {
                    ubicacion();
                } else {
                    if (op == 3) {
                        ciudad();
                    } else {
                        if (op == 4) {
                            constructora();
                        } else {
                            if (op == 5) {
                                casa();
                            } else {
                                if (op == 6) {
                                    departamento();
                                } else {
                                    System.out.println("El valor que ingreso "
                                            + "no existe");
                                }
                            }
                        }
                    }
                }
            }
            entrada.nextLine();
            System.out.println("ponga si para ya no agregar valores");
            String conf = entrada.nextLine();
            if (conf.toLowerCase().equals("si")) {
                var = false;
            }
        }
    }

    public static void propietarios() {
        Scanner entrada = new Scanner(System.in);
        String nArchivo = "Propietarios.data";
        String nombre;
        String apellidos;
        String identificacion;
        System.out.println("Ingrese el nombre");
        nombre = entrada.nextLine();
        System.out.println("Ingrese el apellido");
        apellidos = entrada.nextLine();
        System.out.println("Ingrese identificaion");
        identificacion = entrada.nextLine();

        Propietario propietario = new Propietario(nombre, apellidos, identificacion);

        ArchivoEscrituraPro archivo = new ArchivoEscrituraPro(nArchivo);
        archivo.establecerRegistro(propietario);
        archivo.establecerSalida();
        archivo.cerrarArchivo();

        ArchivoLecturaPro lectura = new ArchivoLecturaPro(nArchivo);
        lectura.establecerPropietarios();
        System.out.println(lectura);
    }

    public static void ubicacion() {
        Scanner entrada = new Scanner(System.in);
        String nArchivo = "Ubicacion.data";
        int numeroCasa;
        String nombreBarrio;
        String referencia;
        System.out.println("Ingrese el numero de casa");
        numeroCasa = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Ingrese nombre del barrio");
        nombreBarrio = entrada.nextLine();
        System.out.println("Referencia");
        referencia = entrada.nextLine();

        Ubicacion ubicacion = new Ubicacion(numeroCasa, nombreBarrio, referencia);

        ArchivoEscrituraUbi archivo = new ArchivoEscrituraUbi(nArchivo);
        archivo.establecerRegistro(ubicacion);
        archivo.establecerSalida();
        archivo.cerrarArchivo();

        ArchivoLecturaUbi lectura = new ArchivoLecturaUbi(nArchivo);
        lectura.establecerUbicaciones();
        System.out.println(lectura);
    }

    public static void ciudad() {
        Scanner entrada = new Scanner(System.in);
        String nArchivo = "Ciudad.data";
        String nCiudad;
        String provincia;
        System.out.println("Ingrese nombre de la ciudad");
        nCiudad = entrada.nextLine();
        System.out.println("Ingrese el nombre de la provincia");
        provincia = entrada.nextLine();

        Ciudad ciudad = new Ciudad(nCiudad, provincia);

        ArchivoEscrituraCiu archivo = new ArchivoEscrituraCiu(nArchivo);
        archivo.establecerRegistroCiudad(ciudad);
        archivo.establecerSalida();
        archivo.cerrarArchivo();

        ArchivoLecturaCiu lectura = new ArchivoLecturaCiu(nArchivo);
        lectura.establecerCiudad();
        System.out.println(lectura);

    }

    public static void constructora() {
        Scanner entrada = new Scanner(System.in);
        String nArchivo = "Constructora.data";
        String nConstructora;
        int idE;
        System.out.println("Ingrese el nomnre de la constructora");
        nConstructora = entrada.nextLine();
        System.out.println("Ingrese la id de la empresa");
        idE = entrada.nextInt();

        Constructora constructora = new Constructora(nConstructora, idE);

        ArchivoEscrituraCons archivo = new ArchivoEscrituraCons(nArchivo);
        archivo.establecerRegistroConstructora(constructora);
        archivo.establecerSalida();
        archivo.cerrarArchivo();

        ArchivoLecturaCons lectura = new ArchivoLecturaCons(nArchivo);
        lectura.establecerConstrutora();
        System.out.println(lectura);
    }

    public static void casa() {
        Scanner entrada = new Scanner(System.in);
        String nArchivo = "Casa.data";
        String pro;
        double pMetroCuadrado;
        double nMetroCuadrado;
        int ubi;
        String nCiudad;
        int nCuartos;
        int idE;
        System.out.println("Ingrese la identifacion del propietario para hallar "
                + "al propietario");
        pro = entrada.nextLine();

        ArchivoLecturaPro lecturaPro = new ArchivoLecturaPro("Propietarios.data");
        lecturaPro.establecerPropietarios();
        lecturaPro.establecerPropietarioObjeto(pro);
        Propietario propietario = lecturaPro.obtenerPropietariosObjeto();

        if (propietario != null) {
            System.out.println("Ingrese el precio de metros cuadrados");
            pMetroCuadrado = entrada.nextDouble();
            System.out.println("Ingrese el numero de metros cuadrados");
            nMetroCuadrado = entrada.nextDouble();
            System.out.println("Ingrese el numero de casa para hallar la ubicacion");
            ubi = entrada.nextInt();
            ArchivoLecturaUbi lecturaUbi = new ArchivoLecturaUbi("Ubicacion.data");
            lecturaUbi.establecerUbicaciones();
            lecturaUbi.establecerUbicacionObjeto(ubi);
            Ubicacion ubicacion = lecturaUbi.obtenerUbicacionObjeto();
            if (ubicacion != null) {
                entrada.nextLine();
                System.out.println("Ingrese nombre de la ciudad para encontrar la ciudad");
                nCiudad = entrada.nextLine();
                System.out.println("Ingrese el numero de cuartos");
                nCuartos = entrada.nextInt();
                ArchivoLecturaCiu lecturaCiu = new ArchivoLecturaCiu("Ciudad.data");
                lecturaCiu.establecerCiudad();
                lecturaCiu.establecerCiudadObjeto(nCiudad);
                Ciudad ciudad = lecturaCiu.obtenerCiudadObjeto();
                if (ciudad != null) {
                    System.out.println("Ingrese la id de la empresa de constructora "
                            + "para hallar la constructora");
                    idE = entrada.nextInt();
                    ArchivoLecturaCons lecturaCons = new ArchivoLecturaCons("Constructora.data");
                    lecturaCons.establecerConstrutora();
                    lecturaCons.establecerConstructoraObjeto(idE);
                    Constructora constructora = lecturaCons.obtenerConstructoraObjeto();
                    if (constructora != null) {
                        Casa casa = new Casa(propietario, pMetroCuadrado,
                                nMetroCuadrado, ubicacion, ciudad, nCuartos,
                                constructora);
                        casa.calcularCostoFinal();
                        System.out.println(casa);
                        ArchivoEscribirCasa archivo
                                = new ArchivoEscribirCasa(nArchivo);
                        archivo.establecerRegistro(casa);
                        archivo.establecerSalida();
                        archivo.cerrarArchivo();

                        ArchivoLecturaCasa lectura = new ArchivoLecturaCasa(nArchivo);
                        lectura.establecerCasas();
                        // System.out.println(lectura);

                    } else {
                        System.out.println("Ingrese valores en constructora");
                    }
                } else {
                    System.out.println("Ingrese valores en ciudad");
                }
            } else {
                System.out.println("Ingrese valores en ubicacion");
            }
        } else {
            System.out.println("Ingrese valores a en propietario");
        }
    }

    public static void departamento() {
        Scanner entrada = new Scanner(System.in);
        String nArchivo = "Departamento.data";
        String pro;
        double pMetroCuadrado;
        double nMetroCuadrado;
        double vAliCoutaMensual;
        double precio;
        int ubi;
        String nCiudad;
        String nombreEdificio;
        String ubicacionDE;
        int idE;
        System.out.println("Ingrese la identifacion del propietario para hallar "
                + "al propietario");
        pro = entrada.nextLine();
        ArchivoLecturaPro lecturaPro = new ArchivoLecturaPro("Propietarios.data");
        lecturaPro.establecerPropietarios();
        lecturaPro.establecerPropietarioObjeto(pro);
        Propietario propietario = lecturaPro.obtenerPropietariosObjeto();
        if (propietario != null) {
            System.out.println("Ingrese el precio de metros cuadrados");
            pMetroCuadrado = entrada.nextDouble();
            System.out.println("Ingrese el numero de metros cuadrados");
            nMetroCuadrado = entrada.nextDouble();
            System.out.println("Ingrese el valor de alicuota mensual");
            vAliCoutaMensual = entrada.nextDouble();
            System.out.println("Ingrese el precio");
            precio = entrada.nextDouble();
            System.out.println("Ingrese el numero de casa para hallar la ubicacion");
            ubi = entrada.nextInt();
            ArchivoLecturaUbi lecturaUbi = new ArchivoLecturaUbi("Ubicacion.data");
            lecturaUbi.establecerUbicaciones();
            lecturaUbi.establecerUbicacionObjeto(ubi);
            Ubicacion ubicacion = lecturaUbi.obtenerUbicacionObjeto();
            if (ubicacion != null) {
                entrada.nextLine();
                System.out.println("Ingrese nombre de la ciudad para hallar la "
                        + "ciudad");
                nCiudad = entrada.nextLine();
                ArchivoLecturaCiu lecturaCiu = new ArchivoLecturaCiu("Ciudad.data");
                lecturaCiu.establecerCiudad();
                lecturaCiu.establecerCiudadObjeto(nCiudad);
                Ciudad ciudad = lecturaCiu.obtenerCiudadObjeto();
                if (ciudad != null) {
                    System.out.println("Ingrese el nombre del edificio");
                    nombreEdificio = entrada.nextLine();
                    System.out.println("Ingrese la ubicacion del edifico");
                    ubicacionDE = entrada.nextLine();
                    System.out.println("Ingrese la id de la empresa de constructora "
                            + "para hallar la constructora");
                    idE = entrada.nextInt();
                    ArchivoLecturaCons lecturaCons = new ArchivoLecturaCons("Constructora.data");
                    lecturaCons.establecerConstrutora();
                    lecturaCons.establecerConstructoraObjeto(idE);
                    Constructora constructora = lecturaCons.obtenerConstructoraObjeto();
                    if (constructora != null) {
                        Departamento departamento = new Departamento(propietario,
                                pMetroCuadrado, nMetroCuadrado, vAliCoutaMensual,
                                precio, ubicacion, ciudad, nombreEdificio, ubicacionDE,
                                constructora);
                        departamento.calcularCostoFinal();
                        System.out.println(departamento);

                        ArchivoEscrituraDepa archivo = new ArchivoEscrituraDepa(
                                nArchivo);
                        archivo.establecerRegistro(departamento);
                        archivo.establecerSalida();
                        archivo.cerrarArchivo();
                        ArchivoLecturaDepa lectura = new ArchivoLecturaDepa(nArchivo);
                        lectura.establecerDepartamento();
                        // System.out.println(lectura);
                    } else {
                        System.out.println("Ingrese valores en constructora");
                    }
                } else {
                    System.out.println("Ingrese valores en ciudad");
                }
            } else {
                System.out.println("Ingrese valores en ubicacion");
            }
        } else {
            System.out.println("Ingrese valores en propietarios");
        }
    }

}
