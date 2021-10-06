/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

import Vista.Tablero;
import memento.Caretaker;

/**
 *
 * @author JEASS
 */
public class Ajedrez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tablero t = new Tablero();
        t.setVisible(true);
        
        Caretaker ct = new Caretaker();
        ct.setMm(t.creaMemento());
        t.traerMemento(ct.getMm());
    }
    
}
