import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Calculadora de suma, dame 3 numeros");
        int numUno = obtenerInt(scanner,"Primer número: ");
        int numDos = obtenerInt(scanner,"Segundo número: ");
        int numTres = obtenerInt(scanner,"Tercer número: ");


        int suma = calcularSuma(numUno,numDos,numTres);
        System.out.println("suma=" + suma);
        System.out.println("prom=" +calcularPromedio(suma) );
    }
    public static int obtenerInt(Scanner scanner, String mensaje){
        System.out.print(mensaje);
        return scanner.nextInt();
    }
    public static int calcularSuma(int numUno, int numDos, int numTres){

        return numUno+numDos+numTres;
    }
    public static double calcularPromedio (int suma){

        return suma/3.0;
    }

}