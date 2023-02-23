/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej31_agenda_telefonos;
import java.util.*;

/**
 *
 * @author enriq
 */
public class Agenda {
    //Creo el objeto agenda que es un HashSet de objetos Contactos
   private  HashSet <Contactos> agenda;

   public Agenda (){
        this.agenda = new HashSet <Contactos>();
   }
   //El primer método se encarga de crear un contacto con los parámetros pasados al método y añadirlo a la colección
   public  int insContac (String nom,String ape, String tele, String email){
       Contactos c = new Contactos (nom,ape,tele,email);
       boolean encontrado = true;
       if (agenda.add(c)) {
           encontrado = false;
       }
       if (encontrado){
         return -1;
       }
       else{
        return 0;     
       }
   }
   
   //Este método simplemente se encarga de recorrer todos los contactos de la agenda con sus respectivos atributos
   public void listaCont(){
       for (Contactos contacto : agenda ){
           System.out.println(contacto);
       }
   }
   
   //Recoge el nombre y el apellido pasados al método para recorrer un bucle foreach buscando coincidencias con lo introducido
   public int borraCont (String nom, String ape){
       //creo una variable booleana que esté por defecto false
       boolean encontrado = false;
       for (Contactos recorrer : agenda){
           //recorro el bucle y en el caso de que encuentre coincidencias borrará ese elemento del HashSet, posteriormente la variable booleana cambiará a true
           if (recorrer.getNom().equals(nom)  && recorrer.getApe().equals(ape)){
               agenda.remove(recorrer);
               encontrado = true;
               
           }
                      
       }
       //Si el booleano es true devolverá un 0 para decir que está correcto, si no devolverá un -1
       if (encontrado)
           return 0;
       else
           return -1;
           
   }
   //Hace lo mismo que el anterior, pide dos variables, comprueba que existe, lo modifica y lo notifica por pantalla con un 0 o -1
   public int modiCont (String tele, String telenuevo){
       boolean encontrado = false;
       for (Contactos recorrer : agenda){
           if (recorrer.getTele().matches(tele)){
               recorrer.setTele(telenuevo);
               recorrer.hashCode();
               encontrado = true;
               
           }
       }
       if (encontrado)
           return 0;
       else
           return -1;
   }
   //Lo mismo pque el anterior pero busca por nombre y apellido
   public boolean busCont (String nom, String ape){
       boolean encontrado = false;
       for (Contactos recorrer : agenda){
           if (recorrer.getNom().equals(nom) && recorrer.getApe().equals(ape)){
              System.out.println(recorrer);
              encontrado = true;
           }
       }
       if (encontrado)
           return true;
       else
           return false;
                 
   }
   
   // Lo mismo que el anterior pero busca por teléfono
   public boolean bustelCont (String tele){
       boolean encontrado = false;
       for (Contactos recorrer : agenda){
           if (recorrer.getTele().matches(tele)){
               System.out.println (recorrer);
               encontrado = true;               
           }
       }
       if (encontrado)
           return true;
       else
           return false;
   }
   

   
   
    
}
