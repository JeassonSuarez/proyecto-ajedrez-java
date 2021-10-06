/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prototipos;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author JEASS
 */
public class Etiqueta extends JButton implements IPrototipo{
   
    public Etiqueta( ) {
        setEnabled(false);
        setBackground(Color.DARK_GRAY);
        
    }

    @Override
    public Object clonar() {
        Etiqueta clon = new Etiqueta();
        return clon;
    } 
}
