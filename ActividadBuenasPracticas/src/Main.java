import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Suma de numeros anteriores:");
        int numeroObtenido = obtenerInt(sc, "Dame un numero entero mayor a 0");

        int total = calcularSuma(numeroObtenido);

        System.out.println("La suma con los numeros anteriores de tu numero es: " + total);
    }

    /**
     *
     * @param sc objeto previamente instanciado
     * @param mensaje mensaje a mostrar en consola
     * @return
     */
    private static int obtenerInt(Scanner sc, String mensaje) {
        System.out.println(mensaje);
        return sc.nextInt();
    }

    /**
     * Para calcular desde 1 hasta el numero obtenido
     * @param numeroObtenido es el numero que guardamos arriba
     * @return
     */
    private static int calcularSuma(int numeroObtenido) {
        int total = 0;
        for (int i = 1; i <= numeroObtenido; i++) {
            total += i;
        }
        return total;
    }
}
