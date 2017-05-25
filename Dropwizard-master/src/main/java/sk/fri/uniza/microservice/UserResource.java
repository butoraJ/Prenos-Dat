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

@Path("/user")
@Produces(MediaType.TEXT_HTML)
public class UserResource {

    /**
     * získanie listu všetkých hodnot z tabulky
     *
     * @param name
     * @return
     */
    @GET
    @Timed
    public UserView getUsers(@QueryParam("name") Optional<String> name) {
        Session session = HelloWorldApplication.buildSessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from User");
        List<User> list = query.list();

        session.getTransaction().commit();
        session.close();

        return new UserView(list);
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
    public UserView getUser(@PathParam("id") String id) {
        Session session = HelloWorldApplication.buildSessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();
        Query query = session.createQuery("from User where id=" + id);
        User uniqueResult = (User) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        if (uniqueResult == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).build());
        }
        return new UserView(uniqueResult);
    }

    /**
     * aktualizácia uzivatela podla ID v tabulke
     *
     * @param id
     * @param name
     * @param pswNew
     * @return
     */
    @POST
    @Path("/up")
    public Response upUser(@FormParam("id") long id, @FormParam("name") String name, @FormParam("pswNew") String pswNew) {
        Session session = HelloWorldApplication.buildSessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();
        User in = new User(id, name, pswNew);
        session.update(in);
        session.getTransaction().commit();
        session.close();
        URI uri = UriBuilder.fromUri("http://localhost:8080/user").build();
        return Response.seeOther(uri).build();
    }

    /**
     * prihlasenie sa uzivatela, porovnava zadane parametre z parametramy z
     * tabulky
     *
     * @param name
     * @param psw
     * @return
     */
    @POST
    @Path("/login")
    public Response makeLogin(@FormParam("name") String name, @FormParam("psw") String psw) {
        Session session = HelloWorldApplication.buildSessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from User");
        List<User> list = query.list();

        for (User user : list) {
            if (user.getName().equals(name) && user.getPassword().equals(psw)) {
                URI uri = UriBuilder.fromUri("http://localhost:8080/choose").build();
                return Response.seeOther(uri).build();
            }
        }

        session.getTransaction().commit();
        session.close();

        URI uri = UriBuilder.fromUri("http://localhost:8080/login").build();
        return Response.seeOther(uri).build();
    }

    /**
     * registraciu noveho uzivatela, kontoluje zadane parametre ci sa zhoduju
     * hesla a ci uzivatel uz neexistuh´je v tabulke
     *
     * @param name
     * @param psw
     * @param psw2
     * @return
     */
    @POST
    @Path("/sign")
    public Response makeSign(@FormParam("name") String name, @FormParam("psw") String psw, @FormParam("psw2") String psw2) {
        Session session = HelloWorldApplication.buildSessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from User");
        List<User> list = query.list();

        for (User user : list) {
            if (user.getName().equals(name)) {
                User input = new User(1, name, psw);
                session.getTransaction().commit();
                session.close();
                URI uri = UriBuilder.fromUri("http://localhost:8080/login/sign").build();
                return Response.seeOther(uri).build();
            }
        }

        if (psw2.equals(psw)) {
            User input = new User(1, name, psw);
            session.save(input);
            session.getTransaction().commit();
            session.close();

            URI uri = UriBuilder.fromUri("http://localhost:8080/login").build();
            return Response.seeOther(uri).build();
        }

        URI uri = UriBuilder.fromUri("http://localhost:8080/login/sign").build();
        return Response.seeOther(uri).build();
    }

}
