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

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class NombreController {
    @FXML
    Button cancelarbutton;
    @FXML
    Button obbutton;
    
    @FXML
    private void regresarM() throws IOException{        
        App.setRoot("Menu_Principal");
    }
    
    @FXML
    private void okJuego() throws IOException{
        App.setRoot("Juego");
    }
    
}
