/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Prototipos.APrototipo;
import Prototipos.Etiqueta;
import Prototipos.Ficha;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import memento.Caretaker;
import memento.Memento;
/**
 *
 * @author JEASS
 */
public class Tablero extends javax.swing.JFrame implements Serializable, ActionListener{

    //creaciopn de variables de clase, componentes del tablero ajedrez
    
    private int anchoPantalla;
    private int altoPantalla;
    private JPanel mesa;
    private JPanel sup = new JPanel();
    private JPanel lat = new JPanel();
    private JPanel j = new JPanel();
    private JPanel inf = new JPanel();
    private JPanel latD = new JPanel();
    private Ficha[][] cuadricula;
    private JButton nula2i;
    private Caretaker ct;
    private APrototipo admin;
    
    
    public Tablero() {
        
        //se toman las dimesiones de la pantalla
        Toolkit pantalla = Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla = pantalla.getScreenSize();
        this.anchoPantalla = tamanioPantalla.width;
        this.altoPantalla = tamanioPantalla.height;
        
        // asignacion de tamaño de ventana
        setBounds(anchoPantalla/4, -altoPantalla+altoPantalla+15, 720, 720);
        setResizable(true);
        setTitle("AJEDREZ");
        
        //asignacion icono de ventana
        Image iconoAjedrez = pantalla.getImage("src/Imagenes/iconoAjedrez.png");
        setIconImage(iconoAjedrez);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        generaEtiquetas();
        generaCuadricula();
        inicioFichas();
        reinicio();
        
    }
    
