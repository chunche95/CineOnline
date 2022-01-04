package humancomputing.net.cineonline;
import java.lang.annotation.AnnotationTypeMismatchException;
import java.util.Scanner;

public class Usuario {
    menu();
}   
public static void menu() { 	
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