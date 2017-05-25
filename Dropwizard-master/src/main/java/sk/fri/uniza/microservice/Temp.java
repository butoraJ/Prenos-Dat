/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.fri.uniza.microservice;

/**
 *
 * @author hudik1
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.validator.constraints.Length;

@Entity
public class Temp {
    
    @Id
    @GeneratedValue
    private long id;

    @Length(max = 20)
    private String content;

    public Temp() {
        // Jackson deserialization
    }

    /**
     * konstruktor vytvorí objekt s ID a hodnotou
     * @param id
     * @param content 
     */
    public Temp(long id, String content) {
        this.id = id;
        this.content = content;
    }

    /**
     * getter na ziskanie ID
     * @return 
     */
    @JsonProperty
    public long getId() {
        return id;
    }

    /**
     * geter na ziskane hodnoty
     * @return 
     */
    @JsonProperty
    public String getContent() {
        return content;
    }

    /**
     * setter na nastavenie hodnoty
     * @param content 
     */
    public void setContent(String content) {
        this.content = content;
    }
    
}
