 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.MelodyRabbit.GUI;

import co.edu.udea.MelodyRabbit.Logica.Controlador;
import co.edu.udea.MelodyRabbit.Logica.Melodia;
import co.edu.udea.MelodyRabbit.Logica.Puntaje;
import co.edu.udea.MelodyRabbit.Logica.Escala;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.util.Observer;
import java.util.*;

/**
 *
 * @author luisa
 */
public class MelodyRabbit extends javax.swing.JFrame implements Observer{

    private JLabel lblconejo = new JLabel(); //el jlabel que muestra al conejo
    private JLabel lblarbol = new JLabel();
    private static MelodyRabbit melodyRabbit;
    private JLabel[] b; //nota que cae
    private int x = 50; //tamaño notas
    private int d = 60; //distancia notas
    private int numeroNotas;
    private int anchoVentana = 800;
    private int altoVentana = 600;
    private int velocidad = 20;
   // Escala escala = new Escala();
    private Timer timer;
    private String[] rutaImages;
    private int dirY = 0; //cantidad de movimiento de las notas   diry x 20 = numero de pixeles por segundo
    private int milisegundos = 50;
   // Melodia melodia = new Melodia();
   // Puntaje juego;
    private boolean sonando = false;
    private int BPM = 0;
    private Rendimiento tabla = new Rendimiento();
    private Partida info = new Partida();
    private ClaseObserver miObservador;
    private int nivelJ;
    private int puntosS, puntosR;
    private Controlador ctrl=new Controlador();
    //PausaMenu pausaMen = new PausaMenu();
    

    private boolean pausa;


