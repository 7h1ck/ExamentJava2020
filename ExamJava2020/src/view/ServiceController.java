/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dao.utils.IDao;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import models.Service;
import services.ServiceMgr;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class ServiceController implements Initializable{

    
    @FXML
    private TableView<Service> tabService;
    @FXML
    private TableColumn<Service, String> colId;
    @FXML
    private TableColumn<Service, String> colLibelle;
    @FXML
    private AnchorPane mainPannel;
    
    
    //Custom
    ServiceMgr servMgr = new ServiceMgr();
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
            this.services = this.loadTable();
        
    }    

    

    public ObservableList<Service> loadTable() {
        services = FXCollections.observableArrayList(servMgr.listerServiec());
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colLibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        
        tabService.setItems(services);
        return services;
    }

    @FXML
    private void handleAddService(ActionEvent event) {
        Service ser = this.servMgr.ajouterServiec(new Service(this.fieldService.getText()));
        if(ser!=null)
        this.services.add(ser);

    }

    @FXML
    private void handleAffecter(ActionEvent event) throws IOException {
        this.loadView("AddEmploye", mainPannel);
    }
    
    public void loadView(String viewName,AnchorPane anchorContent) throws IOException{
            AnchorPane viewLoader = FXMLLoader.load(getClass().getResource("/view/"+viewName+".fxml"));
                anchorContent.getChildren().clear();
                anchorContent.getChildren().add(viewLoader);
    }

    @FXML
    private void handleListEmp(ActionEvent event) throws IOException {
        this.loadView("ListEmploye", mainPannel);
    }
    
        

    
}
//#49c545 vert