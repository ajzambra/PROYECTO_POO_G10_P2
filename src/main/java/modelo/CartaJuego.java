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
public class CartaJuego {
    private Carta carta;
    private boolean marcada;
    
    public void marcarCarta(){
        
    }
    
    public Carta getCarta(){
        return carta;
    }
    
    public boolean getMarcada(){
        return marcada;
    }
    
    public String toString(){
        return ("Carta: "+carta+", Marcada:"+marcada);
    }
    
}
