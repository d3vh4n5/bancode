package com.bancodo.menues;

import com.bancodo.classes.Animation;
import com.bancodo.helpers.Console;
import com.bancodo.models.User;

public class MainMenu {

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
                backToMenu();
                break;
            case "2":
                Console.clean();
                System.out.println("Su saldo actual es: " + User.getAccBalance());
                backToMenu();
                break;
            case "3":
                Console.clean();
                TransactionsMenu.menu();
                backToMenu();
                break;
            case "4":
                Console.clean();
                ServicesMenu.menu();
                backToMenu();
                break;
            case "0":
                Animation.close();
                return;
        
            default:
                handleBadOpction();
                break;
        }
    }

    public static void handleBadOpction(){
        Console.clean();
        System.out.println("Opcion incorrecta, vuelva a intentar");
        Console.textInput("Presione una tecla para continuar..");
        menu();
    }

    public static void backToMenu() {
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
