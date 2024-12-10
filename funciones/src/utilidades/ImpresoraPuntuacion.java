package utilidades;

/**
 *
 * 
 * 
 * Pongo aqui los colores para no usar mas clases de las que me mandan.
 * 
 * @author Adrian Romero Maldonado.
 */
public class ImpresoraPuntuacion {
    public static final String RED_BRIGHT = "\033[0;91m"; // RED
    public static final String GREEN_BRIGHT = "\033[0;92m"; // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String RESET = "\033[0m"; // Text Reset

    /**
     * 
     * @param puntuacion1 Puntuacion de la ronda de mi jugador 1
     * @param puntuacion2 Puntuacion de la ronda de mi jugador 2
     * @return Devuelve el ganador de la ronda
     */
    public static int imprimirResultados(double puntuacion1, double puntuacion2) {
        if (puntuacion1 == puntuacion2) {
            System.out.println("Ha habido un empate entre el jugador 1 y el jugador 2.");
            return (0);
        } else if (puntuacion1 > puntuacion2) {
            System.out.println("El jugador 1 ha ganado la ronda");
            return (1);
        } else {
            System.out.println("El jugador 2 ha ganado la ronda.");
            return (2);
        }
    }

    /**
     * Esta funcion la uso solo para saber quien es el ganador de la ronda para
     * poder imprimir
     * de un color u otro
     * 
     * @param jugador jugador al que corresponde el mensaje
     * @param ganador Quien ha ganado la ronda 1. Jugador1 2.Jugador2
     * @return Devuelve un string rojo si pierde y uno verde si gana
     */
    public static String ganador(int jugador, int ganador) {
        if (jugador == ganador)
            return (GREEN_BRIGHT);
        return (RED_BRIGHT);
    }

    /**
     * 
     * @param puntuacion1 La puntuacion de la ronda de mi jugador 1
     * @param puntuacion2 La puntuacion de la ronda de mi jugador 2
     * @param jugador1    El numero de victorias que lleva el jugador1 sin contar la
     *                    actual
     * @param jugador2    El numero de victorias que lleva el jugador2 sin contar la
     *                    actual
     * @param total1      Total de puntaje de la partida del jugador1
     * @param total2      Total de puntaje de la partida del jugador2
     * @return Retorna el ganador de la ronda.
     */
    public static int ImprimirRonda(double puntuacion1, double puntuacion2, int jugador1, int jugador2, double total1,
            double total2) {
        int ganador = imprimirResultados(puntuacion1, puntuacion2);
        if (ganador == 1) {
            jugador1++;
        } else if (ganador == 2) {
            jugador2++;
        }
        System.out.printf("El jugador 1 lleva una puntuacion de " + "%.2f" + " y " + ganador(1, ganador) + jugador1
                + " rondas ganadas.\n" + RESET, (puntuacion1 + total1));
        System.out.printf("El jugador 2 lleva una puntuacion de " + "%.2f" + " y " + ganador(2, ganador) + jugador2
                + " rondas ganadas.\n" + RESET, (puntuacion2 + total2));
        return (ganador);
    }
}
