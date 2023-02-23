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
public class Contactos {
    private String nom;
    private String ape;
    private String tele;
    private String email;
   
    public  Contactos (String nom,String ape,String tele, String email){
        this.nom=nom;
        this.ape=ape;
        this.tele=tele;
        this.email=email;
    }

    
    public String getNom (){
        return nom;
    }
    public String getApe (){
        return ape;
    }
    public String getTele(){
        return tele;
    }
    public String getEmail(){
        return email;
    }
    public void setNom (String nom){
        this.nom = nom;
    }
    public void setApe (String ape){
        this.ape = ape;
    }
    public void setTele(String tele){
        this.tele= tele;
    }
    public void setEmail(String email){
        this.email= email;
    }
@Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.nom);
        hash = 97 * hash + Objects.hashCode(this.ape);
        hash = 97 * hash + Objects.hashCode(this.tele);
        hash = 97 * hash + Objects.hashCode(this.email);
        return hash;
    }
public boolean equals(Object obj) {
       
        if(obj instanceof Contactos){
            Contactos a = (Contactos)obj;
            return a.nom.equals(nom)&&a.ape.equals(ape)&&a.email.equals(email)&&a.tele.equals(tele);
        }else{
            return false;
        }

    
}

    @Override
    public String toString() {
        return "Contactos{" + "nom=" + nom + ", ape=" + ape + ", tele=" + tele + ", email=" + email + '}';
    }
}