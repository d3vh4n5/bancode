package com.bancodo.menues;

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
                Console.clean();
                System.out.println("Finalizado programa...");
                System.exit(0);
                return;
        
            default:
                System.out.println("Opcion incorrecta, vuelva a intentar");
                menu();
                break;
        }
    }

    public static void backToMenu() {
        System.out.println("1) Volver");
        System.out.println("0) Salir");

        switch (Console.textInput("Ingrese una opcion..")) {
            case "1":
                menu();
                break;
            case "0":
                System.exit(0);;
                break;
        
            default:
                break;
        }
    }
}
