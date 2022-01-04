import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

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
			salida.println(nombre+" "+resultado);// syso en la consola sin esto no se reproduce el fichero 
			
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
