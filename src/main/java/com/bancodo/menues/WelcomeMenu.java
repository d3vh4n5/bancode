package com.bancodo.menues;

import com.bancodo.classes.*;
import com.bancodo.helpers.Console;

public class WelcomeMenu extends Menu{
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
                Console.clean();
                System.out.println("""
                        Para un usuario de pruebas puede usar:

                        DNI: 12345678
                        pass: 1234

                        Para ver el código fuente o contactar al desarrollador acceda al siguiente link: https://github.com/d3vh4n5/bancode

                        """);
                backToMenu(WelcomeMenu::menu);
                return;
            case "0":
                Animation.close();
                return;
            default:
                handleBadOption(WelcomeMenu::menu);
                return;
        }
    }
}
