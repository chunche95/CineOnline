package net.humancomputing.cineonline20220104;
import java.io.*;
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
 * @author Kevin Alfonso Gómez Sandoval.
 */

/**
 * RECOMENDACIONES PARA EL DESARROLLO DEL APARTADO.
 * - Si lo haces a través de un menu seria más sencillo crear tu parte, por ejemplo:
 * +----------------------- MENU -----------------------+
 * + 			Seleccione una opcion:					+
 * +													+
 * +	 		1) Dar de alta peliculas.				+
 * + 			2) Dar de alta critico.					+
 * +-------------------- FIN MENU ----------------------+
 * 
 * - Para poder controlar los registros que se están guardando en los ficheros de cada tarea, ya sea, peliculas o criticos, lo mejor, personalmente,
 * sería llevandolo de manera recursiva que pregunte cada vez que realice un registro.
 * 
 * - Para que no te haga el salto de linea en blanco en los ficheros, es mejor usar otro tipo de bucles, el While o el For. Sino siempre te saldrá el blanco al principio. - CARTELERA.txt
 * 
 * - Otra opcion, más fácil es llevando un bucle+contador, que por cada registro que haga, vaya restando del total que se quiere registrar. - CRITICOS (Se te ha olvidado)
 * 
 * 	(Así controlas y evitar el bucle infinito que tienes ahora.)
 * 
 * - Es buena practica, indicar cuando se termina el programa. Dejando un mensaje de 'Fin del programa' por ejemplo, o un mensaje + volver a mostrar de nuevo el menu principal. 
 * 
 * (Adjunto ficheros para hacer las pruebas)
 * @author pauli
 *
 */
public class Administradores {    
    public static void main(String[] args) throws IOException {
        File cartelera = peliculas();
        File criticos = criticos();
        System.out.println("Fin del programa.");
        
		
    }// end main
    public static File peliculas() throws IOException {
        File cartelera =new File ("cartelera.txt");
        PrintWriter SalidaP = new PrintWriter (new FileWriter (cartelera));
        /*declaramos un Scanner para poder meter por teclado tanto la cantidad de peliculas
         * los titulos de las peliculas 
         */
        Scanner leer =new Scanner (System.in);

        //cantidad de peliculas
        System.out.println("¿Cuantas peliculas deseas que tenga el cine?");
                int Npeliculas =leer.nextInt();

        //titulos de peliculas
        System.out.println("¿Cuales son los titulos de las peliculas?");
                int contador=0;
        do {
                String NombrePeliculas =leer.nextLine();
                SalidaP.println(NombrePeliculas);
                contador++;
        }//do
        while (contador <= Npeliculas);
                SalidaP.close();

        return cartelera;		
    }//end peliculas
    public static File criticos() throws IOException {

        File Criticos = new File ("criticos.txt");
        PrintWriter salidaC = new PrintWriter (new FileWriter(Criticos));

        Scanner leer =new Scanner (System.in);

        //cantidad de Criticos
        System.out.println("¿Cuantos criticos hay en el cine?");
                int NumCriticos =leer.nextInt();

        //Nombre de los criticos
        System.out.println("¿Cuales son los nombres de los criticos?");
        int contador=0;
                do {
                        String NombresCriticos =leer.next();
                        File CadaCritico = new File (NombresCriticos);
                        salidaC.println(CadaCritico);
                        contador++;
                }
                while (contador <= NumCriticos);
                        salidaC.close();
                //while
        return Criticos;	
    }//end criticos
}
