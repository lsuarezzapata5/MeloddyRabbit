/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.MelodyRabbit.Logica;

import java.net.URL;

/**
 *
 * @author luisa
 */
public class Cancion {

    private int id;
    private int tonalidad;
    private int bpm;
    private boolean mayor;
    private String nombre;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isMayor() {
        return mayor;
    }

    public void setMayor(boolean mayor) {
        this.mayor = mayor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTonalidad(int tonalidad) {
        this.tonalidad = tonalidad;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public int getTonalidad() {
        return tonalidad;
    }

    public int getBpm() {
        return bpm;
    }

}
