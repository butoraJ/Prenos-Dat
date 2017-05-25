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
@Path("/login")
@Produces(MediaType.TEXT_HTML)
public class CheckLogin {
    
    /**
     * geter ktorý vráty konštruktor pre okno loginu
     * @return 
     */
    @GET
    public CheckLoginView getStart(){
        return new CheckLoginView();
    }
    
    /**
     * geter ktorý vráty konštruktor pre okno registrácie
     * @return 
     */
    @GET
    @Path("/sign")
    public CheckLoginView getSign(){
        return new CheckLoginView(5);
    }
    
}
