/**
 * Clase principal.
 * 
 * @author Adrian Romero
 */
public class PruebaServiciosHotel {
    public static void main(String[] args) throws Exception {
        int opcion = -1;
        boolean salir = false;

        /**
         * Menú principal del programa.
         * 
         */
        do {
            System.out.println(Utils.limpiarPantalla);
            System.out.println("Que quieres hacer:");
            System.out.println("1. Consultar la tabla.");
            System.out.println("2. Añadir un nuevo servicio.");
            System.out.println("3. Borrar un hotel.");
            System.out.println("4. Borrar un servicio.");
            System.out.println("5. Salir.");
            System.out.print("Respuesta: ");
            opcion = Utils.pedirInt();
            switch (opcion) {
                case 1:
                    ServiciosHotel.mostrarHotel();
                    break;
                case 2:
                    ServiciosHotel.añadirServicio();
                    break;
                case 3:
                    ServiciosHotel.borrarHotel();
                    break;
                case 4:
                    ServiciosHotel.borrarServicio();
                    break;
                case 5:
                    System.out.println("Adios!"); // diferencio la salida dle programa (5)
                    salir = true; // de cualquier entrada que este fuera dle rango (default)
                    break;

                default:
                    System.out.println("Numero fuera de rango.");
                    break;
            }
            System.out.println("Presione enter para seguir...");
            System.console().readLine();
        } while (!salir);

    }
}
