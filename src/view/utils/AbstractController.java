/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.utils;


import dao.jpa.EmpDao;
import dao.jpa.ServiceDao;
import javafx.scene.control.Alert;

import services.ServiceMgr;
import services.EmployeMgr;

/**
 *
 * @author DELL
 */
public abstract class AbstractController {
    protected Alert alert;
    
    protected EmployeMgr empMrg = new EmployeMgr(new EmpDao());
    protected ServiceMgr servMgr = new ServiceMgr(new ServiceDao());
    
    
    protected void alertInfo(String sms){
        alert= new Alert(Alert.AlertType.INFORMATION,sms);
        alert.showAndWait();
    }
    
     protected void alertWarnig(String sms){
        Alert alert = new Alert(Alert.AlertType.WARNING,sms);
        alert.show();
    }
    
    
}
