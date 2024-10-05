package com.bancodo.menues;

import com.bancodo.classes.Animation;
import com.bancodo.helpers.Console;

abstract class Menu {

    protected abstract void menu();

    public void handleBadOption(){
        Console.clean();
        System.out.println("Opcion incorrecta, vuelva a intentar");
        Console.textInput("Presione una tecla para continuar..");
        menu();
    }

    public void backToMenu() {
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
                handleBadOption();
                break;
        }
    }
}
