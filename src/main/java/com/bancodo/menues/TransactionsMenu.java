package com.bancodo.menues;

import com.bancodo.helpers.Console;
import com.bancodo.models.Contact;
import com.bancodo.models.User;

public class TransactionsMenu {

    public static void menu(){
        String option;
        Console.clean();
        System.out.println("""
                Opciones:
                1) Transferir a contacto existente
                2) Agregar nuevo contacto
                3) Volver
                0) Salir
                """);
        
        option = Console.textInput("Por favor, elija una opcion..");

        switch (option) {
            case "1":
                Console.clean();
                contactList();
                // backToMenu();
                break;
            case "2":
                Console.clean();
                addContact();
                break;
            case "3":
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

    public static void contactList(){
        System.out.println("Contactos actuales: ");
        Contact.showContacts();
        int target = Console.intInput("Elija el contacto de destino:");

        if (Contact.getContact(target).equals("undefined")){
            Console.clean();
            System.out.println("El contacto no existe...");
            contactList();
        }
        double ammount = Console.doubleInput("Ingrese cantidad a transferir");

        Console.clean();
        System.out.println("Se realizará una transferencia al contacto: "
            + Contact.getContact(target)
            + " por el valor de: " + ammount
        );

        confirm(target, ammount);
    }

    public static void confirm(int target, double ammount){
        String confirm = Console.textInput("Confirmar operacion? s/n");
        switch (confirm) {
            case "s":
                makeTransaction(target, ammount);
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

    public static void makeTransaction(int target, double ammount){
        double balance = User.getAccBalance();

        if (!(ammount <= balance)){
            System.out.println("Saldo insuficiente");
            Console.textInput("Presione una tecla para continuar..");
            menu();
        } else {
            balance = balance - ammount;
            User.updateBalance(balance);
            System.out.println("Transferencia realizada con exito a:");
            System.out.println(Contact.getContact(target));
            System.out.println("Por el valor de: $" + ammount);
            System.out.println("Su saldo actual es de: $" + User.getAccBalance());
            Console.textInput("Presione una tecla para continuar..");
            MainMenu.menu();
        }
    }

    public static void addContact(){
        String name = Console.textInput("Ingrese nombre del contacto");
        String cbu = Console.textInput("Ingrese cbu del contacto");
        Contact.addContact(name, cbu);
        Console.textInput("Presione una tecla para continuar...");
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
                System.exit(0);;
                break;
        
            default:
                break;
        }
    }
}
