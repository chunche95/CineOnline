/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.humancomputing.cineonline;

import java.io.IOException;
import java.util.Scanner;

/**
 * @version 0.1
 * @author Paulino Esteban Bermúdez Rodríguez | humancomputing.net
 */
public class Jurado {
    public static void jurado() throws IOException {
        menu();
    }
    public static void menu() throws IOException {
        // Menu de jurado
        System.out.println("+--------------------------------------+");
        System.out.println("| BIENVENIDO AL MENU DE JURADO.        |");
        System.out.println("+--------------------------------------+");
        System.out.println("Opciones:");
        System.out.println("");
        System.out.println(" 1) Pelicula ganadora de la cartelera.");
        System.out.println("------------------------------------");
        System.out.println("| 0) Volver al menu principal.      |");
        System.out.println("------------------------------------");
        System.out.println("Introduzca el numero de la opcion."); 
        Scanner op = new Scanner(System.in);        
        // Casteamos el Scanner a tipo Integer
        int opcion = op.nextInt();
        // Verificamos que la opcion escrita sea valida.
        switch(opcion){
            case 1: 
                // Dirigimos a dar de alta nuevas peliculas en el cine.
                ganadora(); 
                menu();
                break;            
            case 0:
                // Volvemos al menu principal del programa.
                Main.menu();
                break;
            default:
                System.out.println("Error en la opción que ha escrito, vuelva a intentarlo de nuevo.");
                // Volvemos a mostrar el menu de Administrador
                menu();
        } // Cierre del switch
    } // Cierre del menu()
    public static void ganadora() {
        CalculosMenorYMayorMedia.notaMedia(4);        
    }
}
