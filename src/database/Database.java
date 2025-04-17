package database;
import java.util.*;

public class Database  {
    private static ArrayList <Entity> deviceList = new ArrayList<>();

    public static void addDevice(Entity entity) throws Exception {
        for (Entity temp : deviceList){
            if(temp.getName().equals(entity.getName())){
                throw new Exception("this name already exist.");
            }
        }
        deviceList.add(entity.clone());
    }

    public static Entity findDevice(String name ) throws Exception {
        for ( Entity temp : deviceList){
            if(temp.getName().equals(name)){ return temp.clone();}
        }
        throw new Exception("Device not found.");
    }

    public static void updateDevice(String name, String field , String newValue) throws Exception {
        Entity temp = findDevice(name);
        switch(field){
            case "status":
                try {
                    temp.setStatus(Entity.Status.valueOf(newValue));
                }
                catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }

            case "brightness":
                try {
                    ((Light)temp).setBrightness(Integer.parseInt(newValue));
                }
                catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }

            case "temperature":
                try {
                    ((Thermostat)temp).setTemperature(Integer.parseInt(newValue));
                }
                catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }


        }
    }

}
