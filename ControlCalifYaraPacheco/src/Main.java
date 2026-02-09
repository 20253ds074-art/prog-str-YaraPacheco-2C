import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // INPUT
        String nombre = leerTextoNoVacio("Dame tu nombre completo:", sc);
        double p1 = leerDoubleEnRango("Dame tu calificación 1:", sc, 0, 100);
        double p2 = leerDoubleEnRango("Dame tu calificación 2:", sc, 0, 100);
        double p3 = leerDoubleEnRango("Dame tu calificación 3:", sc, 0, 100);
        int asistencia = leerIntEnRango("Dame tu número de asistencias:", sc, 0, 100);
        boolean entregoProyecto = leerBoolean("¿Hiciste tu proyecto final? (true/false):", sc);

        // PROCESO
        GradeService serv = new GradeService();
        double promedio = serv.calcularPromedio(p1, p2, p3);
        double calFinal = serv.calcularFinal(promedio, asistencia);
        String estado = serv.determinarEstado(calFinal, asistencia, entregoProyecto);

        // OUTPUT
        imprimirReporte(nombre, p1, p2, p3, promedio, asistencia, entregoProyecto, calFinal, estado);
    }

    // Métodos de INPUT
    public static String leerTextoNoVacio(String msg, Scanner sc) {
        while (true) {
            System.out.println(msg);
            String value = sc.nextLine();
            if (!value.trim().isEmpty()) {
                return value;
            }
            System.out.println("Inténtalo de nuevo, no debes ingresar vacío");
        }
    }

    public static double leerDoubleEnRango(String msg, Scanner sc, double min, double max) {
        while (true) {
            System.out.println(msg);
            if (sc.hasNextDouble()) {
                double value = sc.nextDouble();
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Valor fuera de rango (" + min + " - " + max + ")");
            } else {
                System.out.println("Ingresa un número válido");
                sc.nextLine();
            }
        }
    }

    public static int leerIntEnRango(String msg, Scanner sc, int min, int max) {
        while (true) {
            System.out.println(msg);
            if (sc.hasNextInt()) {
                int value = sc.nextInt();
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Valor fuera de rango (" + min + " - " + max + ")");
            } else {
                System.out.println("Ingresa un número entero válido");
                sc.nextLine();
            }
        }
    }

    public static boolean leerBoolean(String msg, Scanner sc) {
        while (true) {
            System.out.println(msg);
            if (sc.hasNextBoolean()) {
                return sc.nextBoolean();
            } else {
                System.out.println("Ingresa true o false");
                sc.nextLine();
            }
        }
    }

    // output
    public static void imprimirReporte(String nombre, double p1, double p2, double p3, double promedio, int asistencia, boolean entregoProyecto, double calFinal, String estado) {
        System.out.println("REPORTE FINAL");
        System.out.println("Alumno: " + nombre);
        System.out.println("Parcial 1: " + p1);
        System.out.println("Parcial 2: " + p2);
        System.out.println("Parcial 3: " + p3);
        System.out.println("Promedio parciales: " + promedio);
        System.out.println("Asistencia: " + asistencia + "%");
        System.out.println("Entregó proyecto: " + entregoProyecto);
        System.out.println("Calificación final: " + calFinal);
        System.out.println("Estado: " + estado);

    }
}
