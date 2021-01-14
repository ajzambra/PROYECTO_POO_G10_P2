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
    
    public void Carta(int numero,String nombre,String rutaImagen){
        this.numero=numero;
        this.nombre=nombre;
        this.rutaImagen=rutaImagen;
    }
    
    public int getNumero(){
        return numero;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getRutaImagen(){
        return rutaImagen;
    }
    
    
    public void equials(Carta c){
        
    }
    
    @Override
    public String toString(){
        return ("Numero: "+numero+", Nombre: "+nombre+", Ruta de Imagen: "+rutaImagen);
    }
}
