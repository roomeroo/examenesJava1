public class ChicagoDices {
    public static final String RED_BRIGHT = "\033[0;91m"; // RED
    public static final String GREEN_BRIGHT = "\033[0;92m"; // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String RESET = "\033[0m"; // Text Reset

    public static void main(String[] args) throws Exception {
        int ronda = 1;
        int punObjetivo = 2;
        int puntuacion1 = 0;
        int puntuacion2 = 0;
        int puntuacion3 = 0;

        /*  Inicializo y declaro la mayoria de mis variables */
        System.out.println(YELLOW_BRIGHT + "CHICAGO" + RESET + "\n");
        while (ronda <= 11) {
            System.out.println(RED_BRIGHT + "Ronda " + ronda + " ; Puntuación objetivo: " + punObjetivo + RESET);
            puntuacion1 += hacerRonda(ronda, 1);
            puntuacion2 += hacerRonda(ronda, 2);
            puntuacion3 += hacerRonda(ronda, 3);
            System.out.println("Puntuaciones generales: Jugador 1 - " + puntuacion1 + singularPlural(puntuacion1)
                    + " ; Jugador 2 - " + puntuacion2 + singularPlural(puntuacion2) + " ; Jugador 3 - " + puntuacion3
                    + singularPlural(puntuacion3) + "\n"); /* imprimo las puntuaciones generales, y uso funcion que retorna */
            if (ronda != 11) {                          /* una string para manejar los casos de plural o singular */
                System.out.print("Pulse INTRO para la siguiente ronda ");
                System.console().readLine();    /* Utilizo esto para obligar al programa a pausarse mientras */
                System.out.println("");       /* No reciba una entrada */
            }
            punObjetivo++;
            ronda++;
        }
        System.out.println("\nFin de la partida");
    }

    public static int random(int min, int max) {
        return ((int) (Math.random() * (max - min + 1)) + min);
    }

    public static int hacerRonda(int ronda, int jugador) {          /*Utilizo esta funcion para que me haga las */
        int puntuacion = 0;                             /*rondas sin contar la impresión de la puntuación general */
        int tirada1 = random(1, 6);
        int tirada2 = random(1, 6);
        if (tirada1 + tirada2 == ronda + 1)
            puntuacion = 1;
        System.out.print("Tirada del jugador " + jugador + ": " + tirada1 + "-" + tirada2 + " ; " + puntuacion);
        if (puntuacion == 1) {
            System.out.println(" punto.");
        } else
            System.out.println(" puntos.");
        return (puntuacion);
    }

    public static String singularPlural(int x) {        /*Función para calcular si debe o no acabar en s */
        if (x == 1) {
            return (" punto");
        } else
            return (" puntos");
    }
}
  