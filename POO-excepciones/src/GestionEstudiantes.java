public class GestionEstudiantes {
    /**
     * Solicita al usuario los datos de un estudiante (matrícula, nombre,
     * edad, promedio) y devuelve un objeto de tipo Estudiante. Si el usuario
     * ingresa valores
     * inválidos (como letras en lugar de números), pide nuevamente el dato hasta
     * que sea
     * válido.
     *
     * @return Estudiante
     * 
     * @author Adrian Romero Maldonado
     */
    public static Estudiante registrarEstudiante() {
        String nombre;
        String matricula;
        int edad = 0;
        Double promedio = 0.0;

        nombre = pedirString("el nombre");
        matricula = pedirString("la matricula");
        edad = pedirEdad();
        promedio = pedirPromedio();
        return (new Estudiante(nombre, edad, promedio, matricula));
    }

    private static int pedirEdad() {
        Boolean valid = false; // Booleano para controlar cuando debo salirme del while.
        int edad = 0;
        while (!valid) {
            try {
                System.out.println("¿Cuál es la edad del estudiante?");
                edad = Integer.parseInt(System.console().readLine());
                valid = true;
            } catch (Exception e) {
                System.out.println(SistemaGestionEstudiantes.RED_BRIGHT + "Error: " + e.getClass()
                        + SistemaGestionEstudiantes.RESET);
                System.out.println(
                        SistemaGestionEstudiantes.GREEN_BRIGHT + "Pruebe de nuevo." + SistemaGestionEstudiantes.RESET);
            }
        }
        return (edad);
    }

    private static double pedirPromedio() {
        Boolean valid = false;
        double promedio = 0;
        while (!valid) { // tengo que hacer dos whiles iguales ya que son distintos tipos de dato.
            try {
                System.out.println("¿Cuál es el promedio del estudiante?");
                promedio = Double.parseDouble(System.console().readLine());
                valid = true; // salgo del bucle
            } catch (Exception e) {
                System.out.println(SistemaGestionEstudiantes.RED_BRIGHT + "Error. " + e.getClass()
                        + SistemaGestionEstudiantes.RESET); // e.getclass, me dice la clase a la que pertenece
                System.out.println(
                        SistemaGestionEstudiantes.GREEN_BRIGHT + "Pruebe de nuevo." + SistemaGestionEstudiantes.RESET); // la
                                                                                                                        // excepcion
            }
        }
        return (promedio);
    }

    private static String pedirString(String requesito) { // controlamos las posibles excepciones que pueda
        Boolean valid = false; // lanzar el metodo readLine.
        String str = "";
        while (!valid) {
            try {
                System.out.println("Digame " + requesito + " del estudiante");
                str = System.console().readLine();
                valid = true;
            } catch (Exception e) {
                System.out.println(SistemaGestionEstudiantes.RED_BRIGHT + "Error. " + e.getClass()
                        + SistemaGestionEstudiantes.RESET);
                System.out.println(
                        SistemaGestionEstudiantes.GREEN_BRIGHT + "Pruebe de nuevo." + SistemaGestionEstudiantes.RESET);
            }
        }
        return (str);
    }

    public static void mostratEstudiante(Estudiante estudiante) {
        System.out.println(estudiante);
    }
}