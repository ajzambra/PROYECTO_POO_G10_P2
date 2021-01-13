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

public class MenuPrincipalController {
    @FXML
    private void cambiarConfiguracion() throws IOException{
        App.setRoot("Configuraciones");
    }
    
    @FXML
    private void cambiarReporte() throws IOException{
        App.setRoot("Reporte");
    }
    
    private void cambiarJuego() throws IOException{
        App.setRoot("Nombre");
    }
}
