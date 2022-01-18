package trabajo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.AnnotationTypeMismatchException;
import java.util.Scanner;
/** 
 * USUARIOS DE CINES MKE.
 * 
 * Tareas de usuarios:
 * 
 * + Mostrar peliculas con menor media
 * + Mostrar peliculas con mayor media
 * + Mostrar películas con +3 estrellas.
 * + Mostrar criticos que han dado menor puntuacion a todas las peliculas.
 *
 * @version 0.1
 * @author Efraín Enrique Ramírez Mojica.
 */
 /** 
 * USUARIOS DE CINES MKE.
 * 
 * Tareas de usuarios:
 * 
 * + Mostrar peliculas con menor media
 * + Mostrar peliculas con mayor media
 * + Mostrar peliculas con +3 estrellas.
 * + Mostrar criticos que han dado menor puntuacion a todas las peliculas.
 *
 * @version 0.1
 * @author Efrain Enrique Ramirez Mojica.
 */
/**
 * RECOMENDACIONES PARA EL DESARROLLO DEL APARTADO.
 * (HECHO!) - Menú de opciones
 *
 * (PENDIENTE!) - Desarrollar los métodos de cada opción.
 * 
 * 1 y 2) Para ver las peliculas de menor y mayor puntuacion, debes leer los ficheros de puntuacion de los criticos e ir almacenando la puntuacion de 1 al 5 que le dieron a la pelicula y luego 
 * mostrar la que tiene menos y mas nota segun sea (opcion 1 o 2 del menu)
 * 
 * 3) Para ver las peliculas de +3 puntos. Debes crear un sitio donde vayas leyendo la pelicula y la puntuacion, el que sea +3, lo guardas, en caso contrario, lo saltas.
 * 
 * 4) Para ver los criticos con menor puntuacion, debes sumar la nota del fichero de cada critico y hacer su media, la que de menos, se muestra el nombre.
 * 
 * (Adjunto ficheros para hacer las pruebas)
 * @author pauli
 *
 */

public class usuarios {
	


		public static void main(String[] args) throws IOException {
			//Declaración del objeto que nos permite la entrada de datos.
			Scanner leer = new Scanner(System.in);
			//Menu de opciones
			boolean salir = false;
			int opcion;
			
			while (! salir) {
				System.out.println("Bienvenido\n ¿que deseas hacer?");
				System.out.println(" 1. Mostrar peliculas con menor media ");
				System.out.println(" 2. Mostrar peliculas con mayor media ");
				System.out.println(" 3. Mostrar el critico que menor puntuacion media ha dado a todas las peliculas");
				System.out.println(" 4. Mostrar peliculas con +3 de media ");
				try {
					//Solicitamos que el usuario escoga una opcion y lo recibimos desde el teclado para guardarlo en la variable correspondiente
					System.out.println(" Introduce un numero de la opcion que desea realizar: ");
					opcion = leer.nextInt();
					
					switch (opcion) {
					
					case 1:
						System.out.println(" Esta es la opcion mostrar peliculas con menor media ");
						String peliMe= peliculasmenormedia ();
						break;
						
					case 2:
		            	System.out.println(" Esta es la opcion mostrar peliculas con mayor media ");
						String peliMa=peliculasmayormedia ();
		            	break;
						
		            case 3:
		            	System.out.println(" Esta es la opcion Mostrar el critico que menor puntuacion media ha dado a todas las peliculas");
						String Criticome =Criticomenor ();
		            	break;
						
		            case 4:
		            	System.out.println(" Esta es la opcion mostrar peliculas con +3 de media ");
						String pelis = peliculas3 ();
		            	break;
						
		            case 5:
		            	salir = true;
		 				break;
		 				default:
		 			System.out.println(" Las opciones son entre 1 y 5 ");
		 				} //Fin del Switch
					
					} catch (AnnotationTypeMismatchException e ) {  //Utilizamos un try y catch para que de error si no se escibe un numero y diga que debe ingresar un numero
						
						System.out.println(" Debes introducir un numero: ");
						leer.next();
				} //Fin del Catch
		          System.out.println(" Fin del menu ");
			}//Fin del While
		}//fin main
		
				public static String peliculasmenormedia () throws IOException {
			Scanner leer= new Scanner(System.in);
			File peliculasconmenormedia =new File ("menor.txt");
			PrintWriter salida = new PrintWriter (new FileWriter (peliculasconmenormedia));
			String nombre="";
			int pelicula;
			boolean MasAlias;
			String alias="";
			int puntaje;
				do {
					System.out.println("La pelicula con menor media es: ");
					nombre=leer.next();
					puntaje = (int)(Math.random()*6);
					salida.println(nombre +": " +puntaje);
					
					MasAlias=leer.next().equals("s");
					
					
				}//do
				while (MasAlias);
					salida.close();
					leer.close();
					
					Scanner leerFichero = new Scanner(peliculasconmenormedia);
					 while(leerFichero.hasNext()) {
						String peliculas=leerFichero.nextLine();
						int puntuacion=leerFichero.nextInt();
						int menor[]= new int [puntuacion];
					}//while
					 
		return peliculasmenormedia ();
	}//fin peliculasmenormedia
		
		
	public static String peliculasmayormedia () throws IOException {
		Scanner leer= new Scanner(System.in);
		File peliculasconmayormedia =new File ("mayor.txt");
		PrintWriter salida = new PrintWriter (new FileWriter (peliculasconmayormedia));
		String nombre="";
		boolean MasAlias;
		String alias="";
		int puntaje;
		do {
			System.out.println("La pelicula con mayor media es: ");
			nombre=leer.next();
			puntaje = (int)(Math.random()*6);
			salida.println(nombre +": " +puntaje);
			
			MasAlias=leer.next().equals("s");
		}//do
		while (MasAlias);
		salida.close();
		leer.close();
		
		Scanner leerFichero = new Scanner(peliculasconmayormedia);
		 while(leerFichero.hasNext()) {
			String peliculas=leerFichero.nextLine();
			int puntuacion=leerFichero.nextInt();
			int mayor[]= new int [puntuacion];
		}//while
		 
return peliculasmayormedia ();
}//fin peliculasmenormedia
	
	public static String Criticomenor () throws IOException {
		Scanner leer= new Scanner(System.in);
		File criticomenorpunt =new File ("critico.txt");
		PrintWriter salida = new PrintWriter (new FileWriter (criticomenorpunt));
		String nombre="";
		boolean MasAlias;
		String alias="";
		int puntaje;
		do {
			System.out.println("Este es el critico que menos puntuacion dio ");
			nombre=leer.next();
			puntaje = (int)(Math.random()*6);
			salida.println(nombre +": " +puntaje);
			
			MasAlias=leer.next().equals("s");
		}//do
		while (MasAlias);
		salida.close();
		leer.close();
		
		Scanner leerFichero = new Scanner(criticomenorpunt);
		 while(leerFichero.hasNext()) {
			String peliculas=leerFichero.nextLine();
			int puntuacion=leerFichero.nextInt();
			int critico[]= new int [puntuacion];
		}//while
		 
return Criticomenor();
		
	}//end critico menor
	
	public static String peliculasmas3 () throws FileNotFoundException {
		File buenaspelis =new File ("peliculas+3.txt");
		Scanner leerFichero = new Scanner(buenaspelis);
		
		while(leerFichero.hasNext()) {
			String peliculas=leerFichero.nextLine();
			int puntuacion=leerFichero.nextInt();
			if (puntuacion>3) {
				System.out.println(peliculas + puntuacion);
			}
		}
			return peliculasmas3 ();
	}//end peliculas3
}//end class	

