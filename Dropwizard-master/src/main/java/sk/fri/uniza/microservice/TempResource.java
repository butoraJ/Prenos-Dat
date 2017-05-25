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

@Path("/temp")
@Produces(MediaType.TEXT_HTML)
public class TempResource {

    /**
     * získanie listu všetkých hodnot z tabulky
     *
     * @param name
     * @return
     */
    @GET
    public TempView getTemp(@QueryParam("name") Optional<String> name) {
        Session session = HelloWorldApplication.buildSessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Temp");
        List<Temp> list = query.list();

        session.getTransaction().commit();
        session.close();

        return new TempView(list);
    }

    /**
     * získanie jednej hodnoty podla ID z tabulky
     *
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    public TempView getTemp(@PathParam("id") String id) {
        Session session = HelloWorldApplication.buildSessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();
        Query query = session.createQuery("from Temp where id=" + id);
        Temp uniqueResult = (Temp) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        if (uniqueResult == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).build());
        }
        return new TempView(uniqueResult);
    }

    /**
     * vymazanie hodnoty podla ID z tabulky
     *
     * @param id
     * @return
     */
    @GET
    @Path("/delete/{id}")
    public Response deleteTemp(@PathParam("id") String id) {
        Session session = HelloWorldApplication.buildSessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();
        Query query = session.createQuery("DELETE from Temp where id=" + id);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        String url = "http://localhost:8080/temp/";
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
    public Response deleteTemp(@QueryParam("name") Optional<String> name) {
        Session session = HelloWorldApplication.buildSessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("DELETE from Temp");

        query.executeUpdate();

        session.getTransaction().commit();
        session.close();

        String url = "http://localhost:8080/temp/";
        URI uri = UriBuilder.fromUri(url).build();
        return Response.seeOther(uri).build();
    }

    /**
     * zadanie novej hodnoty do tabulky
     *
     * @param temp
     * @return
     */
    @POST
    @Path("/new")
    public Response newTemp(@FormParam("temp") String temp) {
        Session session = HelloWorldApplication.buildSessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();
        Temp input = new Temp(1, temp);
        session.save(input);
        session.getTransaction().commit();
        long newId = input.getId();
        session.close();
        String url = "http://localhost:8080/temp/" + newId;
        URI uri = UriBuilder.fromUri(url).build();
        return Response.seeOther(uri).build();
    }

    /**
     * aktualizácia hodnoty podla ID v tabulke
     *
     * @param id
     * @param temp
     * @return
     */
    @POST
    @Path("/up")
    public Response upTemp(@FormParam("id") long id, @FormParam("temp") String temp) {
        Session session = HelloWorldApplication.buildSessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();
        Temp input = new Temp(id, temp);
        session.update(input);
        session.getTransaction().commit();
        session.close();
        String url = "http://localhost:8080/temp/" + id;
        URI uri = UriBuilder.fromUri(url).build();
        return Response.seeOther(uri).build();
    }

}
