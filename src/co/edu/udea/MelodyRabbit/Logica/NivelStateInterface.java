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
public interface NivelStateInterface {
    
    
    public void construir();
    
    public Cancion getCancion(int id);
    
    public void setCancion();
    
    public int getVelocidadCancion(int numeroCancion);

    public int getRecordPuntuacion();

    public void setRecordPuntuacion(int recordPuntuacion);

    public String getRecordJugador();

    public void setRecordJugador(String recordJugador);

    public int getNumeroNotas();

    public int getPuntosASumar();

    public int getPuntosARestar();

    public int getNumeroCancionesPorNivel();

    public void setNumeroCancionesPorNivel(int numero);

}
