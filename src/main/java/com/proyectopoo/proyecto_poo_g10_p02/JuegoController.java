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
import javafx.geometry.Pos;
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
    ImageView cartaJuego;
    @FXML
    VBox vbA = new VBox(20);
    @FXML
    VBox vbO;
    @FXML
    ImageView ImagenAlineacion;
    @FXML
    GridPane gridO=new GridPane();
    
    
    @FXML
    private void initialize() {
        Mazo m = new Mazo();
        m.barajar();
        ArrayList<Carta> listc=m.getCartas();
        vb.setAlignment(Pos.CENTER);
        for (int i=0;i<16;i++){
            StackPane sp = new StackPane();
            Carta c = listc.get(i);
            int fila = i/4;
            int columna = i%4;
            Image imag =mostrarC(c);
            ImageView imgViewFoto=new ImageView();//Creo la imagen
            imgViewFoto.setImage(imag);//Establesco la imagen    
            sp.getChildren().add(imgViewFoto);
            imgViewFoto.setOnMouseClicked(e->{
                   Label lbx = new Label("X");
                   sp.getChildren().add(lbx);
            });
            gridC.add(sp, columna, fila);
            
            
    }
    vb.getChildren().add(gridC);
    CambiarCarta ci=new CambiarCarta();
    ci.setDaemon(true);
    ci.start();
     // PRIMERO REQUIERO QUE ELIJA ALGUNA DE LAS 4 POSIBLES FORMAS DE GANAR DE MANERA ALEATORIA
     // LUEGO CREAR CADA UNA DE LAS 4 IMAGENES
     // LUEGO SEGUN LA OPCION SELECCIONAR LA IMAGEN CORRESPONDIENTE
     
     //
     
     // NUMERO ALEATORIO ENTRE 1 Y 4
      //int numeroaleatorio = (int) (4*Math.random()+1);
      
     //NECESITO MOSTRAR LA IMAGEN AL INICIALIZAR EN EL VBA DE LA IZQUIERDA
     StackPane spAlineacion= new StackPane();
     Image prueba = mostrarAlineacion();
     ImageView imgViewAlineacion= new ImageView();
     imgViewAlineacion.setImage(prueba);
     spAlineacion.getChildren().add(imgViewAlineacion);
     vbA.getChildren().add(spAlineacion);
         
          
          
    
    
    
    
        
}
    private Image mostrarC(Carta c){
            Image image=null;
            InputStream input=null;
            try{
                input=App.class.getResource(c.getRutaImagen()).openStream();//creo la ruta
                image=new Image(input,100,100,false,false);//La asigno en objeto imagen
                
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
        }
        return image;
    }
    //int numeroaleatorio = (int) (4*Math.random()+1);
    private Image mostrarAlineacion(){
        
        Image imagenAlineacion=null;
        InputStream inputAlineacion=null;
        try{
            inputAlineacion=App.class.getResource("filesDentro/filasalineacionganadora.png").openStream();
            imagenAlineacion= new Image(inputAlineacion,20,20,false,false);
        }
        catch(Exception ex){
            System.out.println("NO SE ENCUENTRA EL ARCHIVO");
        }
        return imagenAlineacion;
            
        
           
    }
    
    private class CambiarCarta extends Thread{
        public void run(){
            Image img;
            Mazo m = new Mazo();
            m.barajar();
            ArrayList<Carta> listc=m.getCartas();
            for(Carta c: listc){
                img=mostrarC(c);
                try{
                    cartaJuego.setImage(img);
                    try{
                        Thread.sleep(2000);
                    }catch(InterruptedException ex){
                        ex.printStackTrace();
                    }
                }catch(Exception e){
                    System.out.println("No se pudo establecer imagen");
                }
            }
        }
    }
}


