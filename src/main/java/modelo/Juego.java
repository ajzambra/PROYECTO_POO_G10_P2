/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.ArrayList;
/**
 *
 * @author andre
 */
public class Juego {
    private String numJuego;
    private String fecha;
    private int duracion;
    private ArrayList <Jugador> jugadores = new ArrayList<Jugador>();
    private Jugador ganador;
    private Configuracion configuracion;
    private Mazo mazo;
    private ArrayList <Carta> cartasJugadas = new ArrayList<Carta>();
    private Alineacion alineacion;
    private Tablero tablero;
    
    
    public void verificarJuego(){
        
    }
}
