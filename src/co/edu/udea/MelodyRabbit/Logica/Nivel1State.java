/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.MelodyRabbit.Logica;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisa
 */
public class Nivel1State implements NivelStateInterface {

    private int numeroCanciones = 2;
    private int numeroNotas = 3;
    private int recordPuntuacion = 0;
    private String recordJugador = "";
//    int velocidad = 0;
    private Cancion[] cancionesNivel = new Cancion[numeroCanciones];
    private int puntosASumar;
    private int puntosARestar;
//    int velocidadCancion;
//   Cancion cancion=new Cancion();

    public void construir(){
        cancionesNivel[0] = new Cancion();
        cancionesNivel[0].setNombre("Gary Moore style (Am)");
        cancionesNivel[0].setBpm(60);
        cancionesNivel[0].setTonalidad(9);
        cancionesNivel[0].setMayor(false);
        cancionesNivel[0].setUrl("https://www.youtube.com/watch?v=2ORJxAJHQ5s");


        cancionesNivel[1] = new Cancion();
        cancionesNivel[1].setNombre("Minor blues (Am)");
        cancionesNivel[1].setBpm(60);
        cancionesNivel[1].setTonalidad(9);
        cancionesNivel[1].setMayor(false);
        cancionesNivel[1].setUrl("https://www.youtube.com/watch?v=amiubo0JpTU");
  
   
    }
    
    @Override
    public int getVelocidadCancion(int numeroCancion) {
        for (int i = 0; i < numeroCanciones; i++) {
            if (cancionesNivel[i].getId() == numeroCancion) {
                return cancionesNivel[i].getBpm();
            }
        }
        return 0;

    }

    @Override
    public int getRecordPuntuacion() {
        return recordPuntuacion = 1000;
    }

    @Override
    public void setRecordPuntuacion(int record) {
        recordPuntuacion = record;
    }

    @Override
    public void setRecordJugador(String recordJugador) {
        this.recordJugador = recordJugador;
    }

    @Override
    public String getRecordJugador() {
        recordJugador = "Nadie";
        return recordJugador;
    }

    @Override
    public int getNumeroNotas() {
        numeroNotas = 3;
        return numeroNotas;

    }

    @Override
    public int getPuntosASumar() {
        puntosASumar = 30;
        return puntosASumar;
    }

    @Override
    public int getPuntosARestar() {
        puntosARestar = 20;
        return puntosARestar;
    }

    @Override
    public int getNumeroCancionesPorNivel() {
        return numeroCanciones;
    }

    @Override
    public void setNumeroCancionesPorNivel(int numero) {
        numeroCanciones = numero;
    }

    @Override
    public Cancion getCancion(int id) {
        return cancionesNivel[id];
    }

    @Override
    public void setCancion() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
