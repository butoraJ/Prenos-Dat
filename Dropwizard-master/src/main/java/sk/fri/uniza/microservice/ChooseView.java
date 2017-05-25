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
public class ChooseView extends View{
    
    /**
     * konštruktor ktorý otvorá stránku choose.ftl
     */
    public ChooseView(){
        super("choose.ftl");
    }
    
    
}
