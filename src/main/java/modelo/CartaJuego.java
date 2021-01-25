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
    
    public CartaJuego(Carta c){
        carta=c;
        marcada=false;
    }
    
    public void marcarCarta(){
        marcada=true;
    }
    
    public boolean getmarcada(){
        return marcada;
    }
    
    public Carta getCarta(){
        return carta;
    }
    
    public String toString(){
        return ("Carta: "+carta+", Marcada: "+marcada);
    }
}