      public MelodyRabbit(Controlador  control, int lvl, ClaseObserver observador, String nombre,int c) {  // parametros int tonalidad, boolean mayor, int numeroNotas, int bpm 
        ctrl=control;
        int  ps=ctrl.juegoGetPuntosASumar();
        int pr=ctrl.juegoGetPuntosARestar();
        
        int tonalidad=ctrl.juegoGetCancion(c).getTonalidad();
        boolean mayor= ctrl.juegoGetCancion(c).isMayor(); 
        int numeroNotas=ctrl.juegoGetNumeroNotas();  
        int bpm=ctrl.juegoGetCancion(c).getBpm();
        initComponents();
        this.setLayout(null);
        this.setSize(anchoVentana, altoVentana);
        this.setResizable(false);
        
        miObservador = observador;

        rutaImages = new String[12];
        rutaImages[0] = "/co/edu/udea/MelodyRabbit/GUI/image/C.png";
        rutaImages[1] = "/co/edu/udea/MelodyRabbit/GUI/image/c#.png";
        rutaImages[2] = "/co/edu/udea/MelodyRabbit/GUI/image/d.png";
        rutaImages[3] = "/co/edu/udea/MelodyRabbit/GUI/image/D#.png";
        rutaImages[4] = "/co/edu/udea/MelodyRabbit/GUI/image/E.png";
        rutaImages[5] = "/co/edu/udea/MelodyRabbit/GUI/image/F.png";
        rutaImages[6] = "/co/edu/udea/MelodyRabbit/GUI/image/F#.png";
        rutaImages[7] = "/co/edu/udea/MelodyRabbit/GUI/image/G.png";
        rutaImages[8] = "/co/edu/udea/MelodyRabbit/GUI/image/G#.png";
        rutaImages[9] = "/co/edu/udea/MelodyRabbit/GUI/image/A.png";
        rutaImages[10] = "/co/edu/udea/MelodyRabbit/GUI/image/A#.png";
        rutaImages[11] = "/co/edu/udea/MelodyRabbit/GUI/image/B.png";
        //

//        escala.setTonalidad(9, false); // tonalidad,mayor primer parametro nota de 0 a 12, segundo true si es mayor false si es menor
//        this.setNumeroNotas(3);        // numeroNotas this.entraBpm();
//        this.setBpm(200); //bpm
        
        
                ctrl.escalaSetTonalidad(tonalidad, mayor); // tonalidad,mayor primer parametro nota de 0 a 12, segundo true si es mayor false si es menor
                this.setNumeroNotas(numeroNotas);        // numeroNotas this.entraBpm();
                this.setBpm(bpm); //bpm
                nivelJ = lvl;
//                puntosS = ps;
//                puntosR = pr;
                
        //
        
      ctrl.crearPuntaje(ps, pr);

        this.timer();
        this.setVisible(true);
        
         tabla.setSize(250, 180);
        tabla.setLocation(50, 250);
        tabla.setVisible(true);
        this.add(tabla);

        info.setSize(250, 180);
        info.setLocation(anchoVentana - 300, 250);
        info.setVisible(true);
        info.setNombre(nombre);
        info.setEscala(ctrl.escalaTraducirNumeroACaracter(tonalidad), mayor);
        info.setBpm(BPM);
        this.add(info);

        lblconejo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udea/MelodyRabbit/GUI/image/sr.gif")));
        lblconejo.setLocation(0,190);
        lblconejo.setSize(110, 110);
        this.add(lblconejo);

       ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/co/edu/udea/MelodyRabbit/GUI/image/musicalTree.jpeg"));
        lblarbol.setIcon(imagenFondo);
        lblarbol.setSize(imagenFondo.getIconWidth(), imagenFondo.getIconHeight());
        this.add(lblarbol);

    }

//    public void entraBpm(int bpm){ 
//        
//    }
    private void timer() {
        timer = new Timer();

        final TimerTask task = new TimerTask() {
            private int time = 0;

            @Override
            public void run() {
                if (!pausa) {
                    for (int i = 0; i < b.length; i++) {

                        if (b[i].getLocation().y < altoVentana + 100) {
                            b[i].setLocation(b[i].getLocation().x, b[i].getLocation().y + dirY);

                        } else {

                            cambiarNotas();
                            for (int j = 0; j < b.length; j++) {
                                b[j].setLocation(b[j].getLocation().x, -100);
                                b[j].setVisible(true);
                            }
                            sonando = false;

                        }

                        if (b[i].getBounds().intersects(lblconejo.getBounds())) {

                            tocarNota(i);

                        }

                    }
                }
            }

        };

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                timer.schedule(task, 0, milisegundos);  //50 = 20 fps
            }
        });
        t.start();

    }

    private void tocarNota(final int x) {
        
        if(!ctrl.puntajeGetNotead().contains(Integer.parseInt(b[x].getText()))){
            b[x].setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udea/MelodyRabbit/GUI/image/fire.gif")));
        }else{
            b[x].setVisible(false);
        }
        b[x].getText();
        mostrarPuntaje();
        if (!sonando) {
            
            ctrl.puntajePonerPuntaje(Integer.parseInt(b[x].getText()), ctrl.getEscala());

            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    ctrl.melodiaSonar(ctrl.escalaTraducirNumeroACaracter(Integer.parseInt(b[x].getText())));
                }
            });
            t.start();

            sonando = true;
        }
    }

    public void setBpm(int bpm) {
        //dirY= ((bpm -(bpm/6))/2);
        BPM = bpm;
        float b = bpm, d;
        d = ((((altoVentana + 200) / 20) * (b / 60)) / 4);
        dirY = (int) d;
    }

    private void mostrarPuntaje() {

        tabla.setPuntaje(ctrl.puntajeGetPuntaje());
        tabla.setCombo(ctrl.puntajeGetCombo());
        tabla.setMalas(ctrl.puntajeGetMalasSeguidas());
        tabla.setNivel(nivelJ);
        
        boolean gana = false;
        
        switch(nivelJ){
            case 1:
                if(ctrl.puntajeGetPuntaje()> 5000) gana=true;
                break;
            case 2:
                if(ctrl.puntajeGetPuntaje()> 10000) gana=true;
                break;               
            case 3:
                if(ctrl.puntajeGetPuntaje()> 15000) gana=true;
                break;
  
            
        }
        
        if(ctrl.puntajeGetCombo()>=15 || gana){
            timer.cancel();
            this.dispose();
           
            Victory vi = new Victory();
            vi.setVisible(true);
            
        }
        
        if(ctrl.puntajeGetMalasSeguidas()>=10 || ctrl.puntajeGetPuntaje()<0){
            timer.cancel();
            this.dispose();
            GameOver go = new GameOver();
            go.setVisible(true);
        }

    }

    private void cambiarNotas() {
        int posicionNotacorrecta = (int) (Math.random() * numeroNotas);
        for (int i = 0; i < b.length; i++) {
            if (i != posicionNotacorrecta) {
                int notaInc = ctrl.escalaGetNotaIncorrectaRandom();
                String ruta = rutaImages[ctrl.escalaGetNoEscala()[notaInc]];
                b[i].setIcon(new javax.swing.ImageIcon(getClass().getResource(ruta)));
                b[i].setText("" + ctrl.escalaGetNoEscala()[notaInc]); 
            } else {
                int nota = ctrl.escalaGetNotaRandom();
                while (ctrl.escalaGetTonalidad() && (nota == 3 || nota == 6)) {  //hace que sea pentatonica la escala.
                    nota = ctrl.escalaGetNotaRandom();
                } 
                    while(!ctrl.escalaGetTonalidad() && (nota == 1 || nota == 5) ){
                        nota = ctrl.escalaGetNotaRandom();
                    }
                String ruta = rutaImages[ctrl.escalaGetEscala()[nota]];
                b[i].setIcon(new javax.swing.ImageIcon(getClass().getResource(ruta)));
                b[i].setText("" + ctrl.escalaGetEscala()[nota]);
            }

        }
    }

    private void iniciarNotas(int n) {
        b = new JLabel[n];
        b[0] = new JLabel();
        b[0].setSize(x, x);
        b[0].setLocation(this.getSize().width / 2 - (((x * n) + (d * (n - 1))) / 2), b[0].getLocation().y);
        b[0].setVisible(true);
        b[0].setText("" + ctrl.escalaGetEscala()[0]);

        b[0].setIcon(new javax.swing.ImageIcon(getClass().getResource(rutaImages[Integer.parseInt(b[0].getText())])));
        this.add(b[0]);
        this.repaint();

        for (int i = 1; i < b.length; i++) {

            b[i] = new JLabel();
            b[i].setSize(x, x);
            b[i].setLocation(b[i - 1].getLocation().x + d + x, b[i].getLocation().y);
            b[i].setVisible(true);
            b[i].setText("" + ctrl.escalaGetEscala()[0]);

            b[i].setIcon(new javax.swing.ImageIcon(getClass().getResource(rutaImages[Integer.parseInt(b[i].getText())])));
            this.add(b[i]);
            this.repaint();

        }

    }

    private void centrarNotas() {
        b[0].setLocation(this.getSize().width / 2 - (((x * b.length) + (d * (b.length - 1))) / 2), b[0].getLocation().y);
        for (int i = 1; i < b.length; i++) {
            b[i].setLocation(b[i - 1].getLocation().x + d + x, b[i].getLocation().y);
        }
    }

    private void limpiarNotas() {
        try {
            for (int i = 0; i < b.length; i++) {

                this.remove(b[i]);
            }
        } catch (Exception e) {

        }
    }

    public void setNumeroNotas(int n) {
        numeroNotas = n;
        limpiarNotas();
        iniciarNotas(n);

    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1024, 768));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }

            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        getContentPane().setLayout(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (!pausa) {
            if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
                lblconejo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udea/MelodyRabbit/GUI/image/rr.gif")));
                lblconejo.setLocation(lblconejo.getLocation().x + velocidad, lblconejo.getLocation().y);

                if (lblconejo.getLocation().x + lblconejo.getWidth() > this.getWidth()) {
                    lblconejo.setLocation(0, lblconejo.getY());
                }
            } else if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
                lblconejo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udea/MelodyRabbit/GUI/image/rl.gif")));
                lblconejo.setLocation(lblconejo.getLocation().x - velocidad, lblconejo.getLocation().y);
                if (lblconejo.getLocation().x <= 0) {

                    lblconejo.setLocation(this.getWidth() - lblconejo.getWidth(), lblconejo.getLocation().y);
                } else {

                }
            }
        }
        if (evt.getKeyCode() == KeyEvent.VK_P) {
            pausarJuego();
        }

    }//GEN-LAST:event_formKeyPressed

    private void pausarJuego(){
         //pausa = !pausa;
         miObservador.setContinuar();
         //pausaMen.setVisible(!pausaMen.isVisible());
    }
    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased

        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            lblconejo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udea/MelodyRabbit/GUI/image/sr.gif")));

        } else if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            lblconejo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udea/MelodyRabbit/GUI/image/sl.gif")));
        } // TODO add your handling code here:

    }//GEN-LAST:event_formKeyReleased

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        anchoVentana = this.getSize().width;
        altoVentana = this.getSize().height;
        lblconejo.setLocation(lblconejo.getX(), this.getHeight() - lblconejo.getHeight() - 60);
        setBpm(BPM);
        centrarNotas();
// TODO add your handling code here:
    }//GEN-LAST:event_formComponentResized

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object o1) {
        pausa = !pausa;
        
        if(miObservador.getMenu()){
            Menu menu = Menu.getInstance();
            menu.getInstance().setVisible(true);
            this.dispose();
            timer.cancel();
            miObservador.setMenuManual(false);
        }
    }
}
