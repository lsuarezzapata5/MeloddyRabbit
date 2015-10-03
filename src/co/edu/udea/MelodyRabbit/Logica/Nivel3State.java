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
public class Nivel3State implements NivelStateInterface {

    private int numeroCanciones = 2;
    private int numeroNotas = 7;
    private int recordPuntuacion = 0;
    private String recordJugador = "";

    private Cancion[] cancionesNivel = new Cancion[numeroCanciones];
    private int puntosASumar;
    private int puntosARestar;

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
        return recordPuntuacion = 2000;
    }

    @Override
    public void setRecordPuntuacion(int record) {
        recordPuntuacion = record;
    }

    @Override
    public String getRecordJugador() {
        return recordJugador;
    }

    @Override
    public int getNumeroNotas() {
        return numeroNotas = 7;
    }

    @Override
    public int getPuntosASumar() {
        return puntosASumar = 100;
    }

    @Override
    public int getPuntosARestar() {
        return puntosARestar = 80;
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
    public void setRecordJugador(String recordJugador) {
        this.recordJugador = recordJugador;
    }

      public Cancion getCancion(int id) {
        return cancionesNivel[id];
    }

    @Override
    public void setCancion() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void construir() {
        cancionesNivel[0] = new Cancion();
        cancionesNivel[0].setNombre("Rock (D)");
        cancionesNivel[0].setBpm(110);
        cancionesNivel[0].setTonalidad(2);
        cancionesNivel[0].setMayor(true);
        cancionesNivel[0].setUrl("https://www.youtube.com/watch?v=u2YhNHhnv7o");
        

        cancionesNivel[1] = new Cancion();
        cancionesNivel[1].setNombre("Modern(Fm)");
        cancionesNivel[1].setBpm(130);
        cancionesNivel[1].setTonalidad(5);
        cancionesNivel[1].setMayor(false);
        cancionesNivel[1].setUrl("https://www.youtube.com/watch?v=dKwCXV4ptSQ");
        
    }

}
