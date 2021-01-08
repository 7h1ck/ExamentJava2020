/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author DELL
 */
public abstract class EntityMgrDao {
    protected EntityManagerFactory entityMgrFacto = Persistence.createEntityManagerFactory("Global_ExpertisePU");
    protected EntityManager entityManger = entityMgrFacto.createEntityManager();
}
