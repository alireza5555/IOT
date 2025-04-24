package database;
import com.sun.jdi.request.DuplicateRequestException;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;


public class Database  {
    private static ArrayList <Entity> deviceList = new ArrayList<>();
    private static Map <String,Entity.Rule> rules = new LinkedHashMap<>();

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
        if(!(action.equals(Entity.Status.OFF.toString())) && !(action.equals(Entity.Status.ON.toString())) ) throw new IllegalArgumentException("invalid action");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        Entity temp = findDevice(name);
        if(temp.getRule()!=null) throw new DuplicateRequestException("duplicate rule");
        LocalTime time =  LocalTime.parse(timeStr , formatter);
        try {
        }
        catch (Exception e){
            System.out.println("invalid time");
        }
        Entity.Rule rule = new Entity.Rule(time , action);
        temp.setRule(rule);
        rules.put(name,rule);

    }

    public void checkRule(String timeStr){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = null;
        try {
             time =  LocalTime.parse(timeStr , formatter);
        }
        catch (Exception e){
            System.out.println("invalid time");
        }

        for (Entity temp : deviceList){
            if(temp.getRule().time == time){
                temp.setStatus(temp.getRule().status);
            }
        }
    }

    public void showRules(){
        for (Map.Entry<String, Entity.Rule> temp: rules.entrySet()) {
            System.out.println("name: " + temp.getKey() + "time: " + temp.getValue().time.toString() + "action: " + temp.getValue().status.toString() );
        }
    }


}
