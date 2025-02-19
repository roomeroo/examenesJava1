/**
 * Clase principal.
 * 
 */
public class SistemaGestorEstudiantes {
    /**
     * Funcion principal donde se desarrolla todo el programa.
     * 
     * @param args argumentos del programa
     */
    public static void main(String[] args) {
        int option = 1;
        String nombre;
        double promedio;
        double nota;

        System.out.println(Utils.limpiarPantalla);
        GestorEstudiantes sistema = new GestorEstudiantes();
        do {
            System.out.println("Elija una de las siguientes opciones:");
            System.out.println("1. Agregar un nuevo estudiante.");
            System.out.println("2. Agregar nota a un estudiante.");
            System.out.println("3. Listar estudiantes.");
            System.out.println("4. Mostrar estudiantes con promedio mayor al indicado.");
            System.out.println("5. Buscar un estudiante por su nombre.");
            System.out.println("6. Salir.");

            option = Integer.parseInt(System.console().readLine());

            switch (option) {
                case 1:
                    System.out.println("¿Cuál es el nombre del estudiante?");
                    nombre = System.console().readLine();
                    sistema.agregarEstudiante(nombre);
                    break;

                case 2:
                    System.out.println("¿A qué estudiante desea agregarle una nota?");
                    nombre = System.console().readLine();
                    nota = Utils.introducirReal();
                    sistema.agregarNotaEstudiante(nombre, nota);
                    break;

                case 3:
                    sistema.mostrarEstudiantes();
                    break;

                case 4:
                    promedio = Utils.introducirReal();
                    sistema.mostrarEstudiantesConPromedioMayorA(promedio);
                    break;

                case 5:
                    System.out.println("¿Cuál es el nombre del estudiante?");
                    nombre = System.console().readLine();
                    System.out.println(sistema.buscarEstudiante(nombre));
                    break;

                case 6:
                    System.out.println(Utils.YELLOW_BRIGHT + "Adios!" + Utils.RESET);
                    break;

                default:

                    System.out.println("Opción fuera del rango");
                    break;
            }
            Utils.pausa();
            System.out.println(Utils.limpiarPantalla);
        } while (option != 6);// me aseguo de controlar cualquier valor
    }
}
