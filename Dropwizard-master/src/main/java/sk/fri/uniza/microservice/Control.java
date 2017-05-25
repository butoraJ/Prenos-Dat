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
@Path("/control")
@Produces(MediaType.TEXT_HTML)
public class Control{
 
    /**
     * geter ktorý vráti konstruktor pre otvorenie menu teploty
     * @return 
     */
    @GET
    @Path("/temp")
    public ControlView getTemp(){
        return new ControlView();
    }
    
    /**
     * geter ktorý vráti konstruktor pre otvorenie menu tlaku
     * @return 
     */
    @GET
    @Path("/pressure")
    public ControlView getPressure(){
        return new ControlView(5);
    }
    
    /**
     * geter ktorý vráti konstruktor pre otvorenie menu hladiny
     * @return 
     */
    @GET
    @Path("/level")
    public ControlView getLevel(){
        return new ControlView("5");
    }
    
}
