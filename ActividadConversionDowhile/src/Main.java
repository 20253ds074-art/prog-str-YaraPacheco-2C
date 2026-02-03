import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min=1;
        int max=5;
        int opc;
        //Contadores
        int contadorCaF=0;
        int contadorFaC=0;
        int contadorKmaMi=0;
        int contadorMiaKm=0;
        int total=0;
        do {
            opc = obtenerNumeroValido("Menú: 1) °C a °F,  2) °F a °C, 3) Km a Millas, 4) Millas a Km,  5) Salir", sc, min, max);
            switch (opc) {


                case 1:
                    double celsius=obtenerRespuestaValida("Dame los celcius", sc);
                    double fahrenheit = (celsius * 9 / 5) + 32;
                    System.out.println("Resultado en Farenheit: "+ fahrenheit+"°F");
                    contadorCaF++;
                    total++;
                    break;
                case 2:
                    fahrenheit=obtenerRespuestaValida("Dame los fahrenheit", sc);
                    celsius = (fahrenheit - 32) * 5/ 9;
                    System.out.println("Resultado en Celsius: "+ celsius+"°C");
                    contadorFaC++;
                    total++;

                    break;
                case 3:
                    double km=obtenerRespuestaValida("Dame los km",sc);
                    Double millas= km/ 0.621;
                    System.out.println("Resultado en millas: "+millas+" mi");
                    contadorKmaMi++;
                    total++;
                    break;


                case 4:
                    millas=obtenerRespuestaValida("Dame las millas:",sc);
                    km=millas*0.621;
                    System.out.println("Resultado en km: "+km+" km");
                    contadorMiaKm++;
                    total++;
                    break;
                case 5:
                    System.out.println("Total de conversiones:"+total);
                    System.out.println("°C a °F: " + contadorCaF);
                    System.out.println("°F a °C: " + contadorFaC);
                    System.out.println("Km a Millas: " + contadorKmaMi);
                    System.out.println("Millas a Km: " + contadorMiaKm);
                    break;

                default:
                    System.out.println("Opción no implementada");

            }


        } while (opc !=5);




    }


    public static int obtenerNumeroValido(String mensaje, Scanner sc, int min, int max) {
        int entrada;
        while (true) {
            System.out.println(mensaje);
            if (sc.hasNextInt()) { // para saber si el dato es numerico (int)
                entrada = sc.nextInt();
                if (entrada >= min && entrada <= max) {
                    return entrada;
                }
                System.out.println("El numero ingresado esta fuera del menú");
            } else {
                System.out.println("El dato ingresado no es numerico");
                sc.next(); //Consume el dato de entrada, para evitar un ciclo infinito


            }




        }
    }
    public static double obtenerRespuestaValida(String mensaje, Scanner sc) {
        double res;
        while (true) {
            System.out.println(mensaje);
            if (sc.hasNextDouble()) { // para saber si el dato es numerico (int)
                res = sc.nextDouble();
                return  res;
            } else {
                System.out.println("El dato ingresado no es numerico");
                sc.next(); //Consume el dato de entrada, para evitar un ciclo infinito


            }




        }
    }
}
