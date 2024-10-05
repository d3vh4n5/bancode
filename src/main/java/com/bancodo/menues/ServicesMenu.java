package com.bancodo.menues;

import com.bancodo.helpers.Console;
import com.bancodo.models.Service;
import com.bancodo.models.User;

public class ServicesMenu {

    public static void menu(){
        String option;
        Console.clean();
        System.out.println("""
                Opciones:
                1) Pagar un servicio
                2) Volver
                0) Salir
                """);
        
        option = Console.textInput("Por favor, elija una opcion..");

        switch (option) {
            case "1":
                Console.clean();
                serviceList();
                break;
            case "2":
                Console.clean();
                MainMenu.menu();
                break;
            case "0":
                System.exit(0);
                break;
        
            default:
                System.out.println("Opcion incorrecta, vuelva a intentar");
                menu();
                break;
        }
    }

    public static void serviceList(){
        System.out.println("Servicios a pagar: ");

        Service.showServices();
        int target = Console.intInput("Elija el servicio a pagar:");

        if (Service.getService(target).equals("undefined")){
            Console.clean();
            System.out.println("Opcion incorrecta..");
            serviceList();
        }

        Console.clean();
        System.out.println("Se realizará un pago de: "
            + Service.getService(target)
            + " por el valor de: " + Service.getAmount(target)
        );

        confirm(target, Service.getAmount(target));
    }

    public static void confirm(int target, double ammount){
        String confirm = Console.textInput("Confirmar operacion? s/n");
        switch (confirm) {
            case "s":
                makePayment(target, ammount);
                return;
            case "n":
                menu();
                return;
    
            default:
                System.out.println("Opcion incorrecta, vuelva a intentar");
                menu();
                return;
        }
    }

    public static void makePayment(int target, double ammount){
        double balance = User.getAccBalance();

        if (!(ammount <= balance)){
            System.out.println("Saldo insuficiente");
            Console.textInput("Presione una tecla para continuar..");
            menu();
        } else {
            balance = balance - ammount;
            User.updateBalance(balance);
            Service.payService(target);
            System.out.println("Pago realizado con exito");
            Console.textInput("Presione una tecla para continuar..");
            MainMenu.menu();
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
