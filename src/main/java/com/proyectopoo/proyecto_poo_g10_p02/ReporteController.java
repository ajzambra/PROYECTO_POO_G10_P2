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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import modelo.Juego;

public class ReporteController {
    @FXML
    private ListView listaDatos;
    
    @FXML
    private void regresarM() throws IOException{
        App.setRoot("Menu_Principal");
    }
    
    public void Reporte(){
        String ruta="src/recursos/reporte.bin";
        List<Juego> partidas=null;
        
        try(ObjectInputStream oi=new ObjectInputStream(new FileInputStream(new File(ruta)))){
            partidas = (List<Juego>) oi.readObject();
            
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        } 
        
        
    }
    
    
}
