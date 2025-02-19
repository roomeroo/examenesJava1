/**
 * Clase utils.
 * Clase donde guardo funciones y variables globales.
 * 
 * @author Adrián Romero
 */
public class utils {
    public static final String RED_BRIGHT = "\033[0;91m"; // RED
    public static final String GREEN_BRIGHT = "\033[0;92m"; // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String RESET = "\033[0m"; // Text Reset

    /**
     * Método que comprueba la validez de un numero decimal.
     * 
     * @param numero El numero a comprobar su validez
     * @return El numero o 0 en caso de negativo
     */
    public static double comprobarValidez(double numero) {
        if (numero >= 0)
            return (numero);
        return (0);
    }

    /**
     * Método que comprueba la validez de un numero entero
     * 
     * @param numero El numero a comprobar su validez
     * @return El numero o 0 en caso de negativo
     */
    public static int comprobarValidez(int numero) {
        if (numero >= 0)
            return (numero);
        return (0);
    }
}
