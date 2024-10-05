package com.bancodo.menues;

import com.bancodo.classes.Auth;
import com.bancodo.helpers.Console;

public class WelcomeMenu {
    public static void menu(){
        System.out.println("""
            **********************************
            *                                *
            *      Bienvenido a BanCode      *
            *                                *
            *      1) Logearse               *
            *      2) Ayuda                  *
            *      0) Salir                  *
            *                                *
            **********************************
            """);
        switch (Console.textInput("Elija una opción..")){
            case "1":
                Auth.login();
                return;
            case "2":
                System.out.println("123456789 1234");
                return;
            case "0":
                System.out.println("Finalizando programa...");
                System.exit(0);
                return;
            default:
                menu();
                System.out.println("Opción inválida");
                return;
        }
    }
}
