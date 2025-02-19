/**
 * Clase de funciones auxiliares.
 * 
 * @author Adrián Romero Maldonado
 */
public class Utils {
    public static final String RED_BRIGHT = "\033[0;91m"; // RED
    public static final String GREEN_BRIGHT = "\033[0;92m"; // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String RESET = "\033[0m"; // Text Reset
    public static final String limpiarPantalla = "\n\n\n\n\n\n\n\n\n\n\n"; // limpiar pantalla.

    /**
     * Funcion para capitalizar una palabra. (Poner la primera letra en mayúscula).
     * 
     * @param str String que me quiero capitalizar.
     * @return String capitalizado.
     */
    public static String capitalizeStr(String str) {
        String capitalized = "";
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                String primerCaracter = Character.toString(str.charAt(i)); // Pongo mi primera letra en un string y
                primerCaracter = primerCaracter.toUpperCase(); // convierto el string entero a mayusculas
                capitalized += primerCaracter; // Para luego sumarlo a mi string definitivo
            } else {
                capitalized += str.charAt(i);
            }

        }
        return (capitalized);
    }

    /**
     * Función para evitar excepciones.
     * 
     * @return String correcto.
     */
    public static String pedirString() {
        String str = "";
        boolean status = false;

        while (!status) {
            try {
                str = System.console().readLine();
                status = true;
            } catch (Exception ex) {
                System.out.println(RED_BRIGHT + "Error. No has ingresado un string válido." + RESET);
                System.out.println(ex.getMessage());
                System.out.println(YELLOW_BRIGHT + "Pruebe de nuevo." + RESET);
            }
        }
        return (str);
    }

    /**
     * Función para evitar excepciones.
     * 
     * @return numero entero correcto.
     */
    public static int pedirInt() {
        int numero = 0;
        boolean status = false;

        while (!status) {
            try {
                numero = Integer.parseInt(System.console().readLine());
                status = true;
            } catch (Exception ex) {
                System.out.println("Error. No has ingresado un numero válido.");
                System.out.println(ex.getMessage());
                System.out.println("Pruebe de nuevo.");
            }
        }
        return (numero);
    }
}
