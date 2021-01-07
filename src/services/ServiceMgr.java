/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import dao.jpa.ServiceDao;
import java.util.List;
import models.jpa.Service;

/**
 *
 * @author DELL
 */
public class ServiceMgr implements IService<Service>{
    
    private ServiceDao daoService;
    
    public ServiceMgr(ServiceDao dao) {
        this.daoService = dao;
    }
    
    
  
    @Override
    public Service save(Service prod) {
        return daoService.save(prod);
    }


    @Override
    public List<Service> getAll() {
        return daoService.findAll();
    }

    public boolean remove(Service p) {
        daoService.remove(p);
        return true;
    }
    
    
    
    
}
