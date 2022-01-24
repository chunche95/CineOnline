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
 * @version 0.1
 * @author Kevin Alfonso Gomez Sandoval.
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
                // Dirigimos a dar de alta nuevas peliculas en el cine.
                altaPeliculas(); 
                menu();
                break;
            case 2:
                // Dirigimos a dar de alta nuevos criticos en el cine.
                altaCriticos();
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
        String carteleraCine = "cartelera//cartelera.txt"; // Titulo de mi fichero - Cartelera del cine        
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
            String nombreP = escriboPeliculaEnFichero.nextLine();
            String PeliculaDeCine = "pelicula//"+nombreP+".txt";
            Boli.println(nombreP);            
            contador++;
            System.out.printf("Pelicula nº: %d \n",contador);                        
            // Comprobacion de contador y peliculas que se deben dar de alta
            if (contador < nuevaP) {
                masPeliculas = false;
            } else {
                masPeliculas = true;
            }
        } while (!masPeliculas);
        // Terminamos la cartelera de peliculas del cine
        Boli.close();  
        
    }// Cierre del metodo AltaPeliculas    
    public static int altaCriticos() throws IOException {
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
        String fichaCriticos = "criticos//criticos.txt"; // Titulo de mi fichero - Ficha de los criticos del cine
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
            String nombreC = escriboCriticoEnFichero.nextLine();
            Boli.println(nombreC);
            contador++;
            System.out.printf("Critico nº: %d \n",contador);            
            // Comprobacion de contador y criticos que se deben dar de alta
            if (contador < nuevoC) {
                masCriticos = false;
            } else {                
                masCriticos = true;
            }
        } while (!masCriticos);
        // Terminamos la ficha de criticos de peliculas del cine
        Boli.close();        
        // Retornamos el numero de criticos guardados
        return nuevoC;
    } // Cierre del metodo AltaCriticos
} // Class Administrador
