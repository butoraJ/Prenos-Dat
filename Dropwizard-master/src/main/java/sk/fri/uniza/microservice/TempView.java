/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.fri.uniza.microservice;

import io.dropwizard.views.View;
import java.util.List;


public class TempView extends View {

    private Temp temp;
    private List<Temp> listTemp;

    public Temp getTemp() {
        return temp;
    }

    public List<Temp> getListTemp() {
        return listTemp;
    }

    /**
     * zobrazenie jednej honoty na stranke
     * @param person 
     */
    public TempView(Temp person) {
        super("temp.ftl");
        this.temp = person;
    }
    
    public TempView() {
        super("temp_1.ftl");
    }

    /**
     * zobrazenie listu hodnot na stranke
     * @param listSaying 
     */
    public TempView(List<Temp> listSaying) {
        super("temp_1.ftl");
        this.listTemp = listSaying;
    }

    
    
    
    
}
