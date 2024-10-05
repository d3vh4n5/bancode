package com.bancodo.classes;

import com.bancodo.helpers.*;
import com.bancodo.models.User;
import com.bancodo.menues.*;

public class Auth {
    public static int tries = 1;

    public static void login(){
        String dni, password;

        dni = Console.textInput("Por favor, ingrese su número de DNI: ");
        if (dni.equals("ayuda")) System.out.println("Use: 12345678");
        password = Console.textInput("Por favor, ingrese su contraseña: ");
        if (password.equals("ayuda")) System.out.println("Use: 1234");

        // consultar validez, sino msg de error y login() denuevo
        if (User.validate(dni, password)){
            MainMenu.menu();
        } else {
            if (tries < 3){
                Console.clean();
                tries++;
                System.out.println("Usuario o contraseña incorrectos");
                System.out.println("Intentos: "+tries+"/3");
                login();
            } else {
                Console.clean();
                System.out.println("Intentos agotados");
                System.out.println("Su tarjeta se ha bloqueado por seguridad");
                System.out.println("Fin de la ejecicion del programa");
                System.exit(0);
            }
        }
    }
}
