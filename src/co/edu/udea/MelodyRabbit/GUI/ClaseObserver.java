/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.MelodyRabbit.GUI;

import java.util.Observable;

/**
 *
 * @author Jeison
 */
public class ClaseObserver extends Observable {
    private boolean menu=false;
    
    public ClaseObserver(){
        
    }
    
    public void setMenu(){
        menu = true;
        setChanged();
        notifyObservers();
    }
    
    public void setMenuManual(boolean m){
        menu = m;
    }
    
    public boolean getMenu(){
        return menu;
    }
    
    public void setContinuar() {
                //this.continuar = p;
		setChanged();
                notifyObservers();
	}
}
