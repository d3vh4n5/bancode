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
        try {
            FileManager.save("accBalances", accBalances);
        } catch (Exception e) {
            System.out.println("Error al actualizar el saldo en la Base de Datos");
        }
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
}
