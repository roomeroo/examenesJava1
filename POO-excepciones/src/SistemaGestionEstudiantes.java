public class SistemaGestionEstudiantes {
    public static final String RED_BRIGHT = "\033[0;91m"; // RED
    public static final String GREEN_BRIGHT = "\033[0;92m"; // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String RESET = "\033[0m"; // Text Reset

    public static void main(String[] args) throws Exception {
        System.out.println("Vamos con el primer estudiante:");
        Estudiante estudiante1 = GestionEstudiantes.registrarEstudiante();
        System.out.println("Y a continuacion vamos con el segundo estudiante:");
        Estudiante estudiante2 = GestionEstudiantes.registrarEstudiante();
        System.out.println("A continuacion vamos a mostrar los dos estudiantes y a compararlos.");
        GestionEstudiantes.mostratEstudiante(estudiante1);
        GestionEstudiantes.mostratEstudiante(estudiante2);

        System.out.print("El alumno con mayor promedio es: ");
        if (estudiante1.getPromedio() > estudiante2.getPromedio()) {
            System.out.print("El alumno con mayor promedio es: " + YELLOW_BRIGHT + estudiante1.getNombre() + RESET);
        } else if (estudiante1.getPromedio() < estudiante2.getPromedio()) {
            System.out.print("El alumno con mayor promedio es: " + YELLOW_BRIGHT + estudiante2.getNombre() + RESET);
        } else
            System.out.println(GREEN_BRIGHT + "Los dos estudiantes han obtenido el mismo promedio." + RESET);
    }
}