import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("Calculadora, elige una opción con un número entero: -->1");


        do {

            System.out.println("1. Calcular IMC:");
            System.out.println("2. Calcular área de un rectángulo");
            System.out.println("3. Convertir °C a °F");
            System.out.println("4. calcular area de un circulo");
            System.out.println("5. Salir");
            System.out.print("Opcion elegida: ");




            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("CaLculadora de IMC");
                    double pesoKG = obtenerDouble(sc,"Dame tu peso en KG");
                    double alturaM = obtenerDouble(sc, "Dame tu altura en M:");
                    double IMC= calcularIMC(pesoKG,alturaM);
                    System.out.println("El IMC es: "+IMC);
                    break;
                case 2:
                    System.out.println("Calcular área de un rectángulo");
                    double baseTri = obtenerDouble(sc,"Dame la base de tu triangulo");
                    double alturaTri = obtenerDouble(sc, "Dame la altura de tu triangulo");
                    double areaTri= calcularAreaTrian(baseTri,alturaTri);
                    System.out.println("Su área es: "+areaTri);

                    break;
                case 3:
                    System.out.println("Convertir °C a °F");
                    double celcius = obtenerDouble(sc,"Dame los celcius");
                    double farenheit= calcularFarenheit(celcius);
                    System.out.println("Su conversion es: "+farenheit+"°F");
                    break;
                case 4:
                    System.out.println("calcular area de un circulo");
                    double radio = obtenerDouble(sc,"Dame el radio de tu circulo");
                    double areaCir= calcularAreaCir(radio);
                    System.out.println("Su área es: "+areaCir);
                    break;
                case 5:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opcion Invalida, intenta de nuevo");
            }
            System.out.println();

        } while (choice != 5);
    }

    /**
     *
     * @param sc lee el mensaje
     * @param mensaje
     * @return
     */
    public static double obtenerDouble(Scanner sc, String mensaje) {
        System.out.println(mensaje);
        return sc.nextDouble();
    }

    /**
     *
     * @param pesoKG peso en kg
     * @param alturaM altura en metros
     * @return Calculo del IMC
     */
    private static double calcularIMC(double pesoKG, double alturaM){
        return pesoKG/(alturaM*alturaM);

    }

    /**
     *
     * @param baseTri Base triangulo
     * @param alturaTri Altura triangulo
     * @return Area del triangulo
     */
    private static double calcularAreaTrian(double baseTri, double alturaTri){
        return (baseTri*alturaTri)/2;

    }

    /**
     *
     * @param celcius Celcius insertados
     * @return calculo de celcius a farenheit
     */
    private static double calcularFarenheit(double celcius){
        return (celcius* 1.8)+32;

    }

    /**
     *
     * @param radio Radio del círculo
     * @return Area circulo
     */
    private static double calcularAreaCir(double radio){
        return 3.1416*(radio*radio);

    }



}