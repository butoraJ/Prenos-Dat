/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.fri.uniza.microservice;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import javax.ws.rs.Consumes;
import org.hibernate.Session;

@Path("/add")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }
    
    /**
     * metoda zabezpecuje pridanie novej teploty
     * @param input
     * @return 
     */
    @POST
    @Path("/temp")
    @Consumes(MediaType.APPLICATION_JSON)
    public Temp setTemp(Temp input) {

        Session session = HelloWorldApplication.buildSessionFactory.openSession();
        session.beginTransaction();
        session.save(input);
        session.getTransaction().commit();
        session.close();
        return input;
    }
    
    /**
     * metoda zabezpecuje pridanie noveho tlaku
     * @param input
     * @return 
     */
    @POST
    @Path("/pressure")
    @Consumes(MediaType.APPLICATION_JSON)
    public Pressure setPressure(Pressure input) {

        Session session = HelloWorldApplication.buildSessionFactory.openSession();
        session.beginTransaction();
        session.save(input);
        session.getTransaction().commit();
        session.close();
        return input;
    }
    
    /**
     * metoda zabezpecuje pridanie novej hladiny
     * @param input
     * @return 
     */
    @POST
    @Path("/level")
    @Consumes(MediaType.APPLICATION_JSON)
    public Level setLevel(Level input) {

        Session session = HelloWorldApplication.buildSessionFactory.openSession();
        session.beginTransaction();
        session.save(input);
        session.getTransaction().commit();
        session.close();
        return input;
    }
    
    /**
     * metoda zabezpecuje pridanie noveho uzivatela
     * @param input
     * @return 
     */
    @POST
    @Path("/user")
    @Consumes(MediaType.APPLICATION_JSON)
    public User setUser(User input) {

        Session session = HelloWorldApplication.buildSessionFactory.openSession();
        session.beginTransaction();
        session.save(input);
        session.getTransaction().commit();
        session.close();
        return input;
    }
    
   
}
