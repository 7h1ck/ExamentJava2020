/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.EmployeDao;
import dao.ServiceDao;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import models.Employe;
import models.Service;

/**
 *
 * @author DELL
 */
public class ServiceMgr{
    
    EmployeDao daoEmp = new EmployeDao();
    ServiceDao daoServ = new ServiceDao();
    Alert a = new Alert(Alert.AlertType.INFORMATION,"Le libbelle doit être unique");

    
    public Service ajouterServiec(Service serv) {
        for(Service service : this.listerServiec()){
            System.out.print("jjjjjjjjjjjjj");
            if(service.getLibelle().compareTo(serv.getLibelle())==0){
                a.showAndWait();
                return null;
            }
                
        }
        return daoServ.save(serv);
    }

    public List<Service> listerServiec() {
        return daoServ.findAll();
    }
    
    public void affecterEmploye(Employe emp,Service serv) {
        emp.setIdService(serv.getId());
        daoEmp.save(emp);
    }
    public List<Employe> listerEmployeServiec(Service serv) {
        return daoEmp.findBy(serv.getId());
    }
    
    public List<Employe> listerEmployeGoingRetrait() {
        return daoEmp.findAllRetrait();
    }
    
    public List<Employe> listerAllEmploye() {
        return daoEmp.findAll();
    }

    
}
