/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectopoo.proyecto_poo_g10_p02;

/**
 *
 * @author andre
 */

import java.awt.TextField;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import modelo.Configuracion;

public class ConfiguracionController {
    private ObjectOutputStream out;
    private FileOutputStream file;
    
    @FXML
    private TextField cantRivales;
    @FXML
    private CheckBox mostarCartas;
    @FXML
    private void regresarM() throws IOException{        
        App.setRoot("Menu_Principal");
        iniciarConfiguracion();
    }
    
    private void iniciarConfiguracion(){
        if(cantRivales.getText()!=null){
            Configuracion c=null;
            if(mostarCartas.isSelected()){
                c=new Configuracion(true,Integer.parseInt(cantRivales.getText()));
            }else{
                c=new Configuracion(false,Integer.parseInt(cantRivales.getText()));
            }
            ObjectOutputStream objo = null;
            try{
                objo = new ObjectOutputStream(new FileOutputStream(new File("src/recursos/Configuracion.bin")));
                objo.writeObject(c);

            }catch(FileNotFoundException ex){
                System.out.println(ex.getMessage());
            }catch(IOException | NullPointerException ex){
                System.out.println(ex.getMessage());
            }finally{
                try{
                    objo.close();
                }catch(IOException e){
                    System.err.println(ex.getMessage());
                }
            }
        } 
    }

}
