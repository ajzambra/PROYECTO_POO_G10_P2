/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectopoo.proyecto_poo_g10_p02;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import modelo.Carta;
import modelo.CartaJuego;
import modelo.Mazo;
import modelo.Tablero;

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
    GridPane gridO=new GridPane();
    @FXML
    ImageView ImagenAlineacion= new ImageView();
    
    ArrayList<CartaJuego> listcJ=new ArrayList<CartaJuego>();
    
    Carta cartaenJ;
    
    
    @FXML
    private void initialize() {
        vb.setAlignment(Pos.CENTER);
        Mazo m = new Mazo();
        m.barajar();
        ArrayList<Carta> listc=m.getCartas();
        Tablero t=new Tablero();
        t.llenarTablero(listcJ);
        ArrayList<CartaJuego> tcarta=t.getCartas();
        for (int i=0;i<16;i++){
            StackPane sp = new StackPane();
            Carta ca = listc.get(i);
            int fila = i/4;
            int columna = i%4;
            Image imag =ca.mostrarC();
            ImageView imgViewFoto=new ImageView();//Creo la imagen
            imgViewFoto.setImage(imag);//Establesco la imagen    
            sp.getChildren().add(imgViewFoto);
            imgViewFoto.setOnMouseClicked(e->{
                ImageView imgF=new ImageView();
                if(ca.equials(cartaenJ)){
                    Image image=null;
                    InputStream input=null;
                    try{
                        input=App.class.getResource("filesDentro/images/bean.jpg").openStream();//creo la ruta
                        image=new Image(input,25,25,false,false);//La asigno en objeto imagen   
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
                    imgF.setImage(image);
                    sp.getChildren().add(imgF);
                
                }
                
                

            });
            
            CartaJuego cj=new CartaJuego(ca);
            listcJ.add(cj);
            
            gridC.add(sp, columna, fila);
            
            
    }
        t.llenarTablero(listcJ);
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
     int numeroaleatorio = (int) (4*Math.random()+1);
     vbA.setAlignment(Pos.CENTER);
     Image prueba = mostrarAlineacion(numeroaleatorio);
     ImagenAlineacion.setImage(prueba);
     vbA.getChildren().add(ImagenAlineacion);
         
    
        
}

  
    //CREACION DEL METODO PARA MOSTRAR LA ALINEACION SIN ALEATORIO SOLO PARA PROBAR
    private Image mostrarAlineacion(int numero){
    
        Image imagenAlineacion=null;
        InputStream inputAlineacion=null;
        try{
                    inputAlineacion=App.class.getResource("filesDentro/"+String.valueOf(numero)+".png").openStream();//creo la ruta
                    imagenAlineacion=new Image(inputAlineacion,200,200,false,false);//La asigno en objeto imagen   
                }catch(Exception  ex){
                    System.out.println("no se encuentra archivo de imagen");
                }finally{
                    if (inputAlineacion != null) {
                    try {
                        inputAlineacion.close();//Cierro el archivo
                    } catch (IOException ex) {
                        System.out.println("no se pudo cerrar");
                        }
                    } 
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
                cartaenJ=c;
                img=c.mostrarC();
                try{
                    cartaJuego.setImage(img);
                    try{
                        Thread.sleep(3000);
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


