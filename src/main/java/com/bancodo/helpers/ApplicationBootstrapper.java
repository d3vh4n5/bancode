package com.bancodo.helpers;

import com.bancodo.classes.FileManager;
import com.bancodo.menues.WelcomeMenu;

public class ApplicationBootstrapper {
    public static void bootstrap(){
        try {
            FileManager.directoryExists();
            if (!FileManager.dataFilesExists()) generateDemoFiles();
            WelcomeMenu.menu();
        } catch (Exception e) {
            System.out.println("Error al iniciar");
        }
    }

    public static void generateDemoFiles(){
        System.out.println("Generando archivos de prueba....");
        String[] users = {"Juan Basgall", "Marcos Goyete", "Mateo Ferrari"};
        double accBalances[] = {100000, 150000, 200000};
        String[] dnis = {"12345678", "23456789", "45632187"};
        String keys[] = {"1234", "4321", "1324"}; 
        FileManager.save("users", users);
        FileManager.save("accBalances", accBalances);
        FileManager.save("dnis", dnis);
        FileManager.save("keys", keys);
    }
}
