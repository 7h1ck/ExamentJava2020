/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import models.IEmploye;

/**
 *
 * @author DELL
 */
public class Employe implements IEmploye<Employe>{
    
    private int id;
    private String fullName;
    private Date dateEmbauche;  
    private int idService;

    public Employe(String fullName, LocalDate date) {
        this.fullName = fullName;
        this.dateEmbauche = Date.valueOf(date);
    }

    public Employe(int id, String fullName, Date date) {
        this.id = id;
        this.fullName = fullName;
        this.dateEmbauche = date;
    }

    @Override
    public boolean compare(Employe emp) {
        return equals(emp);
    }

    @Override
    public String affiche() {
        return "Employe{" + "id=" + id + ", fullName=" + fullName + ", dateEmbauche=" + dateEmbauche + ", idService=" + idService + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    @Override
    public String toString() {
        return "Employe{" + "id=" + id + ", fullName=" + fullName + ", dateEmbauche=" + dateEmbauche + ", idService=" + idService + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.fullName);
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
        final Employe other = (Employe) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
