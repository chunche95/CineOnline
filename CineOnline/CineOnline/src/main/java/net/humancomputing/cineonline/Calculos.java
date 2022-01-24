/*
 * Clase que realiza el calculo de la media de las peliculas de un usuario/critico y muestra el más exigente.
 */
package net.humancomputing.cineonline;

import java.io.*;
import java.util.Scanner;

/**
 * @version 0.3
 * @authores: Kevin Alfonso Gomez Sandoval & Paulino Esteban Bermúdez Rodríguez | humancomputing.net
 */
public class Calculos {
    /********************************************************************
    * Datos necesario:                                                  *
    * - Los criticos                                                    *
    * - Nº de peliculas                                                 *
    * - Notas de c/u de las peliculas                                   *
    *                                                                   *
    * Para desarrollar estos metodos:                                   *
    * + Leere la ficha del critico                                      *
    * + Obtendre el ultimo caracter de la linea leida - la nota         *
    * + Asociare el titulo de cartelera al caracter obtenido            *
    * + Calculamos su media y usamos en c/u de los metodos.             *
    *********************************************************************/
    // Obtenemos el numero de peliculas que tiene el cine.
    public static int totalPeliculas() throws FileNotFoundException {
        Scanner lecturaCartelera;
        File carteleraPublicada;
        String nombreDelFichero;
        String titulo;
        int total=0;
        /*
         * Peticion de datos
         */
        nombreDelFichero="cartelera/cartelera.txt";
        /**
         * Lectura del fichero
         */
        carteleraPublicada = new File(nombreDelFichero);
        lecturaCartelera = new Scanner(carteleraPublicada);
        while(lecturaCartelera.hasNextLine()){
            titulo = lecturaCartelera.nextLine();
            total++;
        }        
        return total;        
    }
    
    // Obtenemos la calificacion de cada pelicula
    public static String notaMedia() {
        String c="";
        try {
            /**
             * 1) Leo los criticos dados de alta
             * 2) Leer cada fichero de cada critico
             * 3) Calcular la media
             */
            
            /*************************************************************
             *  LECTURA DE FICHERO CRITICOS - dados de alta por el admin
             *************************************************************/
            // Variables necesarias
            Scanner leerAltas;
            File fichaCritico;
            String nombreDelFichero;
            int puntuacionPelicula=0;
            int contadorDeLinea=0; // Sirve para saber cuantas lineas tiene el fichero
            float media = 0;
            float mediaTotal=0; 
            float menorMediaTotal = 5;
            float mayorMediaTotal =0;
            String nombreDelCritico = "";
            
            /**
             * Peticion de datos
             */
            nombreDelFichero = "criticos/criticos.txt"; // Buscamos el txt en la carpeta
            fichaCritico = new File(nombreDelFichero); // Empezamos a leer el fichero con el buffer del sistema
            leerAltas = new Scanner(fichaCritico); // Iniciamos la lectura 
            /**
             * LECTURA DE FICHEROS
             */
            while(leerAltas.hasNextLine()){
                nombreDelCritico = leerAltas.nextLine(); // Guardamos el nombre del critico 
                /**************************************************************
                 * LECTURA DE LAS FICHAS CON LAS PUNTUACIONES DE LOS CRITICOS
                 **************************************************************/
                Scanner leerFicha;
                File evaluacionCritica;
                String evaluacionPeli;
                /**
                 * Peticion de datos
                 */
                evaluacionPeli = "fichas/"+nombreDelCritico+".txt";
                System.out.println("Ficha:"+evaluacionPeli);
                evaluacionCritica = new File(evaluacionPeli);
                leerFicha = new Scanner(evaluacionCritica);                
                while(leerFicha.hasNextLine()){                    
                    String linea = leerFicha.nextLine(); // Leemos la linea de la evaluacion critica 
                    String divisionLinea = linea;
                    String[] parts = divisionLinea.split("-");
                    String tituloPelicula = parts[0];
                    String puntuacionP = parts[1]; 
                    // Casteamos de String a Integer y eliminamos el espacio
                    puntuacionPelicula = Integer.valueOf(puntuacionP.trim()); 
                    // Sacar media del critico  según el numero total de peliculas publicadas.
                    int totalPelisEnCartelera = totalPeliculas();                    
                    for (int i = 0; i < totalPelisEnCartelera; i++) {   
                        media =puntuacionPelicula; 
                        // Guardamos la nota del critico
                        if (media < menorMediaTotal) { 
                            menorMediaTotal = media; 
                        } 
                        if (media > mayorMediaTotal) { 
                            mayorMediaTotal = media; 
                        }
                    }
                    mediaTotal+= media;
                    contadorDeLinea++;                                   
                    
                }                
                mediaTotal = mediaTotal/contadorDeLinea;
                 
                // Devolvemos el nombre del critico
                c = nombreDelCritico;
                // Una vez hecha la media, reiniciamos las variables iniciales.
                mediaTotal=0;
                media=0;
                contadorDeLinea=0;
            }                
        } catch (FileNotFoundException e1){
            System.out.println("");
            System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
            System.out.println(" Fichero no encontrado...Verifique sus datos y vuelva a ejecutarlo con otros datos diferentes.");
            System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
            System.out.println(" Error ocurrido: " + e1);
            System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
        } catch (Exception e2){
            System.out.println("");
            System.out.println("Error:");
            System.out.println(e2);
        }
    return c;    
    } // Cierre del metodo notaMedia()    
} // Cierre de la clase calculos