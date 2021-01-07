/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.utils;

import com.jfoenix.controls.JFXComboBox;
import javafx.beans.binding.Bindings;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextInputControl;

/**
 *
 * @author user
 */
public class FormValidator {
    
    public  static  void isDouble(TextField field){
       field.setTextFormatter(new TextFormatter<>(t->{
                    if(t.isContentChange()){
                        if(t.getControlNewText().length()==0){
                            return t;
                        }
                        try{
                            //CONDITION DE VALIDITE
                             Double.parseDouble(t.getControlNewText());
                             return t;
                        }catch(Exception ex){
                           return null; 
                        }
                       
                    }   
                       return null;
               }
       )
       ); 
    }
    public  static  void isInteger(TextField field){
       field.setTextFormatter(new TextFormatter<>(t->{
                    if(t.isContentChange()){
                        if(t.getControlNewText().length()==0){
                            return t;
                        }
                        try{
                            //CONDITION DE VALIDITE
                             Integer.parseInt(t.getControlNewText());
                             return t;
                        }catch(Exception ex){
                           return null; 
                        }
                       
                    }   
                       return null;
               }
       )
       ); 
    }
    
    
    
    public static void disabledBtn(Button btn,TextInputControl field){
        btn.disableProperty().bind(
          Bindings.createBooleanBinding(()-> field.getText().trim().isEmpty(), 
                  field.textProperty())
       );
    }
    public static void disabledBtn(Button btn,TextInputControl field1,TextInputControl field2){
        btn.disableProperty().bind(
          Bindings.createBooleanBinding(
                  ()-> field1.getText().trim().isEmpty(), 
                  field1.textProperty()
          ).or(
              Bindings.createBooleanBinding(
                  ()-> field2.getText().trim().isEmpty(), 
                  field2.textProperty()
               )    
          )
       );
    }
    //VAlid Client
    public  static void disabledBtnCreator(Button btn,JFXComboBox cmbx,
                                    TextInputControl field1,TextInputControl field2,
                                    TextInputControl field3,TextInputControl field4){
        
        btn.disableProperty().bind(
          Bindings.createBooleanBinding(
                  ()-> cmbx.getSelectionModel().isEmpty(), 
                  cmbx.valueProperty()
          ).or(
              Bindings.createBooleanBinding(
                  ()-> field1.getText().trim().isEmpty(), 
                  field1.textProperty()
               )    
          ).or(
              Bindings.createBooleanBinding(
                  ()-> field2.getText().trim().isEmpty(), 
                  field2.textProperty()
               )    
          ).or(
              Bindings.createBooleanBinding(
                  ()-> field3.getText().trim().isEmpty(), 
                  field3.textProperty()
               )    
          ).or(
              Bindings.createBooleanBinding(
                  ()-> field4.getText().trim().isEmpty(), 
                  field4.textProperty()
               )    
          )
       );
    }
    //VAlid User AND PROD
    public static void disabledBtnCreator(Button btn,JFXComboBox cmbx,
                                    TextInputControl field1,
                                    TextInputControl field2,
                                    TextInputControl field3){
        
        btn.disableProperty().bind(
          Bindings.createBooleanBinding(
                  ()-> cmbx.getSelectionModel().isEmpty(), 
                  cmbx.valueProperty()
          ).or(
              Bindings.createBooleanBinding(
                  ()-> field1.getText().trim().isEmpty(), 
                  field1.textProperty()
               )    
          ).or(
              Bindings.createBooleanBinding(
                  ()-> field2.getText().trim().isEmpty(), 
                  field2.textProperty()
               )    
          ).or(
              Bindings.createBooleanBinding(
                  ()-> field3.getText().trim().isEmpty(), 
                  field3.textProperty()
               )    
          )
       );
    }
    
    //chose quantity Not working
    public static void disabledField(TableView tab,TextInputControl field){
        field.disableProperty().bind(
          Bindings.createBooleanBinding(()-> tab.getSelectionModel().getSelectedCells().isEmpty(), 
                  tab.selectionModelProperty())
       );
    }
    
    //chose Add liv
    //VAlid Client
    public  static void disabledBtn(Button btn,JFXComboBox cmbx){
        
        btn.disableProperty().bind(
          Bindings.createBooleanBinding(
                  ()-> cmbx.getSelectionModel().isEmpty(), 
                  cmbx.valueProperty()
          )
       );
    }
    
}
