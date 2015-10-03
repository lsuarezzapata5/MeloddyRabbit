/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.MelodyRabbit.Logica;

import java.util.ArrayList;

/**
 *
 * @author luisa
 */
public class Controlador {

    private Juego juego = new Juego();
    private Cancion cancion = new Cancion();
    private Jugador jugador = new Jugador();
    private Escala escala = new Escala();
    private Melodia melodia = new Melodia();
    private Puntaje puntaje;

    public int puntajeGetPuntaje() {
        return puntaje.getPuntaje();
    }

    public int puntajeGetCombo() {
        return puntaje.getCombo();
    }

    public int puntajeGetMalasSeguidas() {
        return puntaje.getMalasSeguidas();
    }
    
   public void puntajePonerPuntaje(int nota, Escala escala) {
        puntaje.ponerPuntaje(nota, escala);
   }
   
   public ArrayList puntajeGetNotead() {
       return puntaje.getNotead();
   }
   public void crearPuntaje(int m, int n){
        puntaje = new Puntaje(m, n);
   } 
     
   public  void melodiaSonar(String letra) {
         melodia.sonar(letra);
     }
    
      public int[] escalaGetEscala(){
          return escala.getEscala();
      }

     public Boolean escalaGetTonalidad() {
         return escala.getTonalidad();
     }
    public int escalaGetNotaRandom(){
        return escala.getNotaRandom();
    }
     public int[] escalaGetNoEscala() {
         return escala.getNoEscala();
     }
   public int escalaGetNotaIncorrectaRandom(){
       return escala.getNotaIncorrectaRandom();
   }
    
    public Escala getEscala() {
        return escala;
    }
    
    public void escalaSetTonalidad(int tono, boolean mayor) {
         escala.setTonalidad(tono, mayor);
    }
     public String escalaTraducirNumeroACaracter(int numero) {
         return escala.traducirNumeroACaracter(numero);
     } 
    public void jugadorSetNombre(String n){
         jugador.setNombre(n);
    }
    public int juegoGetRecordPuntuacion() {
        return juego.getRecordPuntuacion();
    }

    public int juegoGetPuntosASumar() {
        return juego.getPuntosASumar();
    }
    
    
        

    public void juegoNivel1() {
        juego.Nivel1();
    }

    public void juegoNivel2() {
        juego.Nivel2();
    }

    public void juegoNivel3() {
        juego.Nivel3();
    }

    public void juegoConstruir() {
        juego.construir();
    }

    public int juegoGetNumeroNotas() {
        return juego.getNumeroNotas();
    }

    public int juegoGetPuntosARestar() {
        return juego.getPuntosARestar();
    }

     public Cancion juegoGetCancion(int c){
        return juego.getCancion(c);
    }
     
     public String cancionGetUrl() {
        return cancion.getUrl();
    }
 
    
}
