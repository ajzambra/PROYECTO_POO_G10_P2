/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
    
    public void equials(Carta c){
        
    }
    
    public String toString(){
        return ("Numero: "+numero+", Nombre: "+nombre+", Ruta de Imagen:"+rutaImagen);
    }
    
    public String getRutaImagen(){
        return rutaImagen;
    }
}
