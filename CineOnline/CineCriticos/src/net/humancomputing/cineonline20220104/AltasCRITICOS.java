package net.humancomputing.cineonline20220104;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/** 
 * CRITICOS DE CINES MKE.
 * 
 * Tareas de criticos:
 * 
 * + Introducir su nombre.
 * +---> Buscar nombre y comprobar que existe.
 * 	+---> NO EXISTE! --> Sacar mensaje que no existe.
 * 	+---> EXISTE!
 * 		+ Mostrar nombres de las peliculas. (Lectura de fichero)
 * 		+ Pedir puntuaci�n c/u peliculas del 1-5
 * 		+ Guardar puntuaci�n c/u peliculas.
 *
 * @version 0.1
 * @author Luis Miguel Barreiro Cabello.
 */

/**
 * RECOMENDACIONES PARA EL DESARROLLO DEL APARTADO.
 * 
 * (HECHO!) Debes preguntar el nombre del critico, para que se escriba.
 * (HECHO!) Debes crear un método o algo que te busque la existencia del nombre del critico que se escribe por teclado.
 * 
 * (HECHO! - 'nombre'.txt) El fichero no puede llamarse Juan.txt, puede haber varias Juanes entre los criticos y el sistema fallaria.
 * 
 * (PENDIENTE!) - Tras encontrar el crítico, debes mostrarle las peliculas que el administrador dio de alta en el cine
 * (PENDIENTE!) - Debes pedirle una nota del 1 al 5 por cada pelicula que le muestras.  
 * 
 *
 * - También, podrías indicar la finalización del programa con un mensaje, o un mensaje y volviendo al menu principal.	  
 *  
 * (Adjunto ficheros para hacer las pruebas)
 * @author pauli
 *
 */
public class AltasCRITICOS {
	public static boolean existeCritico(String nombre) throws FileNotFoundException {		
		Scanner sc = new Scanner(new File("criticos.txt"));
		// ver si hay linea en el fichero por eso usamos el sc.hasNextLine
		while(sc.hasNextLine()) {
			String linea = sc.nextLine();
			if (linea.equals(nombre)) {
				sc.close();
				return true;
			}
		}		
		sc.close();
		return false;
	} // Cierre del método existeCritico	
	public static void main(String[] args) throws IOException {		
		// 1 Preguntar por el critico al usuario
		Scanner sc = new Scanner(System.in);
		boolean existeCritico = false;
		do {
			System.out.print("¿Nombre del critico? ");
			String nombre = sc.nextLine();			
			// 2 Buscar el critico en la lista
			existeCritico = existeCritico(nombre);
			if (existeCritico) {
				puntuarPeliculas(nombre);
			} else {
				System.out.println("El critico no esta dado de alta");
			}			
		} while(!existeCritico);		
	}	
	public static void puntuarPeliculas(String nombre) throws IOException {
		// crear fichero critico  nombre.txt		
		File critico = new File(nombre + ".txt");
		FileWriter fw = new FileWriter(critico);		
		// Leer fichero de peliculas
		// Para cada pelicula, pedir puntuacion al usuario
		// Escribir en el fichero del critico, la linea con pelicula + puntuacion		
		int valor=GenerarNumero();	
	}		
	public static int GenerarNumero() {
		int numero;
		numero=(int)(Math.random()*5-1);
		return numero;
	}		
}