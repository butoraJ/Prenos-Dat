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
public class CheckLoginView extends View{
    
    /**
     * konštruktor otvára stranku checkLogin.ftl
     */
    public CheckLoginView(){
        super("checkLogin.ftl");
    }
    
    /**
     * konštruktor otvára stranku sing.ftl
     * @param c 
     */
    public CheckLoginView(int c){
        super("sign.ftl");
    }
    
}
