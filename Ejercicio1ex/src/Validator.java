import java.util.Scanner;

public class Validator {
    public Validator() {
    }

    public static boolean esCodigo(String codigo) {
        if (codigo == null) {
            return false;
        }


        if (codigo.length() != 6) {
            return false;
        }

        if (codigo.matches("^[a-zA-Z0-9]+$")) {
            return true;
        }
        return false;

    }

    public static boolean esHorarioPermitido(int horaEntrada, boolean esAlumno) {
        if (esAlumno) {
            return (horaEntrada >= 8 && horaEntrada <= 20);

        } else {
            return (horaEntrada >= 10 && horaEntrada <= 18);
        }

    }

}
