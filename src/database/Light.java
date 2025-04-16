package database;

public class Light extends Entity {

    public Light (String name , int brightness , Protocol protocol){
        setName(name);
        setBrightness(brightness);
        setStatus(Status.OFF);
        setProtocol(protocol);

    }

    private int brightness;

    public void setBrightness(int brightness){
        this.brightness = brightness;
    }

    public int getBrightness(){
        return brightness;
    }
}
