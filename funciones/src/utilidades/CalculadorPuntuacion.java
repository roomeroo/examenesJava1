package utilidades;

public class CalculadorPuntuacion {

    /**
     * 
     * @param carta El valor de mi carta
     * @param dado  El valor de mi dado
     * @return Devuelve la puntuacion obtenida por el jugador en la ronda
     */
    public static double calculador(int carta, int dado) {
        double bonus = 0;
        if (carta % 2 == 0) {
            bonus = 0.1;
        } else {
            bonus = -0.05;
        }

        return (carta + dado + (carta * bonus));
    }
}
