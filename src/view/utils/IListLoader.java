/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.utils;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author DELL
 */
public interface IListLoader<T>{
    
    public ObservableList<T> loadTable(ObservableList<T> list,TableView<T> tabView, TableColumn<T, String> colId, TableColumn<T, String> colLibelle);
}