    public void generaEtiquetas(){
        
        //asignacion de colores a divisiones del tablero
        sup.setBackground(Color.BLUE);
        lat.setBackground(Color.gray);
        inf.setBackground(Color.BLUE);
        latD.setBackground(Color.gray);
        
        //asignacion de dimensiones a los componentes del tablero
        sup.setPreferredSize(new Dimension(100, 70));
        lat.setPreferredSize(new Dimension(70, 100));
        inf.setPreferredSize(new Dimension(100, 70));
        latD.setPreferredSize(new Dimension(70, 100));
        
        //se asigna forma de ordenamiento dentro de las divisiones del tablero
        sup.setLayout(new GridLayout(1, 10));
        lat.setLayout(new GridLayout(8, 1));
        inf.setLayout(new GridLayout(1, 10));
        latD.setLayout(new GridLayout(8, 1));
       
        //asigna ubicacion a divisiones del tablero
        add(sup, BorderLayout.NORTH);
        add(lat, BorderLayout.LINE_START);
        add(j, BorderLayout.CENTER);
        add(inf, BorderLayout.SOUTH);
        add(latD, BorderLayout.LINE_END);
        
        //asigna letras y numeros al borde del tablero de 1-8 y a-h
        admin = new APrototipo();
        Etiqueta a = (Etiqueta)admin.obtenerProto("etiqueta");
        a.setText("A");
        Etiqueta b = (Etiqueta)admin.obtenerProto("etiqueta");
        b.setText("B");
        Etiqueta c = (Etiqueta)admin.obtenerProto("etiqueta");
        c.setText("C");
        Etiqueta d = (Etiqueta)admin.obtenerProto("etiqueta");
        d.setText("D");
        Etiqueta e = (Etiqueta)admin.obtenerProto("etiqueta");
        e.setText("E");
        Etiqueta f = (Etiqueta)admin.obtenerProto("etiqueta");
        f.setText("F");
        Etiqueta g = (Etiqueta)admin.obtenerProto("etiqueta");
        g.setText("G");
        Etiqueta h = (Etiqueta)admin.obtenerProto("etiqueta");
        h.setText("H");
        Etiqueta nula1 = (Etiqueta)admin.obtenerProto("etiqueta");
        nula1.setText("---");
        Etiqueta nula2 = (Etiqueta)admin.obtenerProto("etiqueta");
        nula2.setText("---");
        
        Etiqueta ai = (Etiqueta)admin.obtenerProto("etiqueta");
        ai.setText("A");
        Etiqueta bi = (Etiqueta)admin.obtenerProto("etiqueta");
        bi.setText("B");
        Etiqueta ci = (Etiqueta)admin.obtenerProto("etiqueta");
        ci.setText("C");
        Etiqueta di = (Etiqueta)admin.obtenerProto("etiqueta");
        di.setText("D");
        Etiqueta ei = (Etiqueta)admin.obtenerProto("etiqueta");
        ei.setText("E");
        Etiqueta fi = (Etiqueta)admin.obtenerProto("etiqueta");
        fi.setText("F");
        Etiqueta gi = (Etiqueta)admin.obtenerProto("etiqueta");
        gi.setText("G");
        Etiqueta hi = (Etiqueta)admin.obtenerProto("etiqueta");
        hi.setText("H");
        Etiqueta nula1i = (Etiqueta)admin.obtenerProto("etiqueta");
        nula1i.setText("---");
        nula2i = new JButton();
        nula2i.setText("R");
        nula2i.setEnabled(true);
        nula2i.setForeground(Color.white);
        nula2i.setBackground(Color.DARK_GRAY);
        
        
        
        Etiqueta uno = (Etiqueta)admin.obtenerProto("etiqueta");
        uno.setText("1");
        Etiqueta dos = (Etiqueta)admin.obtenerProto("etiqueta");
        dos.setText("2");
        Etiqueta tres = (Etiqueta)admin.obtenerProto("etiqueta");
        tres.setText("3");
        Etiqueta cuatro = (Etiqueta)admin.obtenerProto("etiqueta");
        cuatro.setText("4");
        Etiqueta cinco = (Etiqueta)admin.obtenerProto("etiqueta");
        cinco.setText("5");
        Etiqueta seis = (Etiqueta)admin.obtenerProto("etiqueta");
        seis.setText("6");
        Etiqueta siete = (Etiqueta)admin.obtenerProto("etiqueta");
        siete.setText("7");
        Etiqueta ocho = (Etiqueta)admin.obtenerProto("etiqueta");
        ocho.setText("8");
        
        
        Etiqueta unouno = (Etiqueta)admin.obtenerProto("etiqueta");
        unouno.setText("1");
        Etiqueta dosdos = (Etiqueta)admin.obtenerProto("etiqueta");
        dosdos.setText("2");
        Etiqueta trestres = (Etiqueta)admin.obtenerProto("etiqueta");
        trestres.setText("3");
        Etiqueta cuatrocuatro = (Etiqueta)admin.obtenerProto("etiqueta");
        cuatrocuatro.setText("4");
        Etiqueta cincocinco = (Etiqueta)admin.obtenerProto("etiqueta");
        cincocinco.setText("5");
        Etiqueta seisseis = (Etiqueta)admin.obtenerProto("etiqueta");
        seisseis.setText("6");
        Etiqueta sietesiete = (Etiqueta)admin.obtenerProto("etiqueta");
        sietesiete.setText("7");
        Etiqueta ochoocho = (Etiqueta)admin.obtenerProto("etiqueta");
        ochoocho.setText("8");
        
        sup.add(nula1);
        sup.add(a);
        sup.add(b);
        sup.add(c);
        sup.add(d);
        sup.add(e);
        sup.add(f);
        sup.add(g);
        sup.add(h);
        sup.add(nula2);
        
        inf.add(nula1i);
        inf.add(ai);
        inf.add(bi);
        inf.add(ci);
        inf.add(di);
        inf.add(ei);
        inf.add(fi);
        inf.add(gi);
        inf.add(hi);
        inf.add(nula2i);
        
        lat.add(uno);
        lat.add(dos);
        lat.add(tres);
        lat.add(cuatro);
        lat.add(cinco);
        lat.add(seis);
        lat.add(siete);
        lat.add(ocho);
        
        latD.add(unouno);
        latD.add(dosdos);
        latD.add(trestres);
        latD.add(cuatrocuatro);
        latD.add(cincocinco);
        latD.add(seisseis);
        latD.add(sietesiete);
        latD.add(ochoocho);
    }
    
