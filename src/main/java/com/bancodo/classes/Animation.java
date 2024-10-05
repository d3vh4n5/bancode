package com.bancodo.classes;

import com.bancodo.helpers.*;

/**
 * @fuente Compas + GPT
 */

public class Animation {

    public static void load() throws InterruptedException {
        String[] animation = {"|", "/", "-", "\\"};
        int i = 0;
        
        Console.clean();
        System.out.print("Cargando sistema: ");
        while (i < 20) {  // La cantidad de repeticiones
            System.out.print("\rCargando sistema: " + animation[i % animation.length]); // "\r" regresa al principio de la línea
            Thread.sleep(200);  // Pausa de 200ms entre cada cambio de símbolo
            i++;
        }

        System.out.print("\rCarga completada!       \n");  // Limpia el símbolo final
    }

    public static void close() {
        Console.clean();
        for (int i = 3; i > 0; i--) {
            System.out.print("\rEL SISTEMA SE CERRARÁ EN: " + i + " "); // El carácter "\r" reinicia la línea. Aviso de cierre.
            try {
                Thread.sleep(1000); // Tiempo de espera (en milisegundos)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\r*** EL SISTEMA SE HA CERRADO CORRECTAMENTE ***          "); // Mensaje final de cierre.
        System.out.println("");
        Console.close();
        System.exit(0);
    }

}
