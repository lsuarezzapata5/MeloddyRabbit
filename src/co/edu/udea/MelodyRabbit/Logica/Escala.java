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
public class Escala {

    private Juego nivel = new Juego();
    private int[] notasPertenecenEscala;
    private int[] notasNoPertenecenEscala;
    private Boolean tonalidadMayor;
    private int notaCorrectaRandom;
    private int notaIncorrectaRandom;

    public Boolean getTonalidad() {
        return tonalidadMayor;
    }
//
//    public void setTonalidad(Boolean tonalidad) {
//        this.tonalidadMayor = tonalidad;
//    }

    public int getNotaIncorrectaRandom() {
        notaIncorrectaRandom = (int) (Math.random() * notasNoPertenecenEscala.length);
        return this.notaIncorrectaRandom;
    }

    public void setNotaIncorrectaRandom(int notaIncorrectaRandom) {
        this.notaIncorrectaRandom = notaIncorrectaRandom;
    }

    public int[] getEscala() {
        return notasPertenecenEscala;
    }

    public void setEscala(int[] escala) {
        this.notasPertenecenEscala = escala;
    }

    public int[] getNoEscala() {
        return notasNoPertenecenEscala;
    }

    public void setNoEscala(int[] noEscala) {
        this.notasNoPertenecenEscala = noEscala;
    }

    public int getNotaRandom() {
        notaCorrectaRandom = (int) (Math.random() * notasPertenecenEscala.length);
        return this.notaCorrectaRandom;
    }

    public void setNotaRandom(int notaRandom) {
        this.notaCorrectaRandom = notaRandom;
    }

    private int[] calcularEscalaMayor(int raiz) {
        int[] notasPertenecenEscala = new int[7];
        notasPertenecenEscala[0] = raiz;
        for (int i = 1; i < 7; i++) {
            if (i != 3) {
                notasPertenecenEscala[i] = (notasPertenecenEscala[i - 1] + 2) % 12;
            } else {
                notasPertenecenEscala[i] = (notasPertenecenEscala[i - 1] + 1) % 12;
            }

        }

        notasNoPertenecenEscala = new int[5];
        notasNoPertenecenEscala[0] = raiz + 1;

        for (int i = 1; i < 5; i++) {
            if (i != 2) {
                notasNoPertenecenEscala[i] = (notasNoPertenecenEscala[i - 1] + 2) % 12;
            } else {
                notasNoPertenecenEscala[i] = (notasNoPertenecenEscala[i - 1] + 3) % 12;
            }

        }
        return notasPertenecenEscala;
    }

    private int[] calcularEscalaMenor(int raiz) {
        int[] notasPertenecenEscala = new int[7];
        //escala[0] = raiz;
        int[] escalaAux = calcularEscalaMayor((raiz + 3) % 12);
        for (int i = 0; i < 7; i++) {
            notasPertenecenEscala[i] = escalaAux[(i + 5) % 7];

        }

        notasNoPertenecenEscala = new int[5];
        notasNoPertenecenEscala[0] = raiz + 1;

        for (int i = 1; i < 5; i++) {
            if (i != 1 && i != 3) {
                notasNoPertenecenEscala[i] = (notasNoPertenecenEscala[i - 1] + 2) % 12;
            } else {
                notasNoPertenecenEscala[i] = (notasNoPertenecenEscala[i - 1] + 3) % 12;
            }

        }

        return notasPertenecenEscala;
    }

    public void setTonalidad(int tono, boolean mayor) {  //el tono es un numero de 0 a 11,  el segundo parametro si es true es natural si no pentatonica, el tecero si es mayor o menor.
        tonalidadMayor = mayor;
        if (mayor) {
            notasPertenecenEscala = new int[calcularEscalaMayor(tono).length];
            notasPertenecenEscala = calcularEscalaMayor(tono);
        } else {
            notasPertenecenEscala = new int[calcularEscalaMenor(tono).length];
            notasPertenecenEscala = calcularEscalaMenor(tono);
        }
    }

    public String traducirNumeroACaracter(int numero) {
        String nota = "";
        switch (numero) {
            case 0:
                nota = "C";
                break;
            case 1:
                nota = "C#";
                break;
            case 2:
                nota = "D";
                break;
            case 3:
                nota = "D#";
                break;
            case 4:
                nota = "E";
                break;
            case 5:
                nota = "F";
                break;
            case 6:
                nota = "F#";
                break;
            case 7:
                nota = "G";
                break;
            case 8:
                nota = "G#";
                break;
            case 9:
                nota = "A";
                break;
            case 10:
                nota = "A#";
                break;
            case 11:
                nota = "B";
                break;
        }
        return nota;

    }

}
