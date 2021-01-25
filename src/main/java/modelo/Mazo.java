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

import com.proyectopoo.proyecto_poo_g10_p02.App;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Mazo {
    private ArrayList<Carta> carta=new ArrayList<Carta>();
    
    
    public void leerArchivoCarta(String ruta){
        FileReader f=null;
        try{
            f = new FileReader(new File(ruta));
            BufferedReader b = new BufferedReader(f);
            String cadena;
            while((cadena=b.readLine())!=null){
                String[] part=cadena.split(",");
                Carta c=new Carta(Integer.valueOf(part[0]),part[1],"filesDentro/images/deck/"+String.valueOf(part[0])+".png");
                carta.add(c);
            }
            
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
            
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        } finally{
            try{
                f.close();
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
            
        }
    }
    
    public void barajar(){
        leerArchivoCarta(App.ruta);
        Collections.shuffle(carta);
        
    }
    public ArrayList<Carta> getCartas(){
        return carta;
    }
    
    public int GenerarRandom(){
            Random random = new Random();
            int randomIndex = random.nextInt(54);
            return randomIndex;
        }
}
