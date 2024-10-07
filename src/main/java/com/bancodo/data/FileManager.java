package com.bancodo.data;

import java.util.*;
import java.io.*;

public class FileManager implements Serializable {
    private static String basePath = "src/main/java/com/bancodo/data/";

    public static void save(String fileName, ArrayList<String> list){
        try {
            File file = new File(basePath + fileName + ".dat");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            fos.close();
            oos.close();
        } catch (Exception e) {
            System.out.println("Error al guardar el archivo: " + e);
        }
    }

    public static ArrayList<String> read(String fileName){
        ArrayList<String> list = null;
        try {
            File file = new File(basePath + fileName + ".dat");

            if (!file.exists()) throw new IOException("Parece que el archivo no existe");

            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList<String>) ois.readObject();
            fis.close();
            ois.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }catch (ClassNotFoundException e) {
            System.out.println("Error al leer el archivo: " + e);
        }

        return list;
    }

    public static void delete(String fileName) {
        try {
            File archivo = new File( basePath + fileName +".dat");

            if(archivo.exists()){
                archivo.delete();
                System.out.println("Archivo borrado con éxito");
            }else{
                System.out.println("El archivo no se encontró, no se puede realizar la operación de borrado.");
            }
        } catch (Exception e) {
            System.out.println("Error al borrar el archivo");
        }
    }
    
    // public static void main(String[] args) throws IOException {
        // CREAR
        // ArrayList<String> listaprueba = new ArrayList<String>();
        // listaprueba.add("Algo");
        // listaprueba.add("Algo2");
        // save("test",listaprueba);

        // LEER
        // ArrayList<String> prueba = read("test");
        // System.out.println(prueba);

        // ACTUALIZAR
        // listaprueba.remove(0);
        // listaprueba.add("Pepe");
        // save("test",listaprueba);
        // System.out.println(prueba);
        // System.out.println(read("test"));

        // BORRAR
        // delete("test");
    // }

}
