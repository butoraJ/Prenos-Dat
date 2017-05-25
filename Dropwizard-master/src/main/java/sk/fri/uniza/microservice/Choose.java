/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.fri.uniza.microservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Jaroslav
 */
@Path("/choose")
@Produces(MediaType.TEXT_HTML)
public class Choose {
    
    /**
     * geter ktorý vráti konštruktor ktorý volá menu
     * @return 
     */
    @GET
    public ChooseView getStart(){
        return new ChooseView();
    }
    
}
