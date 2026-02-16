import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        Alumno alumno= new Alumno();
        InputValidator validator = new InputValidator();
        Alumno[] listaAlumnos= new Alumno[25];
        int opcion;
        do {
            opcion=validator.getValidRange("\n--- MENÚ ---\n1)Alta alumno \n2)Buscar por ID (solo activos)\n3)Actualizar promedio por ID (solo activos)\n4)Baja lógica por ID\n5) Listar activos\n6) Reportes\n0) Salir: ", sc, 0, 6);
            switch (opcion){
                case 1:
                    //Alta alumno
                    int idAlta=validator.getValidInt("Dame el ID que quieres dar de alta:", sc);
                    if (existeID(listaAlumnos, idAlta)) {
                        System.out.println("Error: El ID ya existe.");
                    } else {
                        String nombre = validator.getValidNombre("Ingrese el nombre: ", sc);
                        double promedio = validator.getValidPromedio("Ingrese el promedio: ", sc);

                        if (guardarAlumno(listaAlumnos, idAlta, nombre, promedio)) {
                            System.out.println(">> Alumno registrado exitosamente.");
                        } else {
                            System.out.println("Error: Base de datos llena.");
                        }
                    }
                break;
                case 2:
                    //Buscar por ID
                    int idBuscar=validator.getValidInt("ID a buscar: ", sc);
                    Alumno encontrado =buscarAlumno(listaAlumnos, idBuscar);
                    if (encontrado != null){
                        System.out.println(">>Encontrado:"+encontrado);
                    }
                    else {
                        System.out.println("Alumno no encontrado o inactivo");
                    }
                break;
                case 3:
                    // Actualizar promedio por ID (solo activos)
                    int idAct = validator.getValidInt("Dame el ID para actualizar el promedio:", sc);

                    // Buscamos al alumno
                    Alumno pAct = buscarAlumno(listaAlumnos, idAct);

                    if (pAct != null){
                        // Pedimos el nuevo dato
                        double actProm = validator.getValidPromedio("Dame el nuevo promedio a actualizar:", sc);
                        pAct.setPromedio(actProm); // <--- Esto guarda el cambio en el objeto
                        System.out.println(">> Éxito: Promedio actualizado a " + actProm);
                    }
                    else {
                        System.out.println("Error: ID no encontrado o alumno inactivo.");
                    }
                break;
                case 4:
                    //Baja lógica por ID
                    int idBaja =validator.getValidInt("Ingrese el ID que quiere dar de baja:", sc);
                    Alumno aBaja= buscarAlumno(listaAlumnos, idBaja);
                    if (aBaja != null){
                        aBaja.setActivo(false);
                        System.out.println(">> Baja exitosa");
                    }
                    else {
                        System.out.println("Error: ID no encontrado");
                    }
                break;
                case 5:
                    // Listar activos
                    System.out.println("---Lista de alumnos activos----");
                    boolean hay=false;
                    for (Alumno a: listaAlumnos){
                        if (a != null && a.isActivo()){
                            System.out.println(a);
                            hay = true;
                        }
                    }
                    if (!hay) System.out.println("No hay alumnos en la base de datos");
                break;

                case 6:
                    //reportes
                    generarReportes(listaAlumnos);
                break;
                case 0:
                    System.out.println("Saliendo...");
                break;

            }

        }
        while (opcion!=0);
        sc.close();

    }

    //Métodos
    //Busca de un Alumno activo por ID
    public static Alumno buscarAlumno (Alumno[] lista, int id ){
        for (Alumno a: lista){
            if (a!= null && a.getId() == id && a.isActivo()){
                return a;
            }
        }
        return null;

    }
    //vamos a generar reportes
    public static void generarReportes(Alumno[] lista){
        System.out.println("\n---- Reportes (solo activos) ----");
        double sumaPromedio=0;
        int contadorActivos=0;
        int contadorMayOch=0;
        Alumno mejorAlumno = null;
        Alumno peorAlumno= null;
        for (Alumno a: lista){
            if (a!= null && a.isActivo()){
                contadorActivos++;
                sumaPromedio+=a.getPromedio();

                // contar >= 8.0
                if (a.getPromedio() >= 8.0){
                    contadorMayOch++;
                }
                //Buscar mayor promedio
                if (mejorAlumno== null || a.getPromedio() > mejorAlumno.getPromedio()){
                    mejorAlumno=a;
                }
                // Buscar menor promedio
                if (peorAlumno == null || a.getPromedio() < peorAlumno.getPromedio()){
                    peorAlumno =a;
                }

            }
        }
        if (contadorActivos>0){
            System.out.println("1. Promedio General:"+ (sumaPromedio/contadorActivos));
            System.out.println("2. Alumno con mayor promedio:"+ mejorAlumno);
            System.out.println("3. Alumno con menor promedio:"+peorAlumno);
            System.out.println("4. Cantidad con promedio mayor o igual a 8.0:"+ contadorMayOch);
        }
        else {
            System.out.println("No hay alumnos activos para generar reportes");
        }


    }

    // verificamos si un ID existe
    public static boolean existeID(Alumno[] lista, int id ){
        for (Alumno a: lista){
            if (a != null && a.getId() == id) return true;
        }
        return false;

    }
    public static boolean guardarAlumno(Alumno[] lista, int id, String nombre, double promedio) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == null) {
                lista[i] = new Alumno(id, nombre, promedio);
                return true;
            }
        }
        return false;
    }

}