/**
 * Clase principal del programa.
 * 
 * CINE ONLINE.
 * 
 * Un cine online permite almacenar las películas de estreno y las opciones de M críticos de cine
 * en forma de estrellas, siendo 1 estrella la puntuación mínima y 5 la puntuación máxima. 
 * Para facilitar la tarea del jurado, se desea elaborar un programa que se encargue de gestionar toda
 * la información, contabilizando los votos emitidos y obteniendo el ganador. Así pues, dicho
 * programa consistirá en:
 *  • Deberá preguntar qué tipo de rol tenemos, si administrador, crítico de cine o usuario.
 *  • En caso de que seamos administrador:
 *      o Leer del teclado el número N de películas que tiene el cine
 *      o Leer del teclado los títulos de las N películas
 *      o Leer del teclado el número M de críticos
 *      o Leer del teclado el nombre de los M críticos
 *      o Una vez que hayamos escrito el nombre de todos los críticos, crearemos un fichero por 
 *        cada crítico y un único fichero que contenga el nombre de las películas. 
 *        Si fuese necesario, se puede crear un fichero que contenga todos los críticos.
 *  • En caso de que seamos críticos:
 *      o El sistema nos preguntará nuestro nombre y lo buscará en el sistema, donde el administrador 
 *        lo habrá escrito previamente
 *      o Si el nombre se encuentra en el fichero, le mostrará el nombre de cada película y le pedirá 
 *        la puntuación de cada una (del 1 al 5)    
 *      o Una vez hayamos terminado, guardará en el fichero correspondiente del crítico, 
 *        las calificaciones de cada película junto a su nombre. 
 *              Por ejemplo, el fichero Fernando.txt tendrá:
 *                      Máquina de Turing - 4
 *                      Scarface – 5
 *  • En caso de que seamos usuarios, nos mostrará un menú que conste de las siguientes
 *  opciones:
 *      o Mostrar película con menor media
 *      o Mostrar película con mayor media
 *      o Mostrar el crítico que menor puntuación media ha dado a todas las películas (Si hay varias, 
 *        mostrar solo una de ellas)
 *      o Mostrar las películas con más de 3 de media
 *      o Finalizar el programa
 *  • Al finalizar el programa, guardar en un fichero de texto los nombres de las películas y las
 * puntuaciones media asociadas. Para ello, se considerará que en una línea aparecerá el
 * nombre de la película, y en la siguiente línea la puntuación media.
 * 
 *
 */
package net.humancomputing.cineonline;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @version 0.4
 * @author Paulino Esteban Bermúdez Rodríguez | humancomputing.net
 */
public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        menu();
    }
    public static void menu() throws IOException {
        String n = System.getProperty("user.name");
        try {
            System.out.println("\n\n\n");
            System.out.println("\t +-------------------------------------------------+");
            System.out.println("\t |       CINE ONLINE MEK. - FUND. PROGRAMACION.    |");
            System.out.println("\t +-------------------------------------------------+");
            System.out.println("\t ");
            System.out.println("\t Bienvenido al programa de Cines Online de estrenos.");
            System.out.println("\t Empecemos...");                                
            System.out.println("\t +------------------------------+");
            System.out.println("\t |   Identificación de usuario: |");
            System.out.println("\t +------------------------------+");
            System.out.println("\t => "+n);
            System.out.println("\t Escriba el numero de su role.");
            System.out.println("\t ");
            System.out.println("\t\t  1) Jurado.");
            System.out.println("\t\t  2) Administrador.");
            System.out.println("\t\t  3) Critico.");
            System.out.println("\t\t  4) Usuario");
            System.out.println("\t ");
            System.out.println("\t\t  0) Finalizar el programa.");
            Scanner op = new Scanner(System.in);
            int seleccion = op.nextInt();
        
            switch(seleccion){
                case 1:
                    Jurado.jurado();
                    menu();
                    break;
                case 2:
                    Administrador.administrador();
                    menu();
                    break;
                case 3:
                    Critico.critico();
                    menu();
                    break;
                case 4:
                    Usuarios.usuarios();
                    menu();
                    break;
                case 0:
                    salida();
                    System.out.println(n + " hasta pronto!");                    
                    System.exit(0); 
                    break;
                default:
                    System.out.println("\n\n\n");
                    System.out.println("#######################################################################################");
                    System.out.println("Error inesperado!\n Compruebe la opcion seleccionada y vuelva a intentarlo de nuevo.\n");
                    System.out.println("\t EY! EY! YOUUU!!!");
                    System.out.println("");
                    System.out.println(n+" debes fijarte mas en las opciones disponibles.\n Volvamos de nuevo a intentarlo...");
                    System.out.println("#######################################################################################");
                    menu();
            }
        } catch (InputMismatchException ex){
            System.out.println("######################################");
            System.out.println("\t ERROR!!!");
            System.out.println("\t "+n);
            System.out.println("\t Hemos metido la pata! ");
            System.out.println("\t Debes introducir un valor numerico.");
            System.out.println("\t ");
            System.out.println("\t Volvamos a intentarlo de nuevo...");
            System.out.println("######################################");
            System.out.println("\n\n\n");
            menu();
        } catch(Exception e){
            System.out.println("######################################################################################");
            System.out.println("\t ERROR!!!");
            System.out.println("\t ");
            System.out.println("\t Nooo! ocurrio un error inesperado del sistema. Tienes más detalles a continuacion. ");
            System.out.println("");
            System.out.println("\t"+ n + " aqui tienes mas info.");
            System.out.println("\t DESCRIPCION DEL ERROR:");
            System.out.println(e);
            System.out.println("######################################################################################");
            System.out.println("\n\n\n");
            menu();
        } finally {
            salida();    
            System.exit(0);            
        } 
    }
    public static void salida() {
        System.out.println("+----------------------------------------------------+");
        System.out.println("| Fin del programa.                                  |");
        System.out.println("| Gracias por evaluar CINE ONLINE MEK.               |");
        System.out.println("|                                                    |");
        System.out.println("| @universidad: UCLM                                 |");
        System.out.println("| @subject: Fundamentos de programacion I.           |");
        System.out.println("| @version: 22.01.19.beta                            |");
        System.out.println("| @authores: Paulino Esteban Bermudez R.             |");
        System.out.println("|      Kevin Alfonso Gomez S.                        |");
        System.out.println("|                                                    |");
        System.out.println("+----------------------------------------------------+");
    }
}
