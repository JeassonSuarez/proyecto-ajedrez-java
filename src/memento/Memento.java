/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memento;
import Vista.Tablero;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author JEASS
 */
public class Memento{

    public Memento() {
    }
    
    public void salvar(Tablero tObjeto){
        try {
           
            ObjectOutputStream guardarDatos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\JEASS\\OneDrive\\Escritorio\\Ajedrez\\src\\ArchivoM\\inicio.dat"));
        
            guardarDatos.writeObject(tObjeto);
            
            guardarDatos.close();
            
        } catch (Exception e) {
            System.out.println(""+e);
        }
    }
    
    public Tablero leerMemento(){
        Tablero tableroInicio = new Tablero();
        try {
            ObjectInputStream leerM =new ObjectInputStream(new FileInputStream("C:\\Users\\JEASS\\OneDrive\\Escritorio\\Ajedrez\\src\\ArchivoM\\inicio.dat"));
            
            Tablero recuperadoM = (Tablero)leerM.readObject();
            
            leerM.close();
            tableroInicio = recuperadoM;
        } catch (Exception e) {
            System.out.println(""+e);
        }
       return tableroInicio;
    }
    
}
