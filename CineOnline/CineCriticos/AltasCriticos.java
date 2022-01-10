package trabajoclase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AltasCriticos {

	
	
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
	}
	
	public static void main(String[] args) throws IOException {
		
		// 1 Preguntar por el critico al usuario
		Scanner sc = new Scanner(System.in);
		boolean existeCritico = false;
		do {
			System.out.print("Cual es el crítico?");
			String nombre = sc.nextLine();
			
			// 2 Buscar el critico en la lista
			existeCritico = existeCritico(nombre);
			if (existeCritico) {
				puntuarPeliculas(nombre);
			} else {
				System.out.println("El crítico no está dado de alta");
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
	
}
