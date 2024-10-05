package com.bancodo.models;

import java.util.*;

public class Contact {
    public static ArrayList<String> contacts = new ArrayList<String>(
        Arrays.asList("Carlos", "Luis", "Juan")
    );
    public static ArrayList<String> cbus = new ArrayList<String>(
        Arrays.asList("111111", "222222", "333333")
    );

    public static void addContact(String name, String cbu){
        contacts.add(name);
        cbus.add(cbu);

        System.out.println("Se agrego al contacto: ");
        System.out.println(name);
        System.out.println(cbu);
    }

    public static void showContacts(){
        for (String contacto: contacts){
            int index = contacts.indexOf(contacto);
            System.out.println(
                index + ") " + contacto
                + " - CBU: " + cbus.get(index)
                );
        }
    }

    public static String getContact(int id){
        if (id >= 0 && id < contacts.size())
            return contacts.get(id);
        else return "undefined";
    }
}
