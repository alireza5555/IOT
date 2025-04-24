package database;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
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
            if(temp.getName().equals(name)){ return temp;}
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

    public void removeDevice( String name)throws NoSuchElementException{
        for ( int i = 0 ; i < deviceList.size() ; i++){
            if(deviceList.get(i).getName().equals(name)){
                deviceList.remove(i);
                return;
            }
        }
        throw new NoSuchElementException("device not found");
    }

    public void getDeviceList (){
        for (Entity temp : deviceList) {
            System.out.println("Device name: " + temp.getName());
            System.out.println("Status: " + temp.getStatus());
            if(temp instanceof Light){
                System.out.println("Brightness: " + ((Light) temp).getBrightness());
            }
            else System.out.println("Temperature: " + ((Thermostat)temp).getTemperature());
            System.out.println("Protocol: " + temp.getProtocol());
        }
    }

    public void addRule (String name , String timeStr , String action) throws Exception {
        Entity temp = findDevice(name);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time =  LocalTime.parse(timeStr , formatter);
        Entity.Rule rule = new Entity.Rule(time , action);
        temp.rules.add(rule);

    }



}
