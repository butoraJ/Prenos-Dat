/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.fri.uniza.microservice;


import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.validator.constraints.Length;

@Entity
public class User {
    
    @Id
    @GeneratedValue
    private long id;

    @Length(max = 20)
    private String name;
    
    @Length(max = 20)
    private String password;

    public User() {
        // Jackson deserialization
    }

    /**
     * konstruktor vytvori objekt podla ID, mena a hesla
     * @param id
     * @param name
     * @param password 
     */
    public User(long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password= password;
    }

    /**
     * getter na ziskanie id
     * @return 
     */
    @JsonProperty
    public long getId() {
        return id;
    }

    /**
     * getter na ziskanie mena
     * @return 
     */
    @JsonProperty
    public String getName() {
        return name;
    }
    
    /**
     * getter na ziskanie hesla
     * @return 
     */
    @JsonProperty
    public String getPassword() {
        return password;
    }

    /**
     * setter na nastavenie ID
     * @param id 
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * setter na nastavenie mena
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setter na nastavenie hesla
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    

    
    
}
