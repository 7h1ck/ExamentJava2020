/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.security;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import models.jpa.Employe;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class ListUsersController implements Initializable {

    @FXML
    private AnchorPane mainContainer;
    @FXML
    private TableView<Employe> tabUser;
    @FXML
    private TableColumn<Employe, String> colFullName;
    @FXML
    private TableColumn<Employe, String> colService;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
