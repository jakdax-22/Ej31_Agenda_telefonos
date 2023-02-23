/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej31_agenda_telefonos;
import java.util.*;
import java.util.regex.Pattern;
/**
 *
 * @author enriq
 */
public class GestionAge {
        public static void main(String[] args) {
            char respuesta = ' ';
            Scanner teclado = new Scanner (System.in);
            Agenda a = new Agenda();
            String patronemail = "[^@][a-zA-z0-9]+@[a-zA-z0-9]+[^@]\\.[a-zA-z]{2,3}";
            String patrontelefono = "[1-9][0-9]{8}";
            do{
                //Hago el menú normal, dentro de un do-while para salir en el caso necesario
                System.out.println("1. Crear contacto");
                System.out.println ("2. Modificar contacto por teléfono");
                System.out.println("3. Buscar un contacto por nombre y apellidos");
                System.out.println("4. Eliminar un contacto");
                System.out.println("5. Mostrar información de todos los contactos");
                System.out.println("6. Mostrar información de un contacto dado por teléfono");
                System.out.println ("7. Salir");
                System.out.println ("¿Qué opción quieres realizar?");
                int opcion = teclado.nextInt();
                teclado.nextLine();
                String nombre,email,apellido,telefono;
                //Según la opción elegida se hace una cosa u otra
                switch (opcion){
                    case 1:
                        //Recojo los datos por teclado
                        System.out.print("Dime el nombre del contacto ");
                        nombre = teclado.nextLine();
                        System.out.print("\nDime el apellido del contacto ");
                        apellido = teclado.nextLine();
                        System.out.print("\nDime el email del contacto ");
                        email = teclado.nextLine();
                        //Compruebo que el email tenga una @ y el dominio, siendo .com o .es válidos
                        if (Pattern.matches(patronemail, email)){
                            System.out.println ("Email válido");
                        }
                        //Si no se cumple lo anterior de vuelta al menú principal
                        else{
                            System.out.println("Email incorrecto, vuelta al menú principal");
                            break;
                        }                        
                        System.out.print ("\nDime el teléfono del contacto ");
                        telefono = teclado.nextLine();
                        System.out.println();
                        // Paso el int a String para comprobar que tiene 9 dígitos, si no dará error y se volverá al menú principal
                        if (Pattern.matches(patrontelefono,telefono)){
                            System.out.println("Teléfono correcto");
                        }
                        else{
                            System.out.println("Formato no soportado, vuelta al menú principal");
                            break;
                        }
                        //Si todo se ha cumplido llamo al método agenda para introducir los datos en el Hash Set
                        System.out.println(a.insContac(nombre,apellido,telefono,email));
                    break;
                    case 2:
                        System.out.println("Dime el número de teléfono a actualizar");
                        telefono = teclado.nextLine();
                        System.out.println("Dime el número de teléfono nuevo");
                        String telefononuevo = teclado.nextLine();
                        if (Pattern.matches(patrontelefono, telefononuevo)){
                            System.out.println("Teléfono correcto");
                        }
                        else{
                            System.out.println("Formato no soportado, vuelta al menú principal");
                            break;
                        }                        
                        System.out.println(a.modiCont(telefono,telefononuevo));                      
                    break;
                    case 3:
                        //Pido el nombre y el apellido a buscar 
                        System.out.println("Dime el nombre del contacto a buscar");
                        nombre = teclado.nextLine();
                        System.out.println("Dime el apellido del contacto a buscar");
                        apellido = teclado.nextLine();        
                        //Llamo al método para buscar el contacto con los argumentos introducidos por teclado
                        System.out.println(a.busCont(nombre,apellido));                   
                    break;
                    case 4:
                        //Pido el nombre y el apellido por pantalla
                        System.out.println("Dime el nombre del contacto a borrar");
                        nombre = teclado.nextLine();
                        System.out.println("Dime el apellido del contacto a borrar");
                        apellido = teclado.nextLine();  
                        //Lo mismo que el anterior pero borrando
                        System.out.println(a.borraCont(nombre,apellido));
                    break;
                    case 5:
                        //Llamo al método de Agenda encargado de recorrer todo en un foreach
                        a.listaCont();
                    break;
                    case 6:
                        //Pido el número por pantalla 
                        System.out.println("Dime el número por el que vamos a buscar");
                        telefono = teclado.nextLine();
                        teclado.nextLine();
                        //Lo mismo que las anteriores, pero buscando por teléfono
                        System.out.println(a.bustelCont(telefono));
                    break;
                    case 7:
                    
                    break;
                }
                //Si la opción ha sido salir me cargo el do-while directamente para que no salga la pregunta
                if (opcion == 7){
                    break;
                }
                //Pido una respuesta por teclado, en el caso de que sea S o s se pasa a mayúscula y se comprueba en el while, si es S el bucle vuelve a hacer una iteración
                System.out.print ("Quieres seguir con el programa? S/N ");
                String respuestastring = teclado.nextLine();
                respuesta = respuestastring.toUpperCase().charAt(0);
            }
            while (respuesta == 'S');
    }
}
