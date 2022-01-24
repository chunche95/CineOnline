/**
 * • En caso de que seamos usuarios, nos mostrará un menú que conste de las siguientes
 *  opciones:
 *      o Mostrar película con menor media
 *      o Mostrar película con mayor media
 *      o Mostrar el crítico que menor puntuación media ha dado a todas las películas (Si hay varias, 
 *        mostrar solo una de ellas)
 *      o Mostrar las películas con más de 3 de media
 *      o Finalizar el programa
 */
package net.humancomputing.cineonline;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * @version 0.1
 * @author Paulino Esteban Bermudez Rodriguez
 */
public class Usuarios {
    public static void usuarios() throws IOException {
        menu();
    }
    public static void menu() throws IOException {
        // Menu de critico.
        String usuario = System.getProperty("user.name");
        System.out.println("+------------------------------------------------+");
        System.out.println(" | BIENVENIDO AL MENU DE USUARIOS DE CINE.       |");
        System.out.println("+------------------------------------------------+");
        System.out.printf(" %s ",usuario);
        System.out.println("Opciones:");
        System.out.println("");
        System.out.println(" 1) Mostrar peliculas con menor media.");
        System.out.println(" 2) Mostrar peliculas con mayor media.");
        System.out.println(" 3) Mostrar critico que menor puntuacion media da a las peliculas.");
        System.out.println(" 4) Mostrar peliculas con +3 estrellas de media.");
        System.out.println("------------------------------------");
        System.out.println(" 5) Finalizar el programa.");
        System.out.println("------------------------------------");
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
                menu();
                break;
            case 2:
                // Mostramos la mayor media en las peliculas
                mayorMedia();
                menu();
                break;
            case 3:
                // Critico mas exigente
                criticoExigente();
                menu();
                break;
            case 4:
                masDeTresE();       
                menu();
                break;
            case 5:
                salida();
                System.out.println("");
                System.out.printf("ADIOS %s", usuario);
                System.out.println("");
                System.out.println("Programa finalizado.");
                System.exit(0);
                break;
            case 0:
                // Volvemos al menu principal del programa.
                Main.menu();
                break;
            default:
                System.out.println("((((¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡))))");
                System.out.println("( Error en la opcion que ha escrito, vuelva a intentarlo de nuevo. )");
                System.out.println("((((¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡))))");
                // Volvemos a mostrar el menu de Critico
                menu();
        } // Cierre del switch
    } // Cierre del metodo menu   
    private static void menorMedia() {     
        int op=1;
        CalculosMenorYMayorMedia.notaMedia(op);
    }
    private static void mayorMedia() {
        int op=2;
        CalculosMenorYMayorMedia.notaMedia(op);
    }
    private static void criticoExigente() {
        
        String criticoExigente = Calculos.notaMedia();
        System.out.println("");
        System.out.printf("El critico más exigente es: %s",criticoExigente);
        System.out.println("");
        
    }
    private static void masDeTresE() {
        int op=3;
        CalculosMenorYMayorMedia.notaMedia(op);
    }
    
    public static void salida() {
        System.out.println("+----------------------------------------------------+");
        System.out.println("| Fin del programa.                                  |");
        System.out.println("| Gracias por evaluar CINE ONLINE MEK.               |");
        System.out.println("|                                                    |");
        System.out.println("| @universidad: UCLM                                 |");
        System.out.println("| @subject: Fundamentos de programacion I.           |");
        System.out.println("| @version: 22.01.19.beta                            |");
        System.out.println("| @authores: Paulino Esteban Bermudez R.             |");
        System.out.println("|      Kevin Alfonso Gomez S.                        |");
        System.out.println("|                                                    |");
        System.out.println("+----------------------------------------------------+");                
    }
} // Cierre de la clase Usuarios
