/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.MelodyRabbit.Logica;

/**
 *
 * @author luisa
 */
public class Juego {

    private NivelStateInterface stateNivel;
    
  
    
    public Juego() {
        stateNivel = new Nivel1State();
    }

    public void Nivel1() {
        stateNivel = new Nivel1State();
    }

    public void Nivel2() {
        stateNivel = new Nivel2State();
    }

    public void Nivel3() {
        stateNivel = new Nivel3State();
    }

    public void construir(){
        stateNivel.construir();
    }
    
    public int getVelocidadCancion(int numeroCancion) {
        return stateNivel.getVelocidadCancion(numeroCancion);
    }

    public int getRecordPuntuacion() {
        return stateNivel.getRecordPuntuacion();
    }

    public void setRecordPuntuacion(int recordPuntuacion) {
        stateNivel.setRecordPuntuacion(recordPuntuacion);
    }

    public String getRecordJugador() {
        return stateNivel.getRecordJugador();
    }

    public void setRecordJugador(String recordJugador) {
        stateNivel.setRecordJugador(recordJugador);
    }

    public int getNumeroNotas() {
        return stateNivel.getNumeroNotas();
    }

    public int getPuntosASumar() {
        return stateNivel.getPuntosASumar();
    }

    public int getPuntosARestar() {
        return stateNivel.getPuntosARestar();
    }

    public int getNumeroCancionesPorNivel() {
        return stateNivel.getNumeroCancionesPorNivel();
    }

    public void setNumeroCancionesPorNivel(int numero) {
        stateNivel.setNumeroCancionesPorNivel(numero);
    }
    
     public Cancion getCancion(int id){
         return stateNivel.getCancion(id);
     }

}
