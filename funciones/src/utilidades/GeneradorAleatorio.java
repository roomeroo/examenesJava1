package utilidades;

public class GeneradorAleatorio {
    /**
     * Esta funcion me genera un numero random entre 1 y 40
     * 
     * @return El numero aleatorio
     *
     */

    public static int generarCarta() {
        return ((int) (Math.random() * (40)) + 1);
    }

    /**
     * Esta funcion me genera un numero random entre 1 y 6
     * 
     * @return El numero aleatorio
     */

    public static int generarDado() {
        return ((int) (Math.random() * (6)) + 1);
    }
}