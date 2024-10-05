package com.bancodo.menues;

import com.bancodo.classes.Animation;
import com.bancodo.helpers.Console;
import com.bancodo.interfaces.MenuAction;

abstract class Menu {

    public static void handleBadOption(MenuAction menuCallback){
        Console.clean();
        System.out.println("Opcion incorrecta, vuelva a intentar");
        Console.textInput("Presione una tecla para continuar..");
        menuCallback.execute();
    }

    public static void backToMenu(MenuAction menuCallback) {
        System.out.println("1) Volver");
        System.out.println("0) Salir");

        switch (Console.textInput("Ingrese una opcion..")) {
            case "1":
                menuCallback.execute();
                break;
            case "0":
                Animation.close();
                break;
        
            default:
                handleBadOption(menuCallback);
                break;
        }
    }
}
