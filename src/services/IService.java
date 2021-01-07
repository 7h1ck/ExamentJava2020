/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.utils.IDao;
import java.util.List;
import javafx.collections.ObservableList;


/**
 *
 * @author DELL
 */
public interface IService <T>{
    public T save(T obj);
    public List<T> getAll();
}
