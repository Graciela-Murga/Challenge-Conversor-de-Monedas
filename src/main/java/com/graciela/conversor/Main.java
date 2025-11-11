package com.graciela.conversor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExchangeRateService exchangeRateService = new ExchangeRateService();

        System.out.println("====================================");
        System.out.println("  Bienvenido/a al Conversor de Monedas");
        System.out.println("====================================");

        int opcion = -1;

        while (opcion != 7) {
            System.out.println("\nElige una opción de conversión:");
            System.out.println("1) Dólar (USD) -> Peso argentino (ARS)");
            System.out.println("2) Peso argentino (ARS) -> Dólar (USD)");
            System.out.println("3) Dólar (USD) -> Real brasileño (BRL)");
            System.out.println("4) Real brasileño (BRL) -> Dólar (USD)");
            System.out.println("5) Dólar (USD) -> Peso colombiano (COP)");
            System.out.println("6) Peso colombiano (COP) -> Dólar (USD)");
            System.out.println("7) Salir");
            System.out.print("Opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida. Intenta de nuevo.");
                continue;
            }

            if (opcion == 7) {
                System.out.println("Gracias por usar el conversor. ¡Hasta pronto!");
                break;
            }

            System.out.print("Ingresa el valor que deseas convertir: ");
            double monto;

            try {
                monto = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Valor numérico inválido. Intenta de nuevo.");
                continue;
            }

            String from = null;
            String to = null;

            switch (opcion) {
                case 1 -> { from = "USD"; to = "ARS"; }
                case 2 -> { from = "ARS"; to = "USD"; }
                case 3 -> { from = "USD"; to = "BRL"; }
                case 4 -> { from = "BRL"; to = "USD"; }
                case 5 -> { from = "USD"; to = "COP"; }
                case 6 -> { from = "COP"; to = "USD"; }
                default -> {
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    continue;
                }
            }

            try {
                double tasa = exchangeRateService.obtenerTasa(from, to);
                double resultado = monto * tasa;

                System.out.printf("El valor de %.2f %s corresponde a %.2f %s%n",
                        monto, from, resultado, to);

            } catch (RuntimeException e) {
                System.out.println("Ocurrió un error al consultar la API: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
