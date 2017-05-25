/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.fri.uniza.microservice;

import com.codahale.metrics.annotation.Timed;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


@Path("/level")
@Produces(MediaType.TEXT_HTML)
public class LevelResource {

    /**
     * získanie listu všetkých hodnot z tabulky
     *
     * @param name
     * @return
     */
    @GET
    @Timed
    public LevelView getLevel(@QueryParam("name") Optional<String> name) {
        Session session = HelloWorldApplication.buildSessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Level");
        List<Level> list = query.list();

        session.getTransaction().commit();
        session.close();

        return new LevelView(list);
    }

    /**
     * získanie jednej hodnoty podla ID z tabulky
     *
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    @Timed
    public LevelView getLevel(@PathParam("id") String id) {
        Session session = HelloWorldApplication.buildSessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();
        Query query = session.createQuery("from Level where id=" + id);
        Level uniqueResult = (Level) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        if (uniqueResult == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).build());
        }
        return new LevelView(uniqueResult);
    }

    /**
     * vymazanie hodnoty podla ID z tabulky
     *
     * @param id
     * @return
     */
    @GET
    @Path("/delete/{id}")
    @Timed
    public Response deletePressure(@PathParam("id") String id) {
        Session session = HelloWorldApplication.buildSessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();
        Query query = session.createQuery("DELETE from Level where id=" + id);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        String url = "http://localhost:8080/level/";
        URI uri = UriBuilder.fromUri(url).build();
        return Response.seeOther(uri).build();

    }

    /**
     * vymazanie všetkých hodnôt z tabulky
     *
     * @param name
     * @return
     */
    @GET
    @Path("/delete")
    @Timed
    public Response deleteTemp(@QueryParam("name") Optional<String> name) {
        Session session = HelloWorldApplication.buildSessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("DELETE from Level");

        query.executeUpdate();

        session.getTransaction().commit();
        session.close();

        String url = "http://localhost:8080/level/";
        URI uri = UriBuilder.fromUri(url).build();
        return Response.seeOther(uri).build();
    }

    /**
     * zadanie novej hodnoty do tabulky
     *
     * @param level
     * @return
     */
    @POST
    @Path("/new")
    public Response newLevel(@FormParam("level") String level) {
        Session session = HelloWorldApplication.buildSessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();
        Level input = new Level(1, level);
        session.save(input);
        session.getTransaction().commit();
        long newId = input.getId();
        session.close();
        String url = "http://localhost:8080/level/" + newId;
        URI uri = UriBuilder.fromUri(url).build();
        return Response.seeOther(uri).build();
    }

    /**
     * aktualizácia hodnoty podla ID v tabulke
     *
     * @param id
     * @param level
     * @return
     */
    @POST
    @Path("/up")
    public Response upLevel(@FormParam("id") long id, @FormParam("level") String level) {
        Session session = HelloWorldApplication.buildSessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();
        Level input = new Level(id, level);
        session.update(input);
        session.getTransaction().commit();
        session.close();
        String url = "http://localhost:8080/level/" + id;
        URI uri = UriBuilder.fromUri(url).build();
        return Response.seeOther(uri).build();
    }
}
