package com.bancodo.models;

import java.util.*;

import com.bancodo.helpers.Console;
import com.bancodo.menues.MainMenu;

public class Service {
    public static ArrayList<String> services = new ArrayList<String>(
        Arrays.asList("Luz", "Gas", "Internet")
    );
    public static ArrayList<Double> amounts = new ArrayList<Double>(
        Arrays.asList(5367.34, 3001.33, 20.000)
    );

    public static void showServices(){

        if (!(services.size() > 0)){
            System.out.println("No hay servicios por pagar");
            Console.textInput("Presione una tecla para volver al menú principal");
            MainMenu.menu();
            return;
        }

        for (String service: services){
            int index = services.indexOf(service);
        
            System.out.println(
                index + ") " + service
                + " - Total: " + amounts.get(index)
                );
        }
    }

    public static String getService(int id){
        if (id >= 0 && id < services.size())
            return services.get(id);
        else return "undefined";
    }

    public static double getAmount(int id){
        return amounts.get(id);
    }

    public static void payService(int id){
        services.remove(id);
        amounts.remove(id);
    }
}
