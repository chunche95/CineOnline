/**
 * Clase que contiene los metodos para calcular la menor y mayor media de las peliculas.
 */
package net.humancomputing.cineonline;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @version 0.3
 * @authores: Kevin Alfonso Gomez Sandoval & Paulino Esteban Bermúdez Rodríguez | humancomputing.net
 */

public class CalculosMenorYMayorMedia {    
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
    // Obtenemos el numero de peliculas que tiene el cine.
    public static int totalCriticos() throws FileNotFoundException {
        Scanner lecturaCartelera;
        File carteleraPublicada;
        String nombreDelFichero;
        String titulo;
        int total2=0;
        /*
         * Peticion de datos
         */
        nombreDelFichero="criticos/criticos.txt";
        /**
         * Lectura del fichero
         */
        carteleraPublicada = new File(nombreDelFichero);
        lecturaCartelera = new Scanner(carteleraPublicada);
        while(lecturaCartelera.hasNextLine()){
            titulo = lecturaCartelera.nextLine();
            total2++;
        }        
        return total2;        
    }
    
    // Obtenemos la calificacion de cada pelicula
    public static void notaMedia(int opcionSeleccionada) {
        float mediaTotal=0; 
        try {
            /**
             * 1) Leo los criticos dados de alta
             * 2) Leer cada fichero de cada critico
             * 3) Genero un array igual de grande que el numero de peliculas guardadas
             * 4) Hacemos un sumatorio para cada pelicula :=> posicion del array[i] + puntos
             */
            
            /*************************************************************
             *  LECTURA DE FICHERO CRITICOS - dados de alta por el admin
             *************************************************************/
            // Variables necesarias
            Scanner leerCartelera;
            File fichaCartelera;
            String nombreDelFichero;
             // Sirve para saber cuantas lineas tiene el fichero 
            int contadorDeLinea=0;
            int contador = 0;
            float notaMinima=5;
            float notaMaxima=0;
            float notaMedMasAlta;
            float notaMedMasBaja;
            int puntuacion;
            String tituloPeli;
            /**
             * Peticion de datos
             */
            nombreDelFichero = "cartelera/cartelera.txt"; // Buscamos el txt en la carpeta
            fichaCartelera = new File(nombreDelFichero);
            leerCartelera = new Scanner(fichaCartelera) ;
            while(leerCartelera.hasNextLine()){
                mediaTotal=0;
                contadorDeLinea=0;
                tituloPeli = leerCartelera.nextLine();                
                /*******************************************************************
                 * Leemos las notas que tiene almacenado el fichero de la pelicula *
                 *******************************************************************/
                Scanner readP;
                File filePeli;
                String namePeli;
                float puntuaciones[] = new float[Calculos.totalPeliculas()];
                
                /**
                 * Peticion de datos
                 */
                namePeli = tituloPeli;
                filePeli = new File(namePeli);
                readP = new Scanner(filePeli);
                while(readP.hasNextLine()){ 
                    contadorDeLinea++; 
                    String p = readP.nextLine(); 
                    puntuacion = Integer.parseInt(p); 
                    mediaTotal += puntuacion; 
                }
                mediaTotal /= contadorDeLinea; 
                puntuaciones[contador]=mediaTotal;
                contador++;
                notaMedMasAlta=peliculaMasAlta(puntuaciones); 
                notaMedMasBaja=peliculaMasBaja(puntuaciones);
                float infinita[] = new float[Calculos.totalPeliculas()];
                infinita[contador]=notaMedMasAlta;
                switch(opcionSeleccionada){
                    case 1:
                        // Mas baja  
                        float aux=0;
                        for (int i = 0; i < (infinita.length-1); i++) {
                            if ( infinita[i] < infinita[i+1] && infinita[i+1] != 0){
                                aux=infinita[i];
                            }
                        }
                        mediaMasBaja(notaMedMasBaja, tituloPeli);
                        break;
                    case 2:
                        // Mas alta
                        aux=0;
                        for (int i = 0; i < (infinita.length-1); i++) {
                            if ( infinita[i] > infinita[i+1] ) {
                                aux=infinita[i];
                            }
                        }
                        mediaMasAlta(aux, tituloPeli);                        
                        
                        break;
                    case 3:
                        // +3
                        if (mediaTotal > 3.0) {
                            masDeTres(mediaTotal, tituloPeli);
                        }
                        break;
                    case 4:
                        votos(contadorDeLinea);
                        mediaMasAlta(notaMaxima, tituloPeli);
                        break;
                    default:
                        System.out.println("Error sin sentido.");
                } // Cierre del switch
            } // Lectura de cartelera                
        } catch (FileNotFoundException e1){
            System.out.println("");
            System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
            System.out.println(" Fichero no encontrado...Verifique sus datos y vuelva a ejecutarlo con otros datos diferentes.");
            System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
            System.out.println(" Error ocurrido: " + e1);
            System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
        } /* catch (Exception e2){
            System.out.println("");
            System.out.println("EEEEEYYYYY!!! Hubo un error:");
            System.out.println(e2);
        } */
        
    
    } // Cierre del metodo notaMedia() 
    
    // Sobrecargamos los metodos de calculo de medias
    public static void mediaMasAlta(float mediaTotal, String titulo) {
        System.out.println("La pelicula " +  titulo + " con la puntuacion mas alta es: " + mediaTotal);        
    }    
    public static void mediaMasBaja(float mediaTotal, String titulo ) {
        System.out.println("La pelicula " +  titulo + " con la puntuacion mas baja es: " + mediaTotal);        
    }
    public static void masDeTres(float mediaTotal, String titulo ) {
        System.out.println("");
        System.out.printf("La pelicula %s tiene la puntuacion: %f ",titulo,mediaTotal);
        System.out.println("");
    }
    public static void votos(int votos){
        System.out.println("Total de votos:" + votos);
    }
    public static float peliculaMasBaja(float[] puntos) {
        float menor=5;
        for (int i = 0; i < puntos.length; i++) {
            if (puntos[i] < menor) {
                menor = puntos[i];
            }
        }
        return menor;
    }
    public static float peliculaMasAlta(float[] puntos) {
        float mayor=0;
        for (int i = 0; i < puntos.length; i++) {
            if (puntos[i] > mayor) {
                mayor = puntos[i];
            }
        }
        return mayor;
    }
} // Cierre de la clase calculos
