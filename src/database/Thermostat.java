package database;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Thermostat extends Entity  {

    public Thermostat (String name , Protocol protocol){
        this.setName(name);
        this.setProtocol(protocol);
        this.setTemperature(20);
        this.setStatus(Status.OFF);
    }

    private int temperature;

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }



}
