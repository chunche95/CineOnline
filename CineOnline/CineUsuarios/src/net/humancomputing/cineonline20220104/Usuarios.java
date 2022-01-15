package net.humancomputing.cineonline20220104;
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
public class Usuarios {
	public static void main(String[] args) {
		//Declaración del objeto que nos permite la entrada de datos.
		Scanner leer = new Scanner(System.in);
		//Menu de opciones
		boolean salir = false;
		int opcion;
		
		while (! salir) {
			System.out.println("\t\t Menú principal - USUARIOS.");
			System.out.println("");
			System.out.println("Seleccione una de las siguientes opciones:\n");
			System.out.println("\t 1. Mostrar peliculas con menor media ");
			System.out.println("\t 2. Mostrar peliculas con mayor media ");
			System.out.println("\t 3. Mostrar el critico que menor puntuacion media ha dado a todas las peliculas(Si hay varias mostrar solo una de ellas)");
			System.out.println("\t 4. Mostrar peliculas con +3 de media ");
			System.out.println("");
			System.out.println("\t 0. Salir del programa");
			try {
				//Solicitamos que el usuario escoga una opcion y lo recibimos desde el teclado para guardarlo en la variable correspondiente
				System.out.println("\n Introduce un numero: ");
				opcion = leer.nextInt();
				
				switch (opcion) {					
					case 1:
						System.out.println(" Esta es la opcion mostrar peliculas con menor media ");
						break;					
					case 2:
		            	System.out.println(" Esta es la opcion mostrar peliculas con mayor media ");
						break;					
		            case 3:
		            	System.out.println(" Esta es la opcion Mostrar el critico que menor puntuacion media ha dado a todas las peliculas(Si hay varias mostrar solo una de ellas) ");
						break;					
		            case 4:
		            	System.out.println(" Esta es la opcion mostrar peliculas con +3 de media ");
						break;					
		            case 0:
		            	salir = true;
		 				break;
		            default:
		            	System.out.println(" Las opciones son entre 1 y 4 ");
		            	System.out.println(" Pulse '0' para salir del programa.");
	 			} //Fin del Switch
				
			} catch (AnnotationTypeMismatchException e ) {  //Utilizamos un try y catch para que de error si no se escibe un numero y diga que debe ingresar un numero
				System.out.println("+_________________________________________+");
				System.out.println("| Debes introducir un numero entre 0 y 4! |");
				System.out.println("+_________________________________________+");
				leer.next();
			} //Fin del Catch			
		}//Fin del While
	} // Cierre del Main
} // Cierre de la clase 
