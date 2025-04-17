package database;

public abstract class Entity implements Cloneable {

    public enum Status{
        ON,
        OFF
    }

    public enum Protocol{
        Wifi,
        Bluetooth
    }

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
}
