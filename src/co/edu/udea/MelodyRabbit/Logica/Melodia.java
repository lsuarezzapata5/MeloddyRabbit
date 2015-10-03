/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.MelodyRabbit.Logica;

import org.jfugue.*;

/**
 *
 * @author luisa
 */
public class Melodia {

    private static Player piano = new Player();

    public static Player getPiano() {
        return piano;
    }

    public  void sonar(String letra) {
        //Pattern nota = new Pattern(letra);
        final Pattern nota = new Pattern(letra);
        piano.play(nota);

    }
}
