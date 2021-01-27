/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectopoo.proyecto_poo_g10_p02;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import modelo.Alineacion;
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
    @FXML
    Button bLoteria;
    
    ArrayList<CartaJuego> listcJ;
    
    Tablero t;
    
    Carta cartaenJ;
    
    Alineacion al;
    
    
    @FXML
    private void initialize() {
        vb.setAlignment(Pos.CENTER);
        Mazo m = new Mazo();
        m.barajar();
        ArrayList<Carta> listc=m.getCartas();
        listcJ=new ArrayList<CartaJuego>();
        t=new Tablero();
        for (int i=0;i<16;i++){
            StackPane sp = new StackPane();
            Carta ca = listc.get(i);
            CartaJuego cartags=new CartaJuego(ca);
            int fila = i/4;
            int columna = i%4;
            Image imag =ca.mostrarC();
            ImageView imgViewFoto=new ImageView();//Creo la imagen
            imgViewFoto.setImage(imag);//Establesco la imagen    
            sp.getChildren().add(imgViewFoto);
            imgViewFoto.setOnMouseClicked(e->{
                ImageView imgF=new ImageView();
                if(ca.equials(cartaenJ)){
                    cartags.marcarCarta();
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
            
            gridC.add(sp, columna, fila);
            listcJ.add(cartags);
            
    }
        System.out.println(listcJ);
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

  
    //CREACION DEL METODO PARA MOSTRAR LA ALINEACION 
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
        if(numero==1){
            al=Alineacion.COLUMNA;
        }
        if(numero==2){
            al=Alineacion.ESQUINAC;
        }
        if(numero==3){
            al=Alineacion.ESQUINA;
        }else{
            al=Alineacion.FILA;
        }
        System.out.println(al);
        return imagenAlineacion;
            
        
           
    }
    
    @FXML
    public void comprobarJ(){
        ArrayList<CartaJuego> listac=t.getCartas();
        boolean condiTo=false;
       
        int i=0;
        if (al.equals(Alineacion.COLUMNA)){
            boolean condi1 = listac.get(0).getmarcada();
            boolean condi2 = listac.get(4).getmarcada();
            boolean condi3 = listac.get(8).getmarcada();
            boolean condi4 = listac.get(12).getmarcada();
            condiTo=condi1 && condi2 && condi3 && condi4;
            if(condiTo==false){
                condi1 = listac.get(1).getmarcada();
                condi2 = listac.get(5).getmarcada();
                condi3 = listac.get(9).getmarcada();
                condi4 = listac.get(13).getmarcada();
                condiTo=condi1 && condi2 && condi3 && condi4;
            }
            if(condiTo==false){
                condi1 = listac.get(2).getmarcada();
                condi2 = listac.get(6).getmarcada();
                condi3 = listac.get(10).getmarcada();
                condi4 = listac.get(14).getmarcada();
                condiTo=condi1 && condi2 && condi3 && condi4;
            }
            if(condiTo==false){
                condi1 = listac.get(3).getmarcada();
                condi2 = listac.get(7).getmarcada();
                condi3 = listac.get(11).getmarcada();
                condi4 = listac.get(15).getmarcada();
                condiTo=condi1 && condi2 && condi3 && condi4;
                }
            
            
        }if(al.equals(Alineacion.ESQUINA)){
            while(i<16){
                boolean condi1 = listac.get(0).getmarcada();
                boolean condi2 = listac.get(3).getmarcada();
                boolean condi3 = listac.get(12).getmarcada();
                boolean condi4 = listac.get(15).getmarcada();
                condiTo=condi1 && condi2 && condi3 && condi4;
                i=16;
            }
        }if(al.equals(Alineacion.ESQUINAC)){
                boolean condi1 = listac.get(0).getmarcada();
                boolean condi2 = listac.get(1).getmarcada();
                boolean condi3 = listac.get(4).getmarcada();
                boolean condi4 = listac.get(5).getmarcada();
                condiTo=condi1 && condi2 && condi3 && condi4;
                if(condiTo==false){
                    condi1 = listac.get(2).getmarcada();
                    condi2 = listac.get(3).getmarcada();
                    condi3 = listac.get(6).getmarcada();
                    condi4 = listac.get(7).getmarcada();
                    condiTo=condi1 && condi2 && condi3 && condi4;
                }
                if(condiTo==false){
                    condi1 = listac.get(8).getmarcada();
                    condi2 = listac.get(9).getmarcada();
                    condi3 = listac.get(12).getmarcada();
                    condi4 = listac.get(13).getmarcada();
                    condiTo=condi1 && condi2 && condi3 && condi4;
                }
                if(condiTo==false){
                    condi1 = listac.get(10).getmarcada();
                    condi2 = listac.get(11).getmarcada();
                    condi3 = listac.get(14).getmarcada();
                    condi4 = listac.get(15).getmarcada();
                    condiTo=condi1 && condi2 && condi3 && condi4;
                }
        }if(al.equals(Alineacion.FILA)){
            int variablecontrol=0;
            do{boolean condi1 = listac.get(i).getmarcada();
                boolean condi2 = listac.get(i+1).getmarcada();
                boolean condi3 = listac.get(i+2).getmarcada();
                boolean condi4 = listac.get(i+3).getmarcada();
                condiTo=condi1 && condi2 && condi3 && condi4;
                if (condiTo == true){
                    variablecontrol=1;
                }
                i+=4;}
            while(i<16 && variablecontrol<=0 ); //&& variablecontrol<0){
                
            
        }
        if(condiTo==true){
                System.out.println("Gano");
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("!!!GANO¡¡¡");
                alert.setHeaderText(null);
                alert.setContentText("CONSIGIO COMPLETAR LA ALINEACIÓN GANADORA");

                Optional<ButtonType> result = alert.showAndWait();
                if(result.get() == ButtonType.OK){
                    try {
                        App.setRoot("Menu Principal");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
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


