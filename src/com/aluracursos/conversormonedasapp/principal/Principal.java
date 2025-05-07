package com.aluracursos.conversormonedasapp.principal;

import com.aluracursos.conversormonedasapp.api.Monedas;
import com.aluracursos.conversormonedasapp.api.ValorMonedasApi;
import com.aluracursos.conversormonedasapp.excepciones.RespuestaUsuario;

import java.io.FileWriter;
import java.time.LocalTime;

public class Principal {
        public static void main(String[] args) throws Exception {

            //Obtengo los valores de cada moneda a través de la api
            ValorMonedasApi tasas = new ValorMonedasApi();
            Monedas monedas = tasas.obtenerTasas();
            //Crear archivo para guardar historial de conversión
            FileWriter historial = new FileWriter("Historial.txt");


        while (true) {
            //Menú
            System.out.println("*************************************************************************************\n"+
                    "Bienvenido/a, elige que tipo de conversión deseas realizar: \n"+
                    "\n"+
                    "1) Dólar ->> Peso argentino \n"+
                    "2) Peso argentino ->> Dólar \n"+
                    "3) Dólar ->> Real brasileño \n"+
                    "4) Real brasileño ->> Dólar \n"+
                    "5) Dólar ->> Peso colombiano \n"+
                    "6) Peso colombiano ->> Dólar \n"+
                    "7) Salir \n"+
                    "Elije una opción válida: \n"+
                    "*************************************************************************************\n");

            //Lanza Scanner y comprueba que de una respuesta válida
            var menu = RespuestaUsuario.ConsultaMenu();

            //Aquí se puede reducir el código utilizando metodos, pero prefiero dejarlo así porque me será más facil
            //repasar cosas básicas cuando lo revise en un futuro, y tambien porque así es como me salio hacerlo en un principio.
            switch (menu) {
                case "1":
                    System.out.println("¿Cuantos dólares [USD] quieres convertir a pesos argentinos [ARS]?\n");
                    double valor = RespuestaUsuario.ConsultaValor();
                    String respuesta = "$"+valor+" [USD] es igual a ->> $" + String.format("%.2f",valor*monedas.ars())+" [ARS] ";
                    System.out.println(respuesta);
                    LocalTime tiempo = LocalTime.now();
                    String hora = tiempo.toString();
                    historial.write(respuesta+"# consultado a las: ["+hora.substring(0,5)+"] horas\n");
                    break;
                case "2":
                    System.out.println("¿Cuantos pesos argentinos [ARS] quieres convertir a dólares [USD]?\n");
                    double valor1 = RespuestaUsuario.ConsultaValor();
                    String respuesta1 = "$"+valor1+" [ARS] es igual a ->> $"+String.format("%.4f",valor1/monedas.ars())+" [USD]\n";
                    System.out.println(respuesta1);
                    LocalTime tiempo1 = LocalTime.now();
                    String hora1 = tiempo1.toString();
                    historial.write(respuesta1+"# consultado a las: ["+hora1.substring(0,5)+"] horas\n");
                    break;
                case "3":
                    System.out.println("¿Cuantos dólares [USD] quieres convertir a reales brasileños [BRL]?\n");
                    double valor2 = RespuestaUsuario.ConsultaValor();
                    String respuesta2 = "$"+valor2+" [USD] es igual a ->> $"+String.format("%.2f",valor2*monedas.brl())+" [BRL]\n";
                    System.out.println(respuesta2);
                    LocalTime tiempo2 = LocalTime.now();
                    String hora2 = tiempo2.toString();
                    historial.write(respuesta2+"# consultado a las: ["+hora2.substring(0,5)+"] horas\n");
                    break;
                case "4":
                    System.out.println("¿Cuantos reales brasileños [BRL] quieres convertir a dólares [USD]?\n");
                    double valor3 = RespuestaUsuario.ConsultaValor();
                    String respuesta3 = "$"+valor3+" [BRL] es igual a ->> $"+String.format("%.2f",valor3/monedas.brl())+" [USD]\n";
                    System.out.println(respuesta3);
                    LocalTime tiempo3 = LocalTime.now();
                    String hora3 = tiempo3.toString();
                    historial.write(respuesta3+"# consultado a las: ["+hora3.substring(0,5)+"] horas\n");
                    break;
                case "5":
                    System.out.println("¿Cuantos dólares [USD] quieres convertir a pesos colombianos [COP]?\n");
                    double valor4 = RespuestaUsuario.ConsultaValor();
                    String respuesta4 = "$"+valor4+" [USD] es igual a ->> $"+String.format("%.4f",valor4*monedas.cop())+" [COP]\n";
                    System.out.println(respuesta4);
                    LocalTime tiempo4 = LocalTime.now();
                    String hora4 = tiempo4.toString();
                    historial.write(respuesta4+"# consultado a las: ["+hora4.substring(0,5)+"] horas\n");
                    break;
                case "6":
                    System.out.println("¿Cuantos pesos colombianos [COP] quieres convertir a dólares [USD]?");
                    double valor5 = RespuestaUsuario.ConsultaValor();
                    String respuesta5 = "$"+valor5+" [COP] es igual a ->> $"+String.format("%.4f",valor5/monedas.cop())+" [USD]\n";
                    System.out.println(respuesta5);
                    LocalTime tiempo5 = LocalTime.now();
                    String hora5 = tiempo5.toString();
                    historial.write(respuesta5+"# consultado a las: ["+hora5.substring(0,5)+"] horas\n");
                    break;
                case "7":
                    System.out.println("Gracias por probar esta aplicación :D");
                    historial.close();
                    System.exit(0);
            }
        }

    }
}
