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

public class Service implements IEmploye<Service> {

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
    public boolean compare(Service serv) {
        return equals(serv);
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
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.libelle);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Service other = (Service) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.libelle, other.libelle)) {
            return false;
        }
        return true;
    }

    


    
     
   }


    

    
    
