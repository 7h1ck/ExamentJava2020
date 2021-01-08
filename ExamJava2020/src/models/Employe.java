/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import models.IEmploye;

/**
 *
 * @author DELL
 */
public class Employe implements IEmploye{
    
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
    public boolean compare() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    
    
}
