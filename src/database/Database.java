package database;
import java.util.*;

public class Database {
    private static ArrayList <Entity> deviceList = new ArrayList<>();

    public static void addDevice(Entity entity) throws Exception {
        for (Entity temp : deviceList){
            if(temp.getName().equals(entity.getName())){
                throw new Exception("this name already exist.");
            }
        }
        deviceList.add(entity);
    }

}
