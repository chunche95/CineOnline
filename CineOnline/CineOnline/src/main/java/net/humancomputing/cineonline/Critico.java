/**
 * • En caso de que seamos críticos:
 *      o El sistema nos preguntará nuestro nombre y lo buscará en el sistema, donde el administrador 
 *        lo habrá escrito previamente
 *      o Si el nombre se encuentra en el fichero, le mostrará el nombre de cada película y le pedirá 
 *        la puntuación de cada una (del 1 al 5)    
 *      o Una vez hayamos terminado, guardará en el fichero correspondiente del crítico, 
 *        las calificaciones de cada película junto a su nombre. 
 *              Por ejemplo, el fichero Fernando.txt tendrá:
 *                      Máquina de Turing - 4
 *                      Scarface – 5
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
 * @author Kevin Alfonso Gomez Sandoval & Paulino Esteban Bermudez Rodriguez.
 */
public class Critico {
    public static void critico() throws IOException {
        menu();
    }
    public static void menu() throws IOException{
        // Menu de critico.
        System.out.println("\n\n\n");   
        System.out.println("+----------------------------------------+");
        System.out.println("| BIENVENIDO AL MENU DE CRITICO DE CINE. |");
        System.out.println("+----------------------------------------+");
        System.out.println("Opciones:");
        System.out.println("");
        System.out.println(" 1) Evaluar peliculas en cartelera.");
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
                // Dirigimos a dar de alta nuevas peliculas en el cine.
                buscarC(); 
                break;
            case 0:
                // Volvemos al menu principal del programa.
                Main.menu();
                break;
            default:
                System.out.println("\n ");
                System.out.println("Error en la opcion que ha escrito, vuelva a intentarlo de nuevo.");
                System.out.println("\n ");
                // Volvemos a mostrar el menu de Critico
                menu();
        } // Cierre del switch
    } // Cierre del metodo menu()
    private static void buscarC() throws IOException {        
        /**
        * Declaracion de las variables.
        */
        Scanner name;
        Scanner lecturaFicha;
        File ficheroCriticos;
        String nombreDelFichero;
        boolean existeCritico = false;
        // Inicio de la evaluacion de peliculas x critico.
        System.out.println("");
        System.out.println("Iniciemos la evaluacion de peliculas.");
        System.out.println("");
        System.out.println("Introduzca su nombre: \n");
        name = new Scanner(System.in);
        // Casterizamos de Scanner a tipo String para porder compararlo despues.
        String you = name.nextLine();
        try {            
            /** 
             * Comprobación del nombre del critico en el fichero de 'criticos.txt'
             */            
            nombreDelFichero = "criticos/criticos.txt";
            /**
             *  Busqueda, apertura y lectura del fichero 'criticos.txt' - DEBE EXISTIR
             */
            ficheroCriticos = new File(nombreDelFichero);
            lecturaFicha = new Scanner(ficheroCriticos);
            while (lecturaFicha.hasNextLine()){
                String nombreC = lecturaFicha.nextLine();
                // Buscamos al critico dentro del fichero - Debe estar 'CONTENIDO' dentro del txt de criticos.
                if (nombreC.contains(you)) {
                    existeCritico = true;
                    System.out.println("\t --- USUARIO ENCONTRADO! --- \n");
                    puntuarP(you);
                }
            }
            lecturaFicha.close();
        } catch(Exception e){
            System.out.println("\n\n\n");
            System.out.println(you);
            System.out.println("+--------------------------------------+");
            System.out.println("| UY! Ah ocurrido un error inesperado! |");
            System.out.println("+--------------------------------------+");
            System.out.println(e);
            System.out.println("+--------------------------------------+");
        } finally {
            System.out.println("Gracias " + you + "!");
            System.out.println("Ha terminado el programa de evaluación de peliculas.");
            // Volvemos al menu del principio.
            menu();
            
        }// Cierre del try-catch-finally
    } // Cierre del metodo puntuarPeliculas
    private static void puntuarP(String yourName) throws FileNotFoundException {
        /**
        * Declaracion de las variables.
        */
        Scanner nota;
        Scanner lecturaC;        
        PrintWriter Boli;
        PrintWriter Boli2;
        
        File carteleraCine;
        File fichaCritico;
        File fichaPeli;
        
        
        String nombreCartelera;
        String nombreCritico;
        String nombrePelicula;
        //int[] mediaCritico=null;
        //int[] mediaUnidad=null;
        
        int vuelta=0;
        int estrellas;
        try{
            // Iniciamos la lectura de 'cartelera.txt'
            nombreCartelera = "cartelera//cartelera.txt";
            // Iniciamos la escritura de puntuaciones en los ficheros del critico
            nombreCritico = "fichas//"+yourName+".txt"; 
            /**
             *  Busqueda, apertura y lectura de los ficheros 
             */
            String tituloPeli;
            carteleraCine= new File(nombreCartelera);
            fichaCritico = new File(nombreCritico);              
            // Creamos una ficha para el critico.
            Boli = new PrintWriter(new FileWriter(fichaCritico));
            // Lectura de los titulos en cartelera.
            lecturaC = new Scanner(carteleraCine);            
            while (lecturaC.hasNextLine()){
                ++vuelta;
                tituloPeli = lecturaC.nextLine();
                fichaPeli = new File(tituloPeli);
                // Añadimos más lineas al fichero para que no sobreescriba
                Boli2 = new PrintWriter(new FileWriter(fichaPeli.getAbsoluteFile(),true));
                // Escribimos la nota dentro del fichero de la pelicula.
                nombrePelicula = "pelicula//"+tituloPeli+".txt";
                System.out.println("--------------------------------------");
                System.out.printf("-> Titulo: %s \n",tituloPeli);
                System.out.println("--------------------------------------");
                System.out.printf("---> Escribe las puntuacion para %s (1-5): ",tituloPeli);
                System.out.println("");
                nota = new Scanner(System.in);
                estrellas = nota.nextInt();
                if ((estrellas < 1) || (estrellas > 5)) {
                    System.out.println(" --> FUERA DEL RANGO DE PUNTACION" + tituloPeli +" - " + estrellas );
                    System.out.println("");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("! \t ERROR DE PUNTUCION");
                    System.out.println("! \t "+ yourName+" - Introduciste una nota no valida.");
                    System.out.println("! \t Las estrellas no se guardaran para este titulo.");
                    System.out.println("! \t ");
                    System.out.println("! \t Si quieres puntuarla, deberas volver a iniciar la evaluacion.");
                    System.out.println("! \t");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("");
                } else {
                    Boli.println(tituloPeli +" - " + estrellas);                    
                    Boli2.println(estrellas);
                }
                Boli2.close();
            }
            lecturaC.close();
            Boli.close();
            
        } catch(Exception e){
            System.out.println("+--------------------------------------+");
            System.out.println("| UY! Ah ocurrido un error inesperado! |");
            System.out.printf( "| %s debes contactar con el admin.     |\n",yourName);
            System.out.println("+--------------------------------------+");
            System.out.println(e);
            System.out.println("+--------------------------------------+");
            System.out.println("");
        } // Cierre del try-catch
    } // Cierre del metodo puntuarP    
} // Cierre de la clase Critico

