import model.ExchangeRate;
import service.ApiService;
import util.JsonParser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ApiService apiService = new ApiService();
        JsonParser parser = new JsonParser();

        List<String> historial = new ArrayList<>();

        int opcion = 0;

        while (opcion != 7) {

            System.out.println("======================================");
            System.out.println("     Bienvenido/a al Conversor");
            System.out.println("======================================");
            System.out.println("1) USD → ARS");
            System.out.println("2) ARS → USD");
            System.out.println("3) USD → BRL");
            System.out.println("4) USD → CLP");
            System.out.println("5) USD → COP");
            System.out.println("6) Ver historial de conversiones");
            System.out.println("7) Salir");
            System.out.print("Elija una opción: ");

            opcion = scanner.nextInt();

            if (opcion == 7) {
                System.out.println("Saliendo del conversor...");
                break;
            }

            if (opcion == 6) {
                System.out.println("\n======= HISTORIAL DE CONVERSIONES =======");
                if (historial.isEmpty()) {
                    System.out.println("No hay conversiones registradas.");
                } else {
                    historial.forEach(System.out::println);
                }
                System.out.println("==========================================\n");
                continue;
            }

            String monedaBase = "";
            String monedaDestino = "";

            switch (opcion) {
                case 1:
                    monedaBase = "USD";
                    monedaDestino = "ARS";
                    break;
                case 2:
                    monedaBase = "ARS";
                    monedaDestino = "USD";
                    break;
                case 3:
                    monedaBase = "USD";
                    monedaDestino = "BRL";
                    break;
                case 4:
                    monedaBase = "USD";
                    monedaDestino = "CLP";
                    break;
                case 5:
                    monedaBase = "USD";
                    monedaDestino = "COP";
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    continue;
            }

            System.out.print("Ingrese el monto a convertir: ");
            double monto = scanner.nextDouble();

            try {
                String json = apiService.consultarApi(monedaBase, monedaDestino);

                ExchangeRate datos = parser.convertir(json);

                double tasa = datos.getConversion_rate();

                double resultado = monto * tasa;

                LocalDateTime ahora = LocalDateTime.now();
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String tiempo = ahora.format(formato);

                historial.add(tiempo + " → " + monto + " " + monedaBase +
                        " = " + resultado + " " + monedaDestino +
                        " (tasa " + tasa + ")");

                System.out.println("\n======================================");
                System.out.println(" Conversión realizada con éxito");
                System.out.println("======================================");
                System.out.println(monto + " " + monedaBase + " equivalen a:");
                System.out.println(resultado + " " + monedaDestino);
                System.out.println("Tasa utilizada: " + tasa);
                System.out.println("Fecha y hora: " + tiempo);
                System.out.println("======================================\n");

            } catch (Exception e) {
                System.out.println("Error al consultar la API: " + e.getMessage());
            }
        }

        scanner.close();
    }
}