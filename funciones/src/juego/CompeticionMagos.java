package juego;

import utilidades.CalculadorPuntuacion;
import utilidades.GeneradorAleatorio;
import utilidades.ImpresoraPuntuacion;

public class CompeticionMagos {
    /**
     * Esta funcion, es mi main. Donde esta el ejercicio completo.
     * 
     * 
     * 
     * @param arguments String de ordenes que se mandan a la funcion (No usado en
     *                  este proyecto)
     * 
     * @author Adrian Romero Maldonado
     */
    public static void main(String[] arguments) { /* Mensaje de bienvenida */
        System.out.println("############################################");
        System.out.println("\nBienvenido a " + ImpresoraPuntuacion.YELLOW_BRIGHT + "LA COMPETICIÓN DE  LOS MAGOS"
                + ImpresoraPuntuacion.RESET);
        System.out.println("\n############################################\n");
        String jugar = "";
        System.out.print("¿Desea comenzar el juego?(Si/No) ");
        jugar = System.console().readLine();

        if (jugar.equals("si") || jugar.equals("Si")) {

            /* Declaracion de variables */
            double puntuacion1 = 0;
            double puntuacion2 = 0;
            int ganador = 0;
            int jugador1 = 0;
            int jugador2 = 0;
            double total1 = 0;
            double total2 = 0;
            for (int ronda = 0; ronda < 5; ronda++) {
                int dado1 = GeneradorAleatorio.generarDado();
                int carta1 = GeneradorAleatorio.generarCarta();
                puntuacion1 = CalculadorPuntuacion.calculador(carta1, dado1);
                int dado2 = GeneradorAleatorio.generarDado();
                int carta2 = GeneradorAleatorio.generarCarta();
                puntuacion2 = CalculadorPuntuacion.calculador(carta2, dado2);
                ganador = ImpresoraPuntuacion.ImprimirRonda(puntuacion1, puntuacion2, jugador1, jugador2, total1,
                        total2);
                if (ganador == 1) { // Debo volver a sumarlo fuera ya que no puedo retornar varios valores
                    jugador1++; // y por como he planteado el ejercicio me es necesario
                } else if (ganador == 2) {
                    jugador2++;
                }
                total1 += puntuacion1;
                total2 += puntuacion2;

                if (ronda != 4) { // Omito este paso en caso de ser la ultima ronda
                    System.out.println("\n" + ImpresoraPuntuacion.YELLOW_BRIGHT
                            + " Pulse enter para pasar a la siguiente ronda" + ImpresoraPuntuacion.RESET);
                    System.console().readLine();
                }
            }
            System.out.println("\n\n\nEl juego ha terminado");
            if (jugador1 > jugador2) {
                System.out
                        .println("El jugador 1 ha ganado la partida con un total de " + jugador1 + " rondas ganadas y "
                                + ImpresoraPuntuacion.YELLOW_BRIGHT + total1 + " puntos." + ImpresoraPuntuacion.RESET);
            } else if (jugador2 > jugador1) {
                System.out
                        .println("El jugador 2 ha ganado la partida con un total de " + jugador2 + " rondas ganadas y "
                                + ImpresoraPuntuacion.YELLOW_BRIGHT + total2 + " puntos." + ImpresoraPuntuacion.RESET);
            } else {
                System.out.println("Ha habido un empate:");
                System.out.printf(
                        "Jugador 1" + jugador1 + " rondas ganadas y " + ImpresoraPuntuacion.YELLOW_BRIGHT + "%.2f"
                                + " puntos.\n" + ImpresoraPuntuacion.RESET,
                        total1);
                System.out.printf(
                        "Jugador 2" + jugador2 + " rondas ganadas y" + ImpresoraPuntuacion.YELLOW_BRIGHT + "%.2f"
                                + " puntos.\n" + ImpresoraPuntuacion.RESET,
                        total2);
            }
        } else {
            System.out.println("Prorama terminado");
        }
    }
}
