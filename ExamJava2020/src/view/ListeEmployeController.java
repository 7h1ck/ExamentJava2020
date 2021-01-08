/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import models.Employe;
import models.Service;
import services.ServiceMgr;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class ListeEmployeController implements Initializable {

    @FXML
    private AnchorPane mainContainer;
    @FXML
    private JFXComboBox<Service> cmbService;
    @FXML
    private TableView<Employe> tabEmp;
    @FXML
    private TableColumn<Employe, String> colId;
    @FXML
    private TableColumn<Employe, String> colFName;
    @FXML
    private TableColumn<Employe, String> colDate;

    /**
     * Initializes the controller class.
     */
    
    //Cust
    Service selectedService;
    
    ServiceMgr servMgr = new ServiceMgr();
    ObservableList<Service> listService;
    ObservableList<Employe> employes;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cmbService.setPromptText("Selectionnez une service");
        listService = FXCollections.observableArrayList(servMgr.listerServiec());
        cmbService.setItems(listService);   
        
        employes = loadTable();
        
    }
    
    @FXML
    private void handleServiceChanged(ActionEvent event) {
        employes = FXCollections.observableArrayList(servMgr.listerEmployeServiec(cmbService.getValue()));
        tabEmp.setItems(employes);
    }

    
    
    public ObservableList<Employe> loadTable() {
        employes = FXCollections.observableArrayList(servMgr.listerAllEmploye());
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("dateEmbauche"));
        tabEmp.setItems(employes);
        return employes;
    }

    @FXML
    private void handleListRetraités(ActionEvent event) {
        employes = FXCollections.observableArrayList(servMgr.listerEmployeGoingRetrait());
        tabEmp.setItems(employes);
    }
}
