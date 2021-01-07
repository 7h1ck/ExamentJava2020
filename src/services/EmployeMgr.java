/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.jpa.Employe;
import dao.jpa.EmpDao;
import dao.jpa.ServiceDao;
import java.util.List;


/**
 *
 * @author DELL
 */
public class EmployeMgr implements IService<Employe>{
    
    private EmpDao dao;
    
    public EmployeMgr(EmpDao dao) {
        this.dao = dao;
    }
    
    
    

    @Override
    public Employe save(Employe obj) {
        return (Employe) this.dao.save(obj);
    }

    @Override
    public List<Employe> getAll() {
        return this.dao.findAll();
    }
    
    
}
