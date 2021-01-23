/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectopoo.proyecto_poo_g10_p02;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import modelo.Carta;
import modelo.Mazo;

/**
 *
 * @author andre
 */
public class JuegoController {
    @FXML
    GridPane gridC=new GridPane();
    @FXML
    VBox vb;
    
    @FXML
    private void initialize() {
        Mazo m = new Mazo();
        m.barajar();
        ArrayList<Carta> listc=m.getCartas();
        for (int i=0;i<16;i++){
            StackPane sp = new StackPane();
            Carta c = listc.get(i);
            System.out.println(c.getRutaImagen());
            int fila = i/3;
            int columna = i%3;
            ImageView imgViewFoto=new ImageView();//Creo la imagen
            InputStream input=null;
            try{
                input=App.class.getResource(c.getRutaImagen()).openStream();//creo la ruta
                Image image=new Image(input,100,100,false,false);//La asigno en objeto imagen
                imgViewFoto.setImage(image);//Establesco la imagen    
            }catch(Exception  ex){
                System.out.println("no se encuentra archivo de imagen");
            }finally{
                if (input != null) {
                try {
                    input.close();//Cierro el archivo
                } catch (IOException ex) {
                    System.out.println("no se pudo cerrar");
                }
            }
            //sp.getChildren().add(imgViewFoto);
            gridC.add(imgViewFoto, fila, columna);
            
            
            /*imgViewFoto.setOnMouseClicked(e->{
                   Label lbx = new Label("X");
                   sp.getChildren().add(lbx);
            });*/
        }
    }
    vb.getChildren().add(gridC);
        
}
}
