/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;
import models.Employe;
import models.Service;
import services.ServiceMgr;



/**
 * FXML Controller class
 *
 * @author DELL
 */
public class AddEmployeController implements Initializable {
    
    @FXML
    private TextField fieldFullName;
    
    @FXML
    private Button btnSave;
    @FXML
    private AnchorPane mainContainer;
    @FXML
    private JFXComboBox<Service> cmbService;
    @FXML
    private DatePicker fieldDate;
    
    Employe employe;
    ServiceMgr servMgr = new ServiceMgr();
    ObservableList<Service> listService;
    Service selectedService;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cmbService.setPromptText("Choisissez une service");
        listService = FXCollections.observableArrayList(servMgr.listerServiec());
        cmbService.setItems(listService);
       
        
    }    

    


    @FXML
    private void handleSave(ActionEvent event) throws IOException {
        
        
        
        Employe emp = new Employe(fieldFullName.getText(),fieldDate.getValue());
            
        servMgr.affecterEmploye(emp, selectedService);
        
        Alert a = new Alert(Alert.AlertType.INFORMATION,"L'utilisater est Enregistré avec succès");
        a.showAndWait();
        loadView("ListEmploye", mainContainer);
    }
   
   


    @FXML
    private void handleServiceChanged(ActionEvent event) {
        selectedService = cmbService.getValue();
    }
    
    public void loadView(String viewName,AnchorPane anchorContent) throws IOException{
            AnchorPane viewLoader = FXMLLoader.load(getClass().getResource("/view/"+viewName+".fxml"));
                anchorContent.getChildren().clear();
                anchorContent.getChildren().add(viewLoader);
    }
}
