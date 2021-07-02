/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jam6m4finalprojects21;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author jacobmcintosh
 * 
 * 
 *  This code was referenced using: 
 *      1. https://www.oracle.com/technical-resources/articles/javase/mvc.html
 */
public abstract class AbstractModel {
    
    protected PropertyChangeSupport propertyChangeSupport;
    
    public AbstractModel(){
        propertyChangeSupport = new PropertyChangeSupport(this);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener){
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener){
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    
    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue){
        propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }
    
    
    
    
    
    
}
