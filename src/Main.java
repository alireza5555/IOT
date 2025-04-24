import database.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)

    {


        Scanner scn = new Scanner(System.in);
        int q = scn.nextInt();

        String type;
        String name ;
        String protocol ;
        String value;
        String property;
        String action;
        String time;

        for (int i = 0; i < q; i++) {
            String command = scn.next();

            switch (command){
                case "add_device":
                     type = scn.next();
                     name = scn.next();
                     protocol = scn.next();
                    try {
                        Database.createDevice(type, name, protocol);
                        System.out.println("device added successfully");
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case "set_device":
                    name = scn.next();
                    property = scn.next();
                     value = scn.next();
                    try {
                        Database.updateDevice(name , property , value);
                        System.out.println("device updated successfully");
                    }

                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case "remove_device":
                    name = scn.next();

                    try {
                        Database.removeDevice(name);
                        System.out.println("device removed successfully");
                    }

                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case "list_devices":

                    try {
                        Database.getDeviceList();
                        System.out.println();
                    }

                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case "add_rule":
                    name = scn.next();
                    type = scn.next();
                    action = scn.next();

                    try {
                        Database.addRule(name , type , action);
                        System.out.println("rule added successfully");
                    }

                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case "check_rules":
                    time = scn.next();

                    try {
                        Database.checkRule(time);
                        System.out.println("rules checked");
                    }

                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case "list_rules":

                    try {
                        Database.showRules();
                        System.out.println();
                    }

                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Wrong command");
            }
        }

    }
}