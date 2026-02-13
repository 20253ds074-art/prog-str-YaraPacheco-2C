import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Persona[] personas = new Persona[20]; // Sirve para crear el arreglo
        int opcion;

        do {
            // Usamos el metodo obtenerInt para validar la entrada del menú
            opcion = obtenerInt("\n--- Menú elige la opción --- \n1) Alta\n2) Buscar por ID\n3) Baja lógica\n4) Listar activas\n5) Actualizar nombre\n0) Salir", sc, 0, 5);

            switch (opcion) {
                case 1: // ALTA
                    int idAlta = -1;
                    while (true) {
                        System.out.print("Ingrese ID (mayor a 0): ");
                        if (sc.hasNextInt()) {
                            idAlta = sc.nextInt();
                            sc.nextLine(); // Limpiar buffer
                            if (idAlta > 0) {
                                break; // ID válido, salimos del bucle
                            } else {
                                System.out.println("Error: El ID debe ser mayor a 0.");
                            }
                        } else {
                            System.out.println("Error: Debes ingresar un número entero");
                            sc.nextLine(); // Limpiar el texto incorrecto (como "Yara power")
                        }
                    }

                    // Validar ID repetido
                    boolean repetido = false;
                    for (Persona p : personas) {
                        if (p != null && p.getId() == idAlta) {
                            repetido = true;
                            break;
                        }
                    }

                    if (repetido) {
                        System.out.println("Error: El ID ya existe en el sistema.");
                    } else {
                        System.out.print("Ingrese Nombre: ");
                        String nombre = sc.nextLine();
                        if (nombre.trim().isEmpty()) {
                            System.out.println("Error: El nombre no puede estar vacío.");
                        } else {
                            // Buscar espacio libre en el arreglo
                            boolean guardado = false;
                            for (int i = 0; i < personas.length; i++) {
                                if (personas[i] == null) {
                                    personas[i] = new Persona(idAlta, nombre);
                                    System.out.println("Persona registrada con éxito.");
                                    guardado = true;
                                    break;
                                }
                            }
                            if (!guardado) System.out.println("Error: Arreglo lleno.");
                        }
                    }
                    break;

                case 2: // BUSCAR
                    System.out.print("ID a buscar: ");
                    int idBusca = sc.nextInt();
                    boolean encontrado = false;
                    for (Persona p : personas) {
                        if (p != null && p.getId() == idBusca && p.isActiva()) {
                            System.out.println("Encontrado: " + p);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) System.out.println("No encontrada o inactiva.");
                    break;

                case 3: // BAJA LÓGICA
                    System.out.print("ID para dar de baja: ");
                    int idBaja = sc.nextInt();
                    boolean dadoDeBaja = false;
                    for (Persona p : personas) {
                        if (p != null && p.getId() == idBaja && p.isActiva()) {
                            p.setActiva(false);
                            System.out.println("Baja realizada correctamente.");
                            dadoDeBaja = true;
                            break;
                        }
                    }
                    if (!dadoDeBaja) System.out.println("No se encontró el ID o ya está inactivo.");
                    break;

                case 4: // LISTAR ACTIVAS
                    System.out.println("--- LISTA DE PERSONAS ACTIVAS ---");
                    boolean hayActivas = false;
                    for (Persona p : personas) {
                        if (p != null && p.isActiva()) {
                            System.out.println(p);
                            hayActivas = true;
                        }
                    }
                    if (!hayActivas) System.out.println("No hay personas activas.");
                    break;

                case 5: // ACTUALIZAR
                    System.out.print("ID para actualizar nombre: ");
                    int idAct = sc.nextInt();
                    sc.nextLine(); // Limpiar buffer
                    boolean actualizado = false;
                    for (Persona p : personas) {
                        if (p != null && p.getId() == idAct && p.isActiva()) {
                            System.out.print("Nuevo nombre: ");
                            String nuevoNom = sc.nextLine();
                            if (!nuevoNom.trim().isEmpty()) {
                                p.setNombre(nuevoNom);
                                System.out.println("Nombre actualizado.");
                                actualizado = true;
                            } else {
                                System.out.println("Error: El nombre no puede estar vacío.");
                            }
                            break;
                        }
                    }
                    if (!actualizado) System.out.println("No encontrada o inactiva.");
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
            }
        } while (opcion != 0);

        sc.close();
    }

    // Metodo auxiliar para validación de entrada
    public static int obtenerInt(String message, Scanner sc, int min, int max) {
        while (true) {
            System.out.println(message);
            if (sc.hasNextInt()) {
                int value = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("El número está fuera del menú de opciones (" + min + " - " + max + ")");
            } else {
                System.out.println("Entrada inválida. Ingresa un número entero.");
                sc.next(); // Limpiar la entrada incorrecta
            }
        }
    }
}