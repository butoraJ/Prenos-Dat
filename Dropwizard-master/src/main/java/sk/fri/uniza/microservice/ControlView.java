/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.fri.uniza.microservice;

import io.dropwizard.views.View;

/**
 *
 * @author Jaroslav
 */
public class ControlView extends View{
    
    /**
     * konštruktor ktorý otvorí stránku temp_2.ftl
     */
    public ControlView(){
        super("temp_2.ftl");
    }
    
    /**
     *  konštruktor ktorý otvorí stránku pressure_2.ftl
     * @param c 
     */
    public ControlView(int c){
        super("pressure_2.ftl");
    }
    
    /**
     *  konštruktor ktorý otvorí stránku level_2.ftl
     * @param c 
     */
    public ControlView(String c){
        super("level_2.ftl");
    }
    
}
