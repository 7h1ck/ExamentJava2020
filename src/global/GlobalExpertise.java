/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package global;

import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author DELL
 */
public class GlobalExpertise extends Application {
    
    @Override
    public void start(Stage window) throws IOException {
       
        Parent root = FXMLLoader.load(getClass().getResource("../view/security/Service.fxml"));
        Scene scene = new Scene(root);
        window.setTitle("Global Expertise");
        window.getIcons().add(new Image(new File("D:\\COURS\\JAVA avancé\\Projet\\Global Expertise\\public\\img\\log.png").toURL().toString()));
        window.setScene(scene);
        window.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
