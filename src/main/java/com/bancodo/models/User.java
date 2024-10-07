package com.bancodo.models;

import com.bancodo.helpers.*;
import com.bancodo.classes.FileManager;

public class User {
    private static int currentUser;
    public static String[] users = FileManager.readArray("users");
    public static double accBalances[] = FileManager.readDouble("accBalances");
    public static String[] dnis = FileManager.readArray("dnis");
    public static String keys[] = FileManager.readArray("keys"); 
    
    public static boolean validate(String dni, String password){

        for (int i=0; i < dnis.length ; i++){
            if (dni.equals(dnis[i])){
                if (password.equals(keys[i])) {
                    currentUser = i;
                    return true;
                }
                return false;
            }
        }
        return false;
    }
    
    public static String getDni(int idx){
        return dnis[idx];
    }
    public static double getAccBalance(){
        return accBalances[currentUser];
    }
    public static void updateBalance(double ammount){
        accBalances[currentUser] = ammount;
    }

    public static String getCurrentUserName(){
        return users[currentUser];
    }

    public static void accInfo(){
        Console.clean();
        System.out.println("Información de la cuenta: \n");
        System.out.println("Usuario: " + users[currentUser]);
        System.out.println("DNI:     " + dnis[currentUser]);
        System.out.println("Saldo:   " + accBalances[currentUser]);
        System.out.println("\n");
    }

    public static void generateDemoFiles(){
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
