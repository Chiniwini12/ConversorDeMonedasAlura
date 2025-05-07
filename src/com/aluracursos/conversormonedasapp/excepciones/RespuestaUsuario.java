package com.aluracursos.conversormonedasapp.excepciones;

import java.io.FileWriter;
import java.util.Scanner;
//Metodos; algunos sencillos pero los utilizo para mantener más clara la clase principal y controlar posibles errores.
public class RespuestaUsuario {

    //Comprueba que el usuario seleccione correctamente una opción del menú
    public static String ConsultaMenu() {

        Scanner respuesta = new Scanner(System.in);
        var valor = respuesta.nextLine().trim();
        switch (valor) {
            case "1", "2", "3", "4", "5", "6", "7" -> {
            return valor;
            }
            default -> {
                System.out.println("Debes ingresar un número para seleccionar una opción del menú");
                return valor;
            }
        }

    }

    //Comprueba que el usuario de un número
    public static double ConsultaValor() {

        Scanner respuesta = new Scanner(System.in);
        var valor = respuesta.nextLine().trim();
        try {
            return Double.parseDouble(valor);
        } catch (NumberFormatException e) {
            System.out.println("Debes ingresar un número válido");
            System.exit(1);
        }
        return 0;

    }

}

