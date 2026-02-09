public class GradeService {
    public GradeService() {
    }

    // Constantes
    public static final String REPROBADO = "REPROBADO";
    public static final String APROBADO = "APROBADO";

    // Procesos
    public double calcularPromedio(double a, double b, double c) {
        return (a + b + c) / 3;
    }

    public double calcularFinal(double promedio, int asistencia) {
        // promedio está en escala 0–10, lo convertimos a 0–100
           double promedioEscala100 = promedio * 10;
           return (promedioEscala100 * 0.7) + (asistencia * 0.3);
    }

    public String determinarEstado(double calFinal, int asistencia, boolean entregoProyecto) {
        if (asistencia < 80) {
            return REPROBADO + " por asistencia";
        } else if (!entregoProyecto) {
            return REPROBADO + " por proyecto";
        } else {
            if (calFinal >= 70) {
                return APROBADO;
            } else {
                return REPROBADO + " por calificación";
            }
        }
    }
}
