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
import models.Employe;
import models.Service;

/**
 *
 * @author DELL
 */
public class ServiceMgr{
    
    EmployeDao daoEmp = new EmployeDao();
    ServiceDao daoServ = new ServiceDao();
    
    
    public Service ajouterServiec(Service obj) {
        return daoServ.save(obj);
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
