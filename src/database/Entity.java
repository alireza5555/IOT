package database;

public abstract class Entity {

    enum Status{
        ON,
        OFF
    }

    enum Protocol{
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
}
