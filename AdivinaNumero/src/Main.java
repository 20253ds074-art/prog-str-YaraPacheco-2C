import java.util.Random;
import java.util.Scanner;

public class Main {
    // Variables estáticas a nivel de clase
    static int nonumerico = 0;
    static int total = 0;
    static int pasorango = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int intentos = 0;
        int limiteIntentos = 7;

        boolean gano = false;
        int secreto = random.nextInt(100) + 1; // número secreto entre 1...100
        System.out.println("Adivina el numero (1-100) " + "tienes: " + limiteIntentos + " intentos para lograrlo");

        while (intentos < limiteIntentos) {
            int numero = obtenerNumeroValido("Intento: " + (intentos + 1), sc, min, max);
            intentos++;
            if (numero == secreto) {
                System.out.println("Felicidades ganaste en el intento: " + intentos);
                gano = true;
                break;
            } else if (numero > secreto) {
                System.out.println("El numero secreto es menor a " + numero);
            } else {
                System.out.println("El numero secreto es mayor a " + numero);
            }
        }

        if (!gano) {
            System.out.println("Perdiste, el numero secreto era: " + secreto);
        }

        // Mostrar resumen de contadores
        System.out.println("Resumen de tus intentos:");
        System.out.println(" - Intentos fuera de rango: " + pasorango);
        System.out.println(" - Datos no numéricos: " + nonumerico);
        System.out.println(" - Total de entradas inválidas: " + total);
    }

    public static int obtenerNumeroValido(String mensaje, Scanner sc, int min, int max) {
        int entrada;
        while (true) {
            System.out.println(mensaje);
            if (sc.hasNextInt()) { // dato numérico
                entrada = sc.nextInt();
                if (entrada >= min && entrada <= max) {
                    return entrada;
                }
                System.out.println("El numero ingresado esta fuera de rango (1-100)");
                pasorango++;
                total++;
            } else {
                System.out.println("El dato ingresado no es numerico");
                nonumerico++;
                total++;
                sc.next(); // consumir entrada inválida
            }
        }
    }
}
