package com.bancodo.menues;

import com.bancodo.classes.Animation;
import com.bancodo.helpers.Console;
import com.bancodo.models.User;

public class MainMenu extends Menu{

    public static void menu(){
        String option;
        Console.clean();
        System.out.println("Bienvenido, " + User.getCurrentUserName());
        System.out.println("""
                **********************************
                *             MENU               *
                *                                *
                *      1) Datos cuenta           *
                *      2) Consultar saldo        *
                *      3) Transferir             *
                *      4) Pagar Servicio         *
                *      0) Salir                  *
                *                                *
                **********************************
                """);
        
        option = Console.textInput("Por favor, elija una opcion..");

        switch (option) {
            case "1":
                Console.clean();
                User.accInfo();
                backToMenu(MainMenu::menu);
                break;
            case "2":
                Console.clean();
                System.out.println("Su saldo actual es: " + User.getAccBalance() + "\n");
                backToMenu(MainMenu::menu);
                break;
            case "3":
                Console.clean();
                TransactionsMenu.menu();
                backToMenu(MainMenu::menu);
                break;
            case "4":
                Console.clean();
                ServicesMenu.menu();
                backToMenu(MainMenu::menu);
                break;
            case "0":
                Animation.close();
                return;
        
            default:
                handleBadOption(MainMenu::menu);
                break;
        }
    }
}
