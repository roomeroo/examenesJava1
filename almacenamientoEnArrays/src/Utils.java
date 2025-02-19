/**
 * Clase de funciones independientes que uso para simplificar.
 * 
 */
public class Utils {
    /**
     * String que uso para "limpiar" la pantalla.
     */
    public final static String limpiarPantalla = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
    public static final String RED_BRIGHT = "\033[0;91m"; // RED
    public static final String GREEN_BRIGHT = "\033[0;92m"; // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String RESET = "\033[0m"; // Text Reset

    /**
     * Función que uso para inicializar mis valores.
     * 
     * @param array array que inicializo con valor 0.0
     */
    public static void inicializarArray(double array[]) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 0.0;
        }
    }

    /**
     * Función que uso para inicializar mis valores.
     * 
     * @param array array que inicializo con valor nulo
     */
    public static void inicializarArray(Estudiante array[]) {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    /**
     * Función para asegurarme el correcto valor del numero real
     * 
     * @return numero real
     */
    public static double introducirReal() {
        double nota = 0.0;
        boolean bien = false;
        boolean rango = false;
        do {
            try {
                bien = false;
                rango = false;
                System.out.println("¿Qué nota desea agregar?");
                nota = Double.parseDouble(System.console().readLine());
                bien = true;
                if (nota >= 0 && nota <= 10) {
                    rango = true;
                } else
                    System.out.println("Número fuera de rango 0-10");

            } catch (Exception ex) {
                System.out.println(RED_BRIGHT + "No ha introducido un número real válido." + RESET);
                System.out.println(YELLOW_BRIGHT + "Error: " + ex.getMessage() + RESET);
            }
        } while (bien == false || rango == false);
        return (nota);
    }

    /**
     * Funcion simple para poder pausar el programa.
     */
    public static void pausa() {
        System.out.println("Pulse enter para continuar...");
        System.console().readLine();
    }

}
