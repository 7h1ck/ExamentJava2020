/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.jpa;

import dao.utils.EntityMgrDao;
import dao.utils.IDao;
import java.util.List;
import javax.persistence.TypedQuery;
import models.jpa.Employe;

/**
 *
 * @author DELL
 */

public class EmpDao extends EntityMgrDao implements IDao<Employe>{
    
    @Override
    public Employe save(Employe personne) {
        this.entityManger.getTransaction().begin();
        personne = this.entityManger.merge(personne);
        this.entityManger.getTransaction().commit();
        return personne;
    }

    @Override
    public List<Employe> findAll() {
        return this.entityManger.createQuery("SELECT p from Employe p", Employe.class).getResultList();
    }

    @Override
    public Employe find(int id) {
        return this.entityManger.find(Employe.class, id);
    }

    @Override
    public List<Employe> findBy(int id) {
        //this.entityManger.createQuery("select p from Personne p where p.nom='nom2'").getSingleResult();
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean remove(Employe personne) {
        this.entityManger.getTransaction().begin();
        this.entityManger.remove(personne);
        this.entityManger.getTransaction().commit();
        return true;
    }
    /*
    public User getConnexion(String login, String pwd) {
        TypedQuery<User> usr =  this.entityManger.createQuery("select u from User u where u.login=:log AND u.password=:pwd", User.class)
                .setParameter("log", login)
                .setParameter("pwd", pwd);
        return (usr.getResultList().isEmpty()) ? null : usr.getSingleResult();
    }
    //Not sure
    public List<Client> findAllClient() {
        
        return this.entityManger.createQuery("SELECT c from Client c", Client.class).getResultList();
    }*/
}