package humancomputing.net.cineonline;
import java.io.IOException;
/**
 * @version 0.1
 * @author Kevin Alfonso Gómez Sandoval.
 */
public class Administradores throws IOException{    
		File cartelera = peliculas();
		File criticos = criticos();
}
public static File peliculas () throws IOException {
    File cartelera =new File ("cartelera.txt");
    PrintWriter SalidaP = new PrintWriter (new FileWriter (cartelera));
    /**
     * Declaramos un Scanner para poder meter por teclado tanto la cantidad de peliculas
     * los titulos de las peliculas 
     */
    Scanner leer =new Scanner (System.in);    
    // Cantidad de peliculas
    System.out.println("¿Cuantas peliculas deseas que tenga el cine?");
        int Npeliculas =leer.nextInt();
        
    // Títulos de peliculas
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
public static File criticos () throws IOException {
        
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
        }
        while (contador < NumCriticos);
            salidaC.close();
        //while
    return Criticos;	
}//end criticos


