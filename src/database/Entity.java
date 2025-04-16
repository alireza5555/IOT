package database;

public abstract class Entity {
    private enum Status{
        ON,
        OFF
    }

    private enum Protocol{
        Wifi,
        Bluetooth
    }

    private Protocol protocol;
    private Status status;
    private int temperature;
    private int brightness;
    private String name;

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setTemperature(int temperature){
        this.temperature = temperature;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
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

    public int getTemperature(){
        return temperature;
    }

    public int getBrightness() {
        return brightness;
    }

    public String getName() {
        return name;
    }

    public Protocol getProtocol() {
        return protocol;
    }
}
