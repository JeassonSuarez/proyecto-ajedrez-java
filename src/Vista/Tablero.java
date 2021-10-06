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
        uno.setText("8");
        Etiqueta dos = (Etiqueta)admin.obtenerProto("etiqueta");
        dos.setText("7");
        Etiqueta tres = (Etiqueta)admin.obtenerProto("etiqueta");
        tres.setText("6");
        Etiqueta cuatro = (Etiqueta)admin.obtenerProto("etiqueta");
        cuatro.setText("5");
        Etiqueta cinco = (Etiqueta)admin.obtenerProto("etiqueta");
        cinco.setText("4");
        Etiqueta seis = (Etiqueta)admin.obtenerProto("etiqueta");
        seis.setText("3");
        Etiqueta siete = (Etiqueta)admin.obtenerProto("etiqueta");
        siete.setText("2");
        Etiqueta ocho = (Etiqueta)admin.obtenerProto("etiqueta");
        ocho.setText("1");
        
        
        Etiqueta unouno = (Etiqueta)admin.obtenerProto("etiqueta");
        unouno.setText("8");
        Etiqueta dosdos = (Etiqueta)admin.obtenerProto("etiqueta");
        dosdos.setText("7");
        Etiqueta trestres = (Etiqueta)admin.obtenerProto("etiqueta");
        trestres.setText("6");
        Etiqueta cuatrocuatro = (Etiqueta)admin.obtenerProto("etiqueta");
        cuatrocuatro.setText("5");
        Etiqueta cincocinco = (Etiqueta)admin.obtenerProto("etiqueta");
        cincocinco.setText("4");
        Etiqueta seisseis = (Etiqueta)admin.obtenerProto("etiqueta");
        seisseis.setText("3");
        Etiqueta sietesiete = (Etiqueta)admin.obtenerProto("etiqueta");
        sietesiete.setText("2");
        Etiqueta ochoocho = (Etiqueta)admin.obtenerProto("etiqueta");
        ochoocho.setText("1");
        
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
      
        cuadricula[0][4].setNombre("REY 1");
        cuadricula[0][4].setpX(4);
        cuadricula[0][4].setpY(0);
        cuadricula[0][4].setEquipo(1);
        cuadricula[0][4].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        ImageIcon rey1 = new ImageIcon("src\\Imagenes\\Equipo 1\\rey 1.png");
        Icon iconoRey1 = new ImageIcon(rey1.getImage().getScaledInstance(cuadricula[0][4].getWidth(), cuadricula[0][4].getHeight(), Image.SCALE_DEFAULT));
        cuadricula[0][4].setIcon(iconoRey1);
        
        cuadricula[0][3].setNombre("Dama 1");
        cuadricula[0][3].setpX(3);
        cuadricula[0][3].setpY(0);
        cuadricula[0][3].setEquipo(1);
        cuadricula[0][3].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        ImageIcon dama1 = new ImageIcon("src\\Imagenes\\Equipo 1\\dama 1.png");
        Icon iconoDama1 = new ImageIcon(dama1.getImage().getScaledInstance(cuadricula[0][3].getWidth(), cuadricula[0][3].getHeight(), Image.SCALE_DEFAULT));
        cuadricula[0][3].setIcon(iconoDama1);
        
        cuadricula[0][2].setNombre("AlfilI 1");
        cuadricula[0][2].setpX(2);
        cuadricula[0][2].setpY(0);
        cuadricula[0][2].setEquipo(1);
        cuadricula[0][2].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        ImageIcon alfil1 = new ImageIcon("src\\Imagenes\\Equipo 1\\alfil 1.png");
        Icon iconoalfil1 = new ImageIcon(alfil1.getImage().getScaledInstance(cuadricula[0][2].getWidth(), cuadricula[0][2].getHeight(), Image.SCALE_DEFAULT));
        cuadricula[0][2].setIcon(iconoalfil1);
        
        cuadricula[0][5].setNombre("AlfilD 1");
        cuadricula[0][5].setpX(5);
        cuadricula[0][5].setpY(0);
        cuadricula[0][5].setEquipo(1);
        cuadricula[0][5].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        cuadricula[0][5].setIcon(iconoalfil1);
        
        cuadricula[0][1].setNombre("CaballoI 1");
        cuadricula[0][1].setpX(1);
        cuadricula[0][1].setpY(0);
        cuadricula[0][1].setEquipo(1);
        cuadricula[0][1].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        ImageIcon caballo1 = new ImageIcon("src\\Imagenes\\Equipo 1\\caballo 1.png");
        Icon iconoCaballo = new ImageIcon(caballo1.getImage().getScaledInstance(cuadricula[0][1].getWidth(), cuadricula[0][1].getHeight(), Image.SCALE_DEFAULT));
        cuadricula[0][1].setIcon(iconoCaballo);
        
        cuadricula[0][6].setNombre("CaballoD 1");
        cuadricula[0][6].setpX(6);
        cuadricula[0][6].setpY(0);
        cuadricula[0][6].setEquipo(1);
        cuadricula[0][6].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        cuadricula[0][6].setIcon(iconoCaballo);
        
        cuadricula[0][0].setNombre("TorreI 1");
        cuadricula[0][0].setpX(0);
        cuadricula[0][0].setpY(0);
        cuadricula[0][0].setEquipo(1);
        cuadricula[0][0].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        ImageIcon torre1 = new ImageIcon("src\\Imagenes\\Equipo 1\\torre 1.png");
        Icon iconoTorre1 = new ImageIcon(torre1.getImage().getScaledInstance(cuadricula[0][0].getWidth(), cuadricula[0][0].getHeight(), Image.SCALE_DEFAULT));
        cuadricula[0][0].setIcon(iconoTorre1);
        
        cuadricula[0][7].setNombre("TorreD 1");
        cuadricula[0][7].setpX(7);
        cuadricula[0][7].setpY(0);
        cuadricula[0][7].setEquipo(1);
        cuadricula[0][7].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        cuadricula[0][7].setIcon(iconoTorre1);
        
        cuadricula[1][0].setNombre("Peon 1");
        cuadricula[1][0].setpX(0);
        cuadricula[1][0].setpY(1);
        cuadricula[1][0].setEquipo(1);
        cuadricula[1][0].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        ImageIcon peon1 = new ImageIcon("src\\Imagenes\\Equipo 1\\peon 1.png");
        Icon iconoPeon1 = new ImageIcon(peon1.getImage().getScaledInstance(cuadricula[1][0].getWidth(), cuadricula[1][0].getHeight(), Image.SCALE_DEFAULT));
        cuadricula[1][0].setIcon(iconoPeon1);
        
        cuadricula[1][1].setNombre("Peon 1");
        cuadricula[1][1].setpX(1);
        cuadricula[1][1].setpY(1);
        cuadricula[1][1].setEquipo(1);
        cuadricula[1][1].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        cuadricula[1][1].setIcon(iconoPeon1);
        
        cuadricula[1][2].setNombre("Peon 1");
        cuadricula[1][2].setpX(2);
        cuadricula[1][2].setpY(1);
        cuadricula[1][2].setEquipo(1);
        cuadricula[1][2].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        cuadricula[1][2].setIcon(iconoPeon1);
        
        cuadricula[1][3].setNombre("Peon 1");
        cuadricula[1][3].setpX(3);
        cuadricula[1][3].setpY(1);
        cuadricula[1][3].setEquipo(1);
        cuadricula[1][3].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        cuadricula[1][3].setIcon(iconoPeon1);
        
        cuadricula[1][4].setNombre("Peon 1");
        cuadricula[1][4].setpX(4);
        cuadricula[1][4].setpY(1);
        cuadricula[1][4].setEquipo(1);
        cuadricula[1][4].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        cuadricula[1][4].setIcon(iconoPeon1);
        
        cuadricula[1][5].setNombre("Peon 1");
        cuadricula[1][5].setpX(5);
        cuadricula[1][5].setpY(1);
        cuadricula[1][5].setEquipo(1);
        cuadricula[1][5].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        cuadricula[1][5].setIcon(iconoPeon1);
        
        cuadricula[1][6].setNombre("Peon 1");
        cuadricula[1][6].setpX(6);
        cuadricula[1][6].setpY(1);
        cuadricula[1][6].setEquipo(1);
        cuadricula[1][6].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        cuadricula[1][6].setIcon(iconoPeon1);
        
        cuadricula[1][7].setNombre("Peon 1");
        cuadricula[1][7].setpX(7);
        cuadricula[1][7].setpY(1);
        cuadricula[1][7].setEquipo(1);
        cuadricula[1][7].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        cuadricula[1][7].setIcon(iconoPeon1);
        
        
        cuadricula[7][4].setNombre("REY 2");
        cuadricula[7][4].setpX(4);
        cuadricula[7][4].setpY(7);
        cuadricula[7][4].setEquipo(2);
        cuadricula[7][4].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        ImageIcon rey2 = new ImageIcon("src\\Imagenes\\Equipo 2\\rey 2.png");
        Icon iconoRey2 = new ImageIcon(rey2.getImage().getScaledInstance(cuadricula[7][4].getWidth(), cuadricula[7][4].getHeight(), Image.SCALE_DEFAULT));
        cuadricula[7][4].setIcon(iconoRey2);
        
        cuadricula[7][3].setNombre("Dama 2");
        cuadricula[7][3].setpX(3);
        cuadricula[7][3].setpY(7);
        cuadricula[7][3].setEquipo(2);
        cuadricula[7][3].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        ImageIcon dama2 = new ImageIcon("src\\Imagenes\\Equipo 2\\dama 2.png");
        Icon iconoDama2 = new ImageIcon(dama2.getImage().getScaledInstance(cuadricula[7][3].getWidth(), cuadricula[7][3].getHeight(), Image.SCALE_DEFAULT));
        cuadricula[7][3].setIcon(iconoDama2);
        
        cuadricula[7][2].setNombre("AlfilI 2");
        cuadricula[7][2].setpX(2);
        cuadricula[7][2].setpY(7);
        cuadricula[7][2].setEquipo(2);
        cuadricula[7][2].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        ImageIcon alfil2 = new ImageIcon("src\\Imagenes\\Equipo 2\\alfil 2.png");
        Icon iconoalfil2 = new ImageIcon(alfil2.getImage().getScaledInstance(cuadricula[7][2].getWidth(), cuadricula[7][2].getHeight(), Image.SCALE_DEFAULT));
        cuadricula[7][2].setIcon(iconoalfil2);
        
        cuadricula[7][5].setNombre("AlfilD 2");
        cuadricula[7][5].setpX(5);
        cuadricula[7][5].setpY(7);
        cuadricula[7][5].setEquipo(2);
        cuadricula[7][5].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        cuadricula[7][5].setIcon(iconoalfil2);
        
        cuadricula[7][1].setNombre("CaballoI 2");
        cuadricula[7][1].setpX(1);
        cuadricula[7][1].setpY(7);
        cuadricula[7][1].setEquipo(2);
        cuadricula[7][1].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        ImageIcon caballo2 = new ImageIcon("src\\Imagenes\\Equipo 2\\caballo 2.png");
        Icon iconoCaballo2 = new ImageIcon(caballo2.getImage().getScaledInstance(cuadricula[7][1].getWidth(), cuadricula[7][1].getHeight(), Image.SCALE_DEFAULT));
        cuadricula[7][1].setIcon(iconoCaballo2);
        
        cuadricula[7][6].setNombre("CaballoD 2");
        cuadricula[7][6].setpX(6);
        cuadricula[7][6].setpY(7);
        cuadricula[7][6].setEquipo(2);
        cuadricula[7][6].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        cuadricula[7][6].setIcon(iconoCaballo2);
        
        cuadricula[7][0].setNombre("TorreI 2");
        cuadricula[7][0].setpX(0);
        cuadricula[7][0].setpY(7);
        cuadricula[7][0].setEquipo(2);
        cuadricula[7][0].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        ImageIcon torre2 = new ImageIcon("src\\Imagenes\\Equipo 2\\torre 2.png");
        Icon iconoTorre2 = new ImageIcon(torre2.getImage().getScaledInstance(cuadricula[7][0].getWidth(), cuadricula[7][0].getHeight(), Image.SCALE_DEFAULT));
        cuadricula[7][0].setIcon(iconoTorre2);
        
        cuadricula[7][7].setNombre("TorreD 2");
        cuadricula[7][7].setpX(7);
        cuadricula[7][7].setpY(7);
        cuadricula[7][7].setEquipo(2);
        cuadricula[7][7].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        cuadricula[7][7].setIcon(iconoTorre2);
        
        cuadricula[6][0].setNombre("Peon 2");
        cuadricula[6][0].setpX(0);
        cuadricula[6][0].setpY(6);
        cuadricula[6][0].setEquipo(2);
        cuadricula[6][0].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        ImageIcon peon2 = new ImageIcon("src\\Imagenes\\Equipo 2\\peon 2.png");
        Icon iconoPeon2 = new ImageIcon(peon2.getImage().getScaledInstance(cuadricula[6][0].getWidth(), cuadricula[6][0].getHeight(), Image.SCALE_DEFAULT));
        cuadricula[6][0].setIcon(iconoPeon2);
        
        cuadricula[6][1].setNombre("Peon 2");
        cuadricula[6][1].setpX(1);
        cuadricula[6][1].setpY(6);
        cuadricula[6][1].setEquipo(2);
        cuadricula[6][1].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        cuadricula[6][1].setIcon(iconoPeon2);
        
        cuadricula[6][2].setNombre("Peon 2");
        cuadricula[6][2].setpX(2);
        cuadricula[6][2].setpY(6);
        cuadricula[6][2].setEquipo(2);
        cuadricula[6][2].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        cuadricula[6][2].setIcon(iconoPeon2);
        
        cuadricula[6][3].setNombre("Peon 2");
        cuadricula[6][3].setpX(3);
        cuadricula[6][3].setpY(6);
        cuadricula[6][3].setEquipo(2);
        cuadricula[6][3].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        cuadricula[6][3].setIcon(iconoPeon2);
        
        cuadricula[6][4].setNombre("Peon 2");
        cuadricula[6][4].setpX(4);
        cuadricula[6][4].setpY(6);
        cuadricula[6][4].setEquipo(2);
        cuadricula[6][4].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        cuadricula[6][4].setIcon(iconoPeon2);
        
        cuadricula[6][5].setNombre("Peon 2");
        cuadricula[6][5].setpX(5);
        cuadricula[6][5].setpY(6);
        cuadricula[6][5].setEquipo(2);
        cuadricula[6][5].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        cuadricula[6][5].setIcon(iconoPeon2);
        
        cuadricula[6][6].setNombre("Peon 2");
        cuadricula[6][6].setpX(6);
        cuadricula[6][6].setpY(6);
        cuadricula[6][6].setEquipo(2);
        cuadricula[6][6].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        cuadricula[6][6].setIcon(iconoPeon2);
        
        cuadricula[6][7].setNombre("Peon 2");
        cuadricula[6][7].setpX(7);
        cuadricula[6][7].setpY(6);
        cuadricula[6][7].setEquipo(2);
        cuadricula[6][7].setSize(cuadricula[0][0].getHeight(), cuadricula[0][0].getWidth());
        cuadricula[6][7].setIcon(iconoPeon2);
        
        
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
