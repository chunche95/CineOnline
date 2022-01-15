package net.humancomputing.cineonline20220104;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
/** 
 * ADMINISTRADORES DE CINES MKE.
 * 
 * Tareas de administrador:
 * 
 * + Dar de alta peliculas en la cartelera
 * +---> Nombres de las peliculas.
 * +---> Guardar peliculas.
 * 
 * + Dar de alta criticos de cine
 * +---> Nombres de los criticos de cine.
 * +---> Crear ficha critico.
 *
 * @version 0.1
 * @author Kevin Alfonso G�mez Sandoval.
 */

/**
 * RECOMENDACIONES PARA EL DESARROLLO DEL APARTADO.
 * - Si lo haces a trav�s de un menu seria m�s sencillo crear tu parte, por ejemplo:
 * +----------------------- MENU -----------------------+
 * + 			Seleccione una opcion:					+
 * +													+
 * +	 		1) Dar de alta peliculas.				+
 * + 			2) Dar de alta critico.					+
 * +-------------------- FIN MENU ----------------------+
 * 
 * - Para poder controlar los registros que se est�n guardando en los ficheros de cada tarea, ya sea, peliculas o criticos, lo mejor, personalmente,
 * ser�a llevandolo de manera recursiva que pregunte cada vez que realice un registro.
 * 
 * - Para que no te haga el salto de linea en blanco en los ficheros, es mejor usar otro tipo de bucles, el While o el For. Sino siempre te saldr� el blanco al principio. - CARTELERA.txt
 * 
 * - Otra opcion, m�s f�cil es llevando un bucle+contador, que por cada registro que haga, vaya restando del total que se quiere registrar. - CRITICOS (Se te ha olvidado)
 * 
 * 	(As� controlas y evitar el bucle infinito que tienes ahora.)
 * 
 * - Es buena practica, indicar cuando se termina el programa. Dejando un mensaje de 'Fin del programa' por ejemplo, o un mensaje + volver a mostrar de nuevo el menu principal. 
 * 
 * (Adjunto ficheros para hacer las pruebas)
 * @author pauli
 *
 */
public class Administradores {    
        public static void main(String[] args) throws IOException {
		Scanner leer = new Scanner(System.in);
		System.out.println("Bienvenido");
		int opcion;
		boolean menu = true;
		/* realizamos un while para que el las opciones del menu aparezcan cada vez
		 * que termino de realizar una tarea y dar la opcion si deseo realizar otra
		 * dejamos la opcion salir la cual daria final al bucle while
		 */
		while (menu){
		//Creamos un Menu Principal para consultar al usuario que desea hacer
			System.out.println("¿Que le gustaria hacer?");
			System.out.println("1) Dar de alta una pelicula\n2) Dar de alta un critico\n3) salir");
		/* realizamos un try catch para que cuando el administrador introduzca un dato
		 * que no es valido este le mande un mensaje y le mande de vuelta a escoger una opcion
		 */
			try {
				System.out.println("introduzca el numero de la opción que desea realizar");
				opcion = leer.nextInt();
		/* Ahora crearemos un switch case para asi distiguir cada opcion
		 * y ademas podemos redirigir al administrador a la tarea que desea realizar
		 */
				switch (opcion) {
					case 1:
						File cartelera=peliculas();
						System.out.println();
						break;
					case 2:
						File criticos =criticos();
						System.out.println();
						break;
					case 3:
						menu = false;
						break;
				default:
					System.out.println("Sentimos las molestias, las unicas opciones validas son 1, 2 o 3\n");
				}// end switch
			}catch (InputMismatchException e) {
				System.out.println("Sentimos las molestias, este dato no corresponde a ninguna opcion.");
				// colocomos aqui un leer.next, ya que si no lo hacemos nos provoca un bucle infinito
				leer.next();
			}// end catch
		}// end while
                System.out.println("");
                System.out.println("Gracias por usar el Administrador de Cines MKE");
		System.out.println("Esperamos verte pronto!");
                System.out.println("");
	}//main
	
	public static File peliculas () throws IOException {
		// creamos el fichero
		File cartelera =new File ("cartelera.txt");
		PrintWriter SalidaP = new PrintWriter (new FileWriter (cartelera));
		boolean maspelis;
		Scanner leer =new Scanner (System.in);
		
		SalidaP.println("Nombre de las peliculas en la cartelera\n");
		/*utiliazamos un bucle do, while para llevar a cabo la escritura dentro de
		 * nuestro fichero cartelera de las peliculas que queremos agregar 
		 */
		do {
			//
			System.out.println("Nombre de la pelicula que desea dar de alta");
			String pelicula =leer.nextLine();
			SalidaP.println(pelicula);
			/*para llevar un mejor control pregunatremos al administrador cada vez
			 * que desee agregar una pelicula 
			 */
			System.out.println("¿Quiere agregar otra pelicula?(s/n)");
			maspelis=leer.nextLine().equals("s"); 
                        maspelis=leer.nextLine().equals("S");
			
		}//do
			while (maspelis);
			SalidaP.close();
			System.out.println("Gracias por agregar nuevas peliculas, volvemos al menu");	
	return cartelera;		
	}//end peliculas
	
	public static File criticos () throws IOException {
		//creamos el fichero criticos
		File Criticos = new File ("criticos.txt");
		PrintWriter salidaC = new PrintWriter (new FileWriter(Criticos));
		Scanner leer =new Scanner (System.in);
		boolean mascriticos;
		
		salidaC.println("nombre de los criticos\n");
		/*utiliazamos un bucle do, while para llevar a cabo la escritura dentro de
		 * nuestro fichero criticos de  los criticos que queremos introducir
		 */ 
			do {
				System.out.println("Nombre del nuevo critico");
				String Critico =leer.nextLine();
				//creamos un fichero para cada critico que se va agregando
				File CadaCritico = new File (Critico);
				salidaC.println(CadaCritico);
				System.out.println("¿Quiere agregar otro critico?");
				mascriticos=leer.nextLine().equals("s");	
			}
			while (mascriticos);
				salidaC.close();
				System.out.println("Gracias por agregar nuevos criticos, volvemos al menu");
			//while
	return Criticos;	
	}//end criticos
}
