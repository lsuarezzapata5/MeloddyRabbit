/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.MelodyRabbit.Logica;

import java.util.ArrayList;

/**
 *
 * @author luisa
 */
public class Puntaje {

    public Puntaje(int puntosS, int puntosR) {
        this.puntosS = puntosS;
        this.puntosR = puntosR;
    }

    private int puntaje = 100;
    private int combo = 1;
    private int malasSeguidas = 0;
    private int puntosS,puntosR;
 

    private ArrayList notead = new ArrayList();

    public ArrayList getNotead() {
        return notead;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getCombo() {
        return combo;
    }

    public int getMalasSeguidas() {
        return malasSeguidas;
    }

    public void ponerPuntaje(int nota, Escala escala) {
        notaEnArrayList(escala);
        if (notead.contains(nota)) {
            puntaje = puntaje + puntosS * combo;
            combo++;
            malasSeguidas = 0;
        } else {
            puntaje = puntaje - puntosR;
            combo = 0;
            malasSeguidas++;
        }

    }

    private void notaEnArrayList(Escala escala) {
        for (int k = 0; k < escala.getEscala().length; k++) {
            notead.add(escala.getEscala()[k]);
        }
    }

    public void setSize(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setLocation(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPuntaje(int puntaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setCombo(int combo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setMalas(int malasSeguidas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
