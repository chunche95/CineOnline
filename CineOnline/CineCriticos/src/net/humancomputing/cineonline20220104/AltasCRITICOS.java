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
 * 		+ Pedir puntuación c/u peliculas del 1-5
 * 		+ Guardar puntuación c/u peliculas.
 *
 * @version 0.1
 * @author Luis Miguel Barreiro Cabello.
 */

/**
 * RECOMENDACIONES PARA EL DESARROLLO DEL APARTADO.
 * 
 * - Debes preguntar el nombre del critico, para que se escriba.
 * - Debes crear un método o algo que te busque la existencia del nombre del critico que se escribe por teclado.
 * 
 * - El fichero no puede llamarse Juan.txt, puede haber varias Juanes entre los criticos y el sistema fallaria. 
 * 
 * - Para el control de errores, debes evitar que escriba una letra distinta a 's', si escribo 'S', sale pero no me indica nada el programa.
 * si escribo '23' o 'f', no me dice que es invalido.
 * 
 * - Sería una buena practica ir dejando algún comentario más, por ejemplo para el tema de los ficheros, de que trata cada uno.
 * - También, podrías indicar la finalización del programa con un mensaje, o un mensaje y volviendo al menu principal.	  
 *  
 * (Adjunto ficheros para hacer las pruebas)
 * @author pauli
 *
 */
public class AltasCRITICOS {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		File MiFichero;
		PrintWriter salida;
		String Titulo="Juan.txt";
		MiFichero=new File(Titulo);	
		salida=new PrintWriter(new FileWriter(MiFichero));
		boolean Escribirmas=true;
		do {
			System.out.println("Introduce nombre de pelicula ");
			int resultado=generarNumero();
			
			
			String nombre=sc.next();
			salida.println(nombre+" - "+resultado);// syso en la consola sin esto no se reproduce el fichero 
			
			System.out.println("Introduce mas nombres s/n");
			if(sc.next().equals("s")){
				Escribirmas=true;
			}
			else {
				Escribirmas=false;
			}
		} while (Escribirmas);
	
		salida.close();
		// Este array almacenara mas adelante los alaias y las puntuaciones por separado
		
		
		sc.close();
		
			
			
				
			}
			
			
		
		
	
	
	public static int generarNumero() {
		int numero;
		numero= (int)(Math.random()*5-1);
		return numero;
	}
		
}