import java.util.Scanner;

public class Main {

    public static final double IVA = 0.16;
    public static final double DESCUENTO = 0.10;
    public static final double UMBRAL_DESCUENTO = 1000.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double subtotal = pedirDouble(scanner, "Dame el subtotal de tu cuenta: ");
        double totalConIva = calcularTotalConIva(subtotal);
        double totalFinal = aplicarDescuentoSiAplica(totalConIva, subtotal);
        System.out.printf("Total a pagar con IVA: %.2f%n", totalConIva);
        System.out.printf("Total a pagar con IVA: %.2f%n", totalFinal);

    }


        public static double pedirDouble (Scanner scanner, String mensaje){
            System.out.print(mensaje);
            return scanner.nextDouble();
        }
        public static double calcularTotalConIva ( double subtotal){
            return subtotal + (subtotal * IVA);
        }
        public static double aplicarDescuentoSiAplica ( double total, double subtotal){
            if (subtotal > UMBRAL_DESCUENTO) {
                total = total - (total * DESCUENTO);
            }
            return total;
        }
    }

