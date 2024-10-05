package com.bancodo.menues;

import com.bancodo.classes.*;
import com.bancodo.helpers.Console;

public class WelcomeMenu {
    public static void menu(){

        try {
            Animation.load(); // Como esta tiene un throws, la controlo acá
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
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
                System.out.println("""
                        Para un usuario de pruebas puede usar:

                        DNI: 12345678
                        pass: 1234

                        Para ver el código fuente o contactar al desarrollador acceda al siguiente link: https://github.com/d3vh4n5/bancode

                        """);
                backToMenu();
                return;
            case "0":
                Animation.close();
                return;
            default:
                handleBadOpction();
                return;
        }
    }

    public static void handleBadOpction(){
        Console.clean();
        System.out.println("Opcion incorrecta, vuelva a intentar");
        Console.textInput("Presione una tecla para continuar..");
        menu();
    }

    public static void backToMenu(){
        System.out.println("1) Volver");
        System.out.println("0) Salir");

        switch (Console.textInput("Ingrese una opcion..")) {
            case "1":
                menu();
                break;
            case "0":
                Animation.close();
                break;
        
            default:
                handleBadOpction();
                break;
        }
    }
}
