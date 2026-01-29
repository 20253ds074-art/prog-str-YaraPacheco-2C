import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean esEstudiante = false;
        int tarifa = 0;
        int edad = obtenerEdad(sc, "Dame tu edad:");

        if (edad < 0 || edad > 120) {
            System.out.println("Edad inválida");
            return;
        } else {
            System.out.println("¿Eres estudiante?, escribe (true) o (false)");
            esEstudiante = sc.nextBoolean();

            if (edad < 12) {
                tarifa = 50;
            } else if (edad >= 12 && edad <= 17) {
                if (esEstudiante == true) {
                    tarifa = 60;
                } else {
                    tarifa = 80;
                }
            } else { // edad >= 18
                if (esEstudiante == true) {
                    tarifa = 90;
                } else {
                    tarifa = 120;
                }
            }
        }

        System.out.println("Edad ingresada: " + edad);
        System.out.println("Es estudiante: " + esEstudiante);
        System.out.println("Tarifa final: " + tarifa);
    }

    public static int obtenerEdad(Scanner sc, String mensaje) {
        System.out.println(mensaje);
        return sc.nextInt();
    }
}
