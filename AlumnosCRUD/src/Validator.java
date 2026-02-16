import java.util.Scanner;

public class Validator {

    // Validar enteros positivos (para IDs)
    public int getValidInt(String message, Scanner sc) {
        int value;
        while (true) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                sc.nextLine(); // Limpiar buffer
                if (value > 0) return value;
                System.out.println("Error: El número debe ser positivo.");
            } else {
                System.out.println("Error: Debes ingresar un número entero.");
                sc.nextLine();
            }
        }
    }

    // Validar enteros con rango (para el Menú)
    public int getValidIntRange(String message, Scanner sc, int min, int max) {
        int value;
        while (true) {
            System.out.println(message);
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                sc.nextLine(); // Limpiar buffer
                if (value >= min && value <= max) return value;
                System.out.println("Error: Opción fuera de rango (" + min + "-" + max + ").");
            } else {
                System.out.println("Error: Entrada inválida.");
                sc.next();
            }
        }
    }

    // Validar Strings no vacíos
    public String getValidString(String message, Scanner sc) {
        String text;
        while (true) {
            System.out.print(message);
            text = sc.nextLine().trim();
            if (!text.isEmpty()) return text;
            System.out.println("Error: El texto no puede estar vacío.");
        }
    }
}