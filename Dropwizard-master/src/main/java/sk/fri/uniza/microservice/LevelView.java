/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.fri.uniza.microservice;

import io.dropwizard.views.View;
import java.util.List;


public class LevelView extends View {

    private Level level;
    private List<Level> listLevel;

    public Level getLevel() {
        return level;
    }

    public List<Level> getListLevel() {
        return listLevel;
    }

    /**
     * zobrazenie jednej hodnoty na stranke
     * @param person 
     */
    public LevelView(Level person) {
        super("level.ftl");
        this.level = person;
    }
    
    public LevelView() {
        super("level_1.ftl");
    }

    /**
     * zobrazenie listu všetkých hodnot na stranke
     * @param listLevel 
     */
    public LevelView(List<Level> listLevel) {
        super("level_1.ftl");
        this.listLevel = listLevel;
    }

    
    
    
    
}
