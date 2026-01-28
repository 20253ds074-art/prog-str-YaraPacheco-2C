import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menú:  1) Sumar, 2) Restar, 3) Multiplicar,  4) Dividir");
        int opcion = sc.nextInt();
        if (opcion > 4) {
            System.out.println("Opcion invalida");
        } else {


            System.out.println("Dame el primer numero:");
            Double a = sc.nextDouble();
            System.out.println("Dame el segundo numero:");
            Double b = sc.nextDouble();

            switch (opcion) {
                case 1:
                    System.out.println("Operación elegida: Suma:");
                    double suma = a + b;
                    System.out.println("Resultado: " + suma);

                    break;
                case 2:
                    System.out.println("Operación elegida: Resta");
                    double resta = a - b;
                    System.out.println("Resultado: " + resta);
                    break;
                case 3:
                    System.out.println("Operación elegida: Multiplicacion");
                    double multi = a * b;
                    System.out.println("Resultado: " + multi);
                    break;

                case 4:
                    System.out.println("Operación elegida: Dividision");
                    if (a == 0 || b == 0) {
                        System.out.println("No se puede dividir etre cero");

                    } else {
                        double divi = a / b;
                        System.out.println("Resultado: " + divi);
                    }

                    break;
                default:
                    System.out.println("Opcion invalida");
            }
            System.out.println("Valores ingresados: " + a + " y " + b);

        }
    }
}