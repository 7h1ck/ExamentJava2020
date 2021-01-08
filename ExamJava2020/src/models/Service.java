/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import models.IEmploye;


/**
 *
 * @author DELL
 */

public class Service implements IEmploye {

    private int id;
    private String libelle;
    
    public Service(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Service(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean compare() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String affiche() {
        return "Service{" + "id=" + id + ", libelle=" + libelle + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return libelle;
    }

    @Override
    public int hashCode() {
       int hash = 1;
       hash = 31 * hash + (libelle == null ? 0 : libelle.hashCode());
       return hash;
   }


    @Override
     public boolean equals(Object obj) {
     
       if (this == obj)
        return true;
     if (obj == null)
        return false;
     if (getClass() != obj.getClass())
        return false;
       Service other = (Service) obj;
       if (this.id!=other.getId())
        return false;
      if (this.libelle.compareToIgnoreCase(other.getLibelle())!=0)
        return false;
     return true;
     
   }


    

    
    
}
