/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.fri.uniza.microservice;

import io.dropwizard.views.View;
import java.util.List;

public class PressureView extends View {

    private Pressure pressure;
    private List<Pressure> listPressure;

    public Pressure getPressure() {
        return pressure;
    }

    public List<Pressure> getListPressure() {
        return listPressure;
    }

    /**
     * zobrazenie jednej hodnoty na stranke
     *
     * @param person
     */
    public PressureView(Pressure person) {
        super("pressure.ftl");
        this.pressure = person;
    }

    /**
     * zobrazenie listu hodnot na stranke
     *
     * @param listPressure
     */
    public PressureView(List<Pressure> listPressure) {
        super("pressure_1.ftl");
        this.listPressure = listPressure;
    }

}
