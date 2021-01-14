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
public class Configuracion {
    private boolean visible;
    private int numOponentes;
    
    public boolean getVisible(){
        return visible;
    }
    
    public int getNumOponentes(){
        return numOponentes;
    }
    
    public void setVisible(boolean visible){
        this.visible=visible;
    }
    
    public void setNumOponentes(int numOponentes){
        this.numOponentes=numOponentes;
    }
    
    public String toString(){
        return ("visibilidad: "+visible+", Numero de Oponente: "+numOponentes);
    }
}
