public class plataformaDigital {
    public static final String RED_BOLD = "\033[1;31m"; // RED
    public static final String GREEN_BACKGROUND = "\033[42m"; // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String RESET = "\033[0m"; // Text Reset
    public static final String EURO = "\u20ac"; // codigo ASCII del euro

    public static void main(String[] args) throws Exception {
        String nombre;
        int edad;
        int suscripcion;
        String tipo = null;
        double descuento = 0;
        int precio = 0;
        System.out.println(GREEN_BACKGROUND + "¡Bienvenido/a a la plataforma digital!" + RESET + "\n");
        System.out.print("Por favor, dinos tu nombre: ");
        nombre = System.console().readLine();
        System.out.print("Por favor, dinos tu edad: ");
        edad = Integer.parseInt(System.console().readLine());
        if (edad >= 18) {
            if (edad > 18 && edad <= 25) { /* AQUÍ ESTOY REVISANDO LA EDAD PARA SABER QUE DESCUENTO HACER */
                descuento = 0.2; /* Y ADEMAS MANEJO LOS CORRESPONIENTES MENSAJES */
            } else if (edad <= 40) {
                descuento = 0.1;
            } else {
                descuento = 0;
            }

            System.out.println("\n¡Gracias por registrarte, " + nombre);
            System.out.println("Selecciona el tipo de suscripción que deseas:");
            System.out.println("1. Básica - 10" + EURO);
            System.out.println("2. Estándar - 15" + EURO);
            System.out.println("3. Premium - 20" + EURO);
            suscripcion = Integer.parseInt(System.console().readLine());
            switch (suscripcion) {
                case 1:
                    precio = 10; /* Manejo los precios segun las entradas */
                    tipo = "Básica";
                    break;

                case 2:
                    precio = 15;
                    tipo = "Estándar";
                    break;

                case 3:
                    precio = 20;
                    tipo = "Premium";
                    break;

                default:
                    System.out.println("Entrada no válida.");
                    break;
            }
            if (suscripcion > 0 && suscripcion < 4) {
                System.out.println("\nResumen de tu registro:");
                System.out.println("Nombre: " + nombre);
                System.out.println("Tipo de suscripción: " + tipo); /* Escribimos el resumen de registro */
                System.out.println("Precio original: " + precio + EURO);
                System.out.println("Descuento aplicado: " + (int) (descuento * 100) + "%");
                System.out.print("Precio final: ");
                System.out.printf(RED_BOLD + "%.2f", (precio - (precio * descuento)));
                System.out.println(EURO + RESET + "\n");
                if (suscripcion == 3 && descuento == 0.2) { /* AQUI SE MANEJAN LOS POSBILES MENSAJES */
                    System.out.println(YELLOW_BACKGROUND
                            + "¡Felicidades, estás aprovechando al máximo nuestra plataforma!" + RESET);
                } else if (descuento == 0.1 && suscripcion == 2) {
                    System.out.println(YELLOW_BACKGROUND
                            + "Buena elección para disfrutar de contenido de calidad a un buen precio." + RESET);
                } else if (descuento == 0 && suscripcion == 1) {
                    System.out.println(YELLOW_BACKGROUND
                            + "¡Gracias por unirte! Esperamos que disfrutes del contenido básico." + RESET);
                } else
                    System.out.println(YELLOW_BACKGROUND + "Gracias por registrarte en nuestra plataforma." + RESET);
            }
        } else
            System.out.println("\nNo es legible para registrarse.");

    }
}