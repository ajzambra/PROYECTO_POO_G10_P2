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
import java.util.ArrayList;

public class Tablero {
    private ArrayList<CartaJuego> cartas = new ArrayList<CartaJuego>();
    
    public void llenarTablero(ArrayList<CartaJuego> cartas){
        this.cartas=cartas;
    }
    public ArrayList<CartaJuego> getCartas(){
        return cartas;
    }
}
