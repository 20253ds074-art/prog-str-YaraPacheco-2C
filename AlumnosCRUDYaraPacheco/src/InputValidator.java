import java.util.Scanner;

public class InputValidator {
    public int getValidInt(String msg, Scanner sc) {
        int value;
        while (true) {
            System.out.print(msg);
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                sc.nextLine();
                if (value > 0) {
                    return value;
                }
                System.out.println("Error ID entero");
            } else {
                System.out.println("El valor no es numérico");
                sc.nextLine();
            }
        }
    }

    public int getValidRange(String msg, Scanner sc, int min, int max) {
        int value;
        while (true) {
            System.out.print(msg);
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                sc.nextLine();
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Error: Opción fuera de rango (" + min + "-" + max + ")");
            } else {
                System.out.println("Entrada invalida");
                sc.nextLine();
            }
        }
    }

    public String getValidNombre(String msg, Scanner sc) {
        while (true) {
            String text;
            System.out.print(msg);

            text = sc.nextLine().trim();

            if (!text.isEmpty()) {
                return text;
            }
            System.out.println("Error: Nombre vacío");
        }
    }

    public double getValidPromedio(String msg, Scanner sc) {
        double valor;
        while (true) {
            System.out.print(msg);

            if (sc.hasNextDouble()) {
                valor = sc.nextDouble();
                sc.nextLine();

                if (valor >= 0 && valor <= 10) {
                    return valor;
                }
                System.out.println("Error: El promedio debe estar entre 0 y 10.");

            } else {
                System.out.println("Error: Debe ingresar un número decimal (ej: 8.5).");
                sc.nextLine();
            }
        }
    }


}




