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
 * RECOMENDACIONES PARA EL DESARROLLO DEL APARTADO.
 * 
 * - Si lo haces a través de un menu seria más sencillo crear tu parte, por ejemplo:
 * +----------------------- MENU -----------------------+
 * + 			Seleccione una opcion:					+
 * +													+
 * +	 		1) Mostrar peliculas con menor media	+
 * + 			2) Mostrar peliculas con mayor media	+
 * + 			3) Mostrar películas con +3 estrellas.	+
 * + 			4) Mostrar criticos que han dado menor puntuacion a todas las peliculas.Dar de alta peliculas.
 * +			5) Volver al menu principal o salir.	+
 * +-------------------- FIN MENU ----------------------+
 * 
 * - Debes probar que cada opción funcione, que no entren en bucle infinito y que al darle a salir, el programa finalice sin errores.
 * 
 * - Para ver las peliculas de menor y mayor puntuacion, debes leer los ficheros de puntuacion de los criticos e ir almacenando la puntuacion de 1 al 5 que le dieron a la pelicula y luego 
 * mostrar la que tiene menos y mas nota segun sea (opcion 1 o 2 del menu)
 * 
 * - Para ver las peliculas de +3 puntos. Debes crear un sitio donde vayas leyendo la pelicula y la puntuacion, el que sea +3, lo guardas, en caso contrario, lo saltas.
 * 
 * - Para ver los criticos con menor puntuacion, debes sumar la nota del fichero de cada critico y hacer su media, la que de menos, se muestra el nombre.
 * 
 * (Adjunto ficheros para hacer las pruebas)
 * @author pauli
 *
 */
public class Usuarios {

	public static void main(String[] args) {
		//Declaración del objeto que nos permite la entrada de datos.
		Scanner leer = new Scanner(System.in);
		
		boolean salir = false;
		int opcion;
		
		while (! salir) {
			//Opciones de las peliculas que hay para escoger
			System.out.println(" 1. Opcion 1 ");
			System.out.println(" 2. Opcion 2 ");
			System.out.println(" 3. Opcion 3 ");
			System.out.println(" 4. Opcion 4 ");
			System.out.println(" 5. Opcion 5 ");
			System.out.println(" 6. Opcion 6 ");
			System.out.println(" 7. Salir ");
			
			try {
				//Solicitamos que el usuario escoga una opcion y lo recibimos desde el teclado para guardarlo en la variable correspondiente
			System.out.println(" Introduce un numero: ");
			opcion = leer.nextInt();
			
			switch (opcion) {
			
			case 1:
				System.out.println(" Esta es la opcion 1");
				break;
				
            case 2:
            	System.out.println(" Esta es la opcion 2");
				break;
				
            case 3:
            	System.out.println(" Esta es la opcion 3");
				break;
				
            case 4:
            	System.out.println(" Esta es la opcion 4");
				break;
				
             case 5:
            	 System.out.println(" Esta es la opcion 5");
				break;
				
             case 6:
            	 System.out.println(" Esta es la opcion 6");
 				break;
 				
             case 7:
            	salir = true;
 				break;
 				default:
 			System.out.println(" Las opciones son entre 1 y 7 ");
 				
 				
				
				
				
				
				
				
		} // fin Switch
		} catch (AnnotationTypeMismatchException e ) {            //Utilizamos un try y catch para que de error si no se escibe un numero y diga que debe ingresar un numero
				
		System.out.println(" Debes introducir un numero: ");
		leer.next();
		}
          System.out.println(" Fin del menu ");
    }// fin while
		System.out.println(" pelicula con mayor puntuacion y menor puntuacion ");
		System.out.println(" Digite la cantidad de peliculas a evaluar: ");
		int cantidaddepeliculas = leer.nextInt();
		int peliculaconmenorpuntuacion = 0;
		int peliculaconmayorpuntuacion = 0;
		
		for(int i = 0; i < cantidaddepeliculas; i++) {
		System.out.println(" Digite la pelicula en la posicion: " + (i + 1));
		int pelicula = leer.nextInt();
		if (i == 0) {
			peliculaconmenorpuntuacion = pelicula;
			peliculaconmayorpuntuacion = pelicula;
		} else if (pelicula < peliculaconmenorpuntuacion) { 
			peliculaconmenorpuntuacion = pelicula;
			} //else if
		if(pelicula > peliculaconmayorpuntuacion) {
		   peliculaconmayorpuntuacion = pelicula; 
			} //if
		} //for
		System.out.println(" la pelicula con menor puntuacion es: " + peliculaconmenorpuntuacion);
		System.out.println(" la pelicula con mayor puntuacion es: " + peliculaconmayorpuntuacion);
	}
}