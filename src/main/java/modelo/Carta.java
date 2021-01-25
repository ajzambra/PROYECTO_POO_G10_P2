/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.proyectopoo.proyecto_poo_g10_p02.App;
import java.io.IOException;
import java.io.InputStream;
import javafx.scene.image.Image;

/**
 *
 * @author andre
 */
public class Carta {
    private int numero;
    private String nombre;
    private String rutaImagen;
    
    public Carta(int numero,String nombre,String rutaImagen){
        this.numero=numero;
        this.nombre=nombre;
        this.rutaImagen=rutaImagen;
    }
    
    public boolean equials(Carta c){
        return (this == c);
    }
    
    public String toString(){
        return ("Numero: "+numero+", Nombre: "+nombre+", Ruta de Imagen:"+rutaImagen);
    }
    
    public String getRutaImagen(){
        return rutaImagen;
    }
    
    public Image mostrarC(){
        Image image=null;
        InputStream input=null;
        try{
            input=App.class.getResource(rutaImagen).openStream();//creo la ruta
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
}
