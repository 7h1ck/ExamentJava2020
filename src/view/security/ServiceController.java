/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.security;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dao.jpa.ServiceDao;
import dao.utils.IDao;
import java.awt.print.PrinterException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import models.jpa.Service;
import view.utils.AbstractController;
import view.utils.FormValidator;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class ServiceController extends AbstractController implements Initializable{

    
    @FXML
    private TableView<Service> tabService;
    @FXML
    private TableColumn<Service, String> colId;
    @FXML
    private TableColumn<Service, String> colLibelle;
    @FXML
    private AnchorPane mainPannel;
    
    
    //Custom
    
    private ObservableList<Service> services;
    @FXML
    private JFXButton btnAddService;
    @FXML
    private JFXTextField fieldService;
  
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            this.services = this.loadTable(tabService,colId,colLibelle);
        
    }    

    private void handleAddProfil(ActionEvent event) throws PrinterException {
    }

    public ObservableList<Service> loadTable(TableView<Service> tabService, TableColumn<Service, String> colId, TableColumn<Service, String> colLibelle) {
        services = FXCollections.observableArrayList(servMgr.getAll());
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colLibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        
        //System.out.print("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        //System.out.print(services.size());
        
        tabService.setItems(services);
        return services;
    }

    @FXML
    private void handleAddService(ActionEvent event) {
        this.services.add(this.servMgr.save(new Service(this.fieldService.getText())));

    }
    
    
    
        

    
}
//#49c545 vert