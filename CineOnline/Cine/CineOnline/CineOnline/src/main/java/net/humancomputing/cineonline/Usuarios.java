/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.humancomputing.cineonline;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * @version 
 * @author Paulino Esteban Bermudez Rodriguez
 */
public class Usuarios {
    public static void usuarios() {
        menu();
    }
    public static void menu() {
        // Menu de critico.
        System.out.println("+-----------------------------------------+");
        System.out.println("| BIENVENIDO AL MENU DE USUARIOS DE CINE. |");
        System.out.println("+-----------------------------------------+");
        System.out.println("Opciones:");
        System.out.println("");
        System.out.println(" 1) Mostrar peliculas con menor media.");
        System.out.println(" 2) Mostrar peliculas con mayor media.");
        System.out.println(" 3) Mostrar critico que menor puntuacion media da a las peliculas.");
        System.out.println(" 4) Mostrar peliculas con +3 estrellas de media.");
        System.out.println("");
        System.out.println("------------------------------------");
        System.out.println("| 0) Volver al menu principal.      |");
        System.out.println("------------------------------------");
        System.out.println("Introduzca el numero de la opcion.");        
        // Guardamos la opcion seleccionada.     
        Scanner op = new Scanner(System.in);        
        // Casteamos el Scanner a tipo Integer
        int opcion = op.nextInt();
        // Verificamos que la opcion escrita sea valida.
        switch(opcion){
            case 1: 
                // Mostramos la menor media en las peliculas
                menorMedia(); 
                break;
            case 2:
                // Mostramos la mayor media en las peliculas
                mayorMedia();
                break;
            case 3:
                // Critico mas exigente
                criticoExigente();
                break;
            case 4:
                masDeTresE();                
            case 0:
                // Volvemos al menu principal del programa.
                
                /** ***********************************************************
                 * menuPrincipal();
                 *  ***********************************************************/
                
                break;
            default:
                System.out.println("Error en la opcion que ha escrito, vuelva a intentarlo de nuevo.");
                // Volvemos a mostrar el menu de Critico
                menu();
        } // Cierre del switch
    } // Cierre del metodo menu

    private static void menorMedia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void mayorMedia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void criticoExigente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void masDeTresE() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
} // Cierre de la clase Usuarios
