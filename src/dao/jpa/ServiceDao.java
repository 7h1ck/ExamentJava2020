/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.jpa;

import dao.utils.EntityMgrDao;
import dao.utils.IDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.jpa.Service;

/**
 *
 * @author DELL
 */
public class ServiceDao extends EntityMgrDao implements IDao<Service>{
    
    @Override
    public Service save(Service serv) {
        this.entityManger.getTransaction().begin();
        serv = this.entityManger.merge(serv);
        this.entityManger.getTransaction().commit();
        return serv;
    }

    @Override
    public List<Service> findAll() {
        return this.entityManger.createQuery("SELECT p from Service p", Service.class).getResultList();
    }

    @Override
    public Service find(int id) {
        return this.entityManger.find(Service.class, id);
    }

    @Override
    public List<Service> findBy(int id) {
        //this.entityManger.createQuery("select p from Personne p where p.nom='nom2'").getSingleResult();
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean remove(Service profile) {
        this.entityManger.getTransaction().begin();
        this.entityManger.remove(profile);
        this.entityManger.getTransaction().commit();
        return true;
    }
    
}
