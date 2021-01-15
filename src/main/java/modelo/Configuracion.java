/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author andre
 */
public class Configuracion implements Serializable{
    private boolean visible;
    private int numOponentes;

    public Configuracion(boolean visible, int numOponentes) {
        this.visible = visible;
        this.numOponentes = numOponentes;
    }
    
}
