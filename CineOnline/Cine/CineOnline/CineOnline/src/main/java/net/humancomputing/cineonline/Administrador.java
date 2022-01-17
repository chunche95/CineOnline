/**
 *  En caso de que seamos administrador:
 *      o Leer del teclado el número N de películas que tiene el cine
 *      o Leer del teclado los títulos de las N películas
 *      o Leer del teclado el número M de críticos
 *      o Leer del teclado el nombre de los M críticos
 *      o Una vez que hayamos escrito el nombre de todos los críticos, crearemos un fichero por 
 *        cada crítico y un único fichero que contenga el nombre de las películas. 
 *        Si fuese necesario, se puede crear un fichero que contenga todos los críticos.
 */
package net.humancomputing.cineonline;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *@version 0.1
 * @author Paulino Esteban Bermudez R.
 */
public class Administrador {
    public static void administrador() throws IOException {
        menu();
    } // Cierre del metodo administrador()
    public static void menu() throws IOException {
        // Menu de administrador.
        System.out.println("+--------------------------------------+");
        System.out.println("| BIENVENIDO AL MENU DE ADMINISTRADOR. |");
        System.out.println("+--------------------------------------+");
        System.out.println("Opciones:");
        System.out.println("");
        System.out.println(" 1) Dar de alta peliculas en el cine.");
        System.out.println(" 2) Dar de alta criticos en el cine.");
        System.out.println("------------------------------------");
        System.out.println("| 3) Volver al menu principal.      |");
        System.out.println("------------------------------------");
        System.out.println("Introduzca el numero de la opcion.");        
        // Guardamos la opcion seleccionada.     
        Scanner op = new Scanner(System.in);        
        // Casteamos el Scanner a tipo Integer
        int opcion = op.nextInt();
        // Verificamos que la opcion escrita sea valida.
        switch(opcion){
            case 1: 
                // Dirigimos a dar de alta nuevas peliculas en el cine.
                altaPeliculas(); 
                break;
            case 2:
                // Dirigimos a dar de alta nuevos criticos en el cine.
                altaCriticos();
                break;
            case 3:
                // Volvemos al menu principal del programa.
                
                /** ***********************************************************
                 * menuPrincipal();
                 *  ***********************************************************/
                
                break;
            default:
                System.out.println("Error en la opción que ha escrito, vuelva a intentarlo de nuevo.");
                // Volvemos a mostrar el menu de
                menu();
        } // Cierre del switch
    } // Cierre del metodo menu()
    
    public static void altaPeliculas() throws IOException {
        Scanner altaP;
        System.out.println("");
        System.out.println("+----------------------------+");
        System.out.println("| MENU DE ALTA DE PELICULAS. |");
        System.out.println("+----------------------------+");
        System.out.println("");
        System.out.println("Introduzca cuantas peliculas quiere dar de alta: \n");
        // Guardamos el numero de peliculas que se quieren dar de alta.
        altaP = new Scanner(System.in);
        // El Scanner lo pasamos a tipo Int
        int nuevaP = altaP.nextInt();
        
        /*************
         * Escritura *
         *************/
        
        /* ------------------------ 
        * Declaracion de variables.
        --------------------------- */
        int contador=0;
        File HojaPapel; // variable del programa.
        PrintWriter Boli; //Como un SYSO pero para ficheros.
        String carteleraCine = "cartelera.txt"; // Titulo de mi fichero - Cartelera del cine
        HojaPapel = new File(carteleraCine); // Cojo el papel
        Boli = new PrintWriter(new FileWriter(HojaPapel));
        boolean masPeliculas = true;
        /************************************************************
        * Ahora sí, vamos a comenzar a escribir dentro del fichero. *
        *************************************************************/
        // Creamos un bucle que nos vaya dando de alta en cartelera nuevas peliculas
        do {
            System.out.println("····························");
            System.out.println("·  ¿Nombre de la pelicula? ·");
            System.out.println("····························");
            Scanner escriboPeliculaEnFichero = new Scanner(System.in);
            // Almaceno el nombre del titulo de la pelicula en memoria
            String nombreP = escriboPeliculaEnFichero.next();
            Boli.println(nuevaP);            
            System.out.printf("Pelicula nº: %d \n",contador);            
            // Comprobacion de contador y peliculas que se deben dar de alta
            if (contador <= nuevaP) {
                masPeliculas = true;
                contador++;
            } else {
                System.out.printf("Introdujo %d \n NO se introduciran mas peliculas!\n Cerramos fichero.\n",contador);
                masPeliculas = false;
            }
        } while (!masPeliculas);
        // Terminamos la cartelera de peliculas del cine
        Boli.close();        
    }
    public static void altaCriticos() throws IOException {
        Scanner altaC;
        System.out.println("");
        System.out.println("+----------------------------+");
        System.out.println("| MENU DE ALTA DE CRITICOS. |");
        System.out.println("+----------------------------+");
        System.out.println("");
        System.out.println("Introduzca cuantos criticos quiere dar de alta: \n");
        // Guardamos el numero de peliculas que se quieren dar de alta.
        altaC = new Scanner(System.in);
        // El Scanner lo pasamos a tipo Int
        int nuevoC = altaC.nextInt();
        
        /*************
         * Escritura *
         *************/
        
        /* ------------------------ 
        * Declaracion de variables.
        --------------------------- */
        int contador = 0;
        File HojaPapel; // variable del programa.
        PrintWriter Boli; //Como un SYSO pero para ficheros.
        String fichaCriticos = "criticos.txt"; // Titulo de mi fichero - Ficha de los criticos del cine
        HojaPapel = new File(fichaCriticos); // Cojo el papel
        Boli = new PrintWriter(new FileWriter(HojaPapel));
        boolean masCriticos = true;
        /************************************************************
        * Ahora sí, vamos a comenzar a escribir dentro del fichero. *
        *************************************************************/
        // Creamos un bucle que nos vaya dando de alta los criticos
        do {
            System.out.println("····························");
            System.out.println("·   ¿Nombre del critico?   ·");
            System.out.println("····························");
            Scanner escriboCriticoEnFichero = new Scanner(System.in);
            // Almaceno el nombre del titulo de la pelicula en memoria
            String nombreP = escriboCriticoEnFichero.next();
            Boli.println(nuevoC);
            System.out.printf("Pelicula nº: %d \n",contador);            
            // Comprobacion de contador y criticos que se deben dar de alta
            if (contador <= nuevoC) {
                masCriticos = true;
                contador++;
            } else {
                System.out.printf("Introdujo %d \n NO se introduciran mas criticos!\n Cerramos fichero.\n",contador);
                masCriticos = false;
            }
        } while (!masCriticos);
        // Terminamos la ficha de criticos de peliculas del cine
        Boli.close();        
    }
} // Class Administrador
