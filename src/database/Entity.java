package database;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class Entity implements Cloneable {

    public enum Status{
        ON,
        OFF
    }

    public enum Protocol{
        Wifi,
        Bluetooth
    }

    public  ArrayList <Rule> rules = new ArrayList<>();

    private Protocol protocol;
    private Status status;
    private String name;

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProtocol(Protocol protocol) {
        if(protocol instanceof Protocol)

        this.protocol = protocol;
    }

    public Status getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    @Override
    public Entity clone() {
        try {
            return (Entity) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    static class Rule{

        public Rule(LocalTime time , String action){
            this.time = time;
            status = Status.valueOf(action);
        }

        LocalTime time;
        Status status;
    }
}
