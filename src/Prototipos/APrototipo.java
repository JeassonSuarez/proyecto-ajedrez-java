/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prototipos;

import java.io.Serializable;
import java.util.HashMap;
import javax.swing.JButton;

/**
 *
 * @author JEASS
 */
public class APrototipo implements Serializable{
     private HashMap <String, IPrototipo> proto;
    
    public APrototipo(){
        proto = new HashMap<String, IPrototipo>();
        
        Ficha f = new Ficha("", 0, 0, "", 1);
        proto.put("ficha", f);
        
        Etiqueta e = new Etiqueta();
        proto.put("etiqueta", e);
    }
    
    public Object obtenerProto(String clave){
        return proto.get(clave).clonar();
    }
}