    public void generaCuadricula(){
        j.setBackground(Color.red);
        j.setLayout(new GridLayout(8, 8));
        j.setPreferredSize(new Dimension(100, 100));
        cuadricula = new Ficha[8][8];
        
        /*asignacion de un espacio o suelo a cada posicion donde 
        iran las fichas, ademas asignacion de color a cada posicion*/
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                cuadricula[i][k] = (Ficha)admin.obtenerProto("ficha");
                cuadricula[i][k].setSize(80,80);
                if (i%2 == 0 && k%2 != 0) {
                    cuadricula[i][k].setBackground(Color.GRAY);
                }else if(i%2 != 0 && k%2 == 0){
                    cuadricula[i][k].setBackground(Color.GRAY);
                }else{
                    cuadricula[i][k].setBackground(Color.WHITE);
                }
                j.add(cuadricula[i][k]);
            }   
        }
    }
    
    public Memento creaMemento(){
        Memento mementoInterfaz = new Memento();
        mementoInterfaz.salvar(this);
        return mementoInterfaz;
    }
    
    public void traerMemento(Memento mementoInterfaz){
        Tablero iMInicio = mementoInterfaz.leerMemento();
        this.anchoPantalla = iMInicio.anchoPantalla;
        this.altoPantalla = iMInicio.altoPantalla;
        this.mesa = iMInicio.mesa;
        this.sup = iMInicio.sup;
        this.lat = iMInicio.lat;
        this.j = iMInicio.j;
        this.inf = iMInicio.inf;
        this.latD = iMInicio.latD;
        this.cuadricula = iMInicio.cuadricula;
        this.nula2i = iMInicio.nula2i;
        this.admin = iMInicio.admin;
       
    }

    public void reinicio(){
        nula2i.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        j.setBackground(Color.yellow);
    }
    
    public void inicioFichas(){
       /* Ficha rey1 = (Ficha)admin.obtenerProto("ficha");
        Ficha dama1 = (Ficha)admin.obtenerProto("ficha");
        Ficha alfilP1 = (Ficha)admin.obtenerProto("ficha");
        Ficha alfilS1 = (Ficha)admin.obtenerProto("ficha");
        Ficha caballoP1 = (Ficha)admin.obtenerProto("ficha");
        Ficha caballoS1 = (Ficha)admin.obtenerProto("ficha");
        Ficha torreP1 = (Ficha)admin.obtenerProto("ficha");
        Ficha torreS1 = (Ficha)admin.obtenerProto("ficha");
        Ficha peonUno1 = (Ficha)admin.obtenerProto("ficha");
        Ficha peonDos1 = (Ficha)admin.obtenerProto("ficha");
        Ficha peonTres1 = (Ficha)admin.obtenerProto("ficha");
        Ficha peonCuatro1 = (Ficha)admin.obtenerProto("ficha");
        Ficha peonCinco1 = (Ficha)admin.obtenerProto("ficha");
        Ficha peonSeis1 = (Ficha)admin.obtenerProto("ficha");
        Ficha peonSiete1 = (Ficha)admin.obtenerProto("ficha");
        Ficha peonOcho1 = (Ficha)admin.obtenerProto("ficha");
        
        
        Ficha rey2 = (Ficha)admin.obtenerProto("ficha");
        Ficha dama2 = (Ficha)admin.obtenerProto("ficha");
        Ficha alfilP2 = (Ficha)admin.obtenerProto("ficha");
        Ficha alfilS2 = (Ficha)admin.obtenerProto("ficha");
        Ficha caballoP2 = (Ficha)admin.obtenerProto("ficha");
        Ficha caballoS2 = (Ficha)admin.obtenerProto("ficha");
        Ficha torreP2 = (Ficha)admin.obtenerProto("ficha");
        Ficha torreS2 = (Ficha)admin.obtenerProto("ficha");
        Ficha peonUno2 = (Ficha)admin.obtenerProto("ficha");
        Ficha peonDos2 = (Ficha)admin.obtenerProto("ficha");
        Ficha peonTres2 = (Ficha)admin.obtenerProto("ficha");
        Ficha peonCuatro2 = (Ficha)admin.obtenerProto("ficha");
        Ficha peonCinco2 = (Ficha)admin.obtenerProto("ficha");
        Ficha peonSeis2 = (Ficha)admin.obtenerProto("ficha");
        Ficha peonSiete2 = (Ficha)admin.obtenerProto("ficha");
        Ficha peonOcho2 = (Ficha)admin.obtenerProto("ficha");*/
        
        
        cuadricula[0][4].setNombre("REY 1");
        cuadricula[0][4].setpX(0);
        cuadricula[0][4].setpY(0);
        cuadricula[0][4].setEquipo(1);
        cuadricula[0][4].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        ImageIcon fot = new ImageIcon("src\\Imagenes\\Equipo 1\\rey 1.png");
        Icon icono = new ImageIcon(fot.getImage().getScaledInstance(cuadricula[0][4].getWidth(), cuadricula[0][4].getHeight(), Image.SCALE_DEFAULT));
        cuadricula[0][4].setIcon(icono);
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
