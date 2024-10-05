package com.bancodo.helpers;

import java.util.Scanner;
import java.io.IOException;


public class Console {
    public static final Scanner scanner = new Scanner(System.in);


    public static String textInput(String msg){
        System.out.println(msg);
        return scanner.nextLine();
    }

    public static double doubleInput(String msg){
        while (true) {
            try {
                System.out.println(msg);
                double number = scanner.nextDouble();
                return number;
            }
            catch (Exception err) {
                System.out.println("Por favor, ingresa un número decimal válido.");
            } finally {
                scanner.nextLine(); // limpio buffer
            }
        }
    }

    public static int intInput(String msg){
        System.out.println(msg);
        int number = scanner.nextInt();
        scanner.nextLine(); // limpio buffer
        return number;
    }

    public static void close(){
        scanner.close();
    }

    public static void clean() {
        String os = System.getProperty("os.name").toLowerCase();

        try {
            ProcessBuilder processBuilder;

            if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
                // Para sistemas Unix/Linux/Mac
                processBuilder = new ProcessBuilder("clear");
            } else if (os.contains("win")) {
                // Para sistemas Windows
                processBuilder = new ProcessBuilder("cmd", "/c", "cls");
            } else {
                // Sistema operativo no soportado
                return;
            }

            // Ejecutar el comando para limpiar la consola
            processBuilder.inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

