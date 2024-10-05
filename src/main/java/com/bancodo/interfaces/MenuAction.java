package com.bancodo.interfaces;

/**
 * La idea de usar interfaces y una clase abstracta para no
 * repetir las funciones de backToMenu y handleBadOption fue
 * mia, pero GPT me ayudó en la implementación, como por ejemplo
 * esta interfaz y su anotation.
 */

@FunctionalInterface
public interface MenuAction {
    void execute();
}
