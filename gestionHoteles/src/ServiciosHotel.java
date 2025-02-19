import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase donde encontramos las principales funciones.
 * 
 * @author Adrián Romero Maldonado
 */
public class ServiciosHotel {
    private static HashMap<String, ArrayList<String>> hoteles = iniciarBaseDatos(
            new HashMap<String, ArrayList<String>>());

    /**
     * Función para inicializar la base de datos.
     * Dato a anotar: Uso un estilo, El nombre de los hoteles empiezan por
     * mayúsculas. Mientras
     * que los servicios no, ya que están listados.
     * 
     * @param hoteles diccionario donde se encuentran todos mis hoteles
     * @return mi diccionario ya con los valores por defecto.
     */
    public static HashMap<String, ArrayList<String>> iniciarBaseDatos(HashMap<String, ArrayList<String>> hoteles) {
        hoteles.put("Cazorla", new ArrayList<String>());
        hoteles.get("Cazorla").add("restaurante");
        hoteles.get("Cazorla").add("piscina");
        hoteles.get("Cazorla").add("actividades");
        hoteles.get("Cazorla").add("lavandería");
        hoteles.put("Aroche", new ArrayList<String>());
        hoteles.get("Aroche").add("desayuno");
        hoteles.get("Aroche").add("cafetería");
        hoteles.get("Aroche").add("tienda");
        hoteles.get("Aroche").add("internet");
        hoteles.get("Aroche").add("cuna");
        hoteles.put("Barbate", new ArrayList<String>());
        hoteles.get("Barbate").add("aparcamiento");
        hoteles.get("Barbate").add("televisión");
        hoteles.get("Barbate").add("tienda");
        hoteles.get("Barbate").add("gimnasio");

        return (hoteles);
    }

    /**
     * Funcion para mostrar los servicios del hotel.
     * 
     */
    public static void mostrarHotel() {
        System.out.println("¿De que hotel quieres que te muestre los servicios?");
        String hotel = Utils.pedirString();
        hotel = Utils.capitalizeStr(hotel);
        if (hoteles.containsKey(hotel)) {
            System.out.println("Estos son los servicios que tenemos sobre este hotel:");
            ArrayList<String> lista = hoteles.get(hotel);
            for (int i = 0; i < lista.size(); i++) {
                if (i == lista.size() - 1) {
                    System.out.print(lista.get(i) + "."); // Me aseguro de que acabe en '.' y no en ','
                } else if (i == 0) {
                    System.out.print(Utils.capitalizeStr(lista.get(i)) + ", "); // me aseguro de que la primera letra de
                                                                                // la primera palabra este en
                                                                                // mayusculas.
                } else
                    System.out.print(lista.get(i) + ", ");
            }
            System.out.println();
        } else {
            System.out.println("Lo siento no tenemos ese hotel.");
        }
    }

    /**
     * Funcion para añadir servicios
     * 
     */
    public static void añadirServicio() {
        System.out.println("¿A qué hotel desea añadirle un servicio?");
        String hotel = Utils.pedirString();
        hotel = Utils.capitalizeStr(hotel);
        if (hoteles.containsKey(hotel)) {
            System.out.println("¿Qué servicio desea añadir?");
            String servicio = Utils.pedirString();
            servicio.toLowerCase();
            if (!hoteles.get(hotel).contains(servicio)) {
                hoteles.get(hotel).add(servicio);
            } else {
                System.out.println("Lo siento, el hotel de " + hotel + " ya tiene ese servicio.");
            }
        } else {
            hoteles.put(hotel, new ArrayList<String>());
            System.out.println("No teniamos ese hotel!. Que servicio deseas añadirle al hotel " + hotel);
            String servicio = Utils.pedirString();
            servicio = servicio.toLowerCase();
            hoteles.get(hotel).add(servicio);
        }
    }

    /**
     * Funcion para borrar una entrada del diccionario
     * 
     */
    public static void borrarHotel() {
        System.out.println("¿Qué hotel desea borrar?");
        String hotel = Utils.pedirString();
        hotel = Utils.capitalizeStr(hotel);
        if (hoteles.containsKey(hotel)) {
            hoteles.remove(hotel);
            System.out.println("Ok. Hotel borrado.");
        } else
            System.out.println("Hotel no encontrado.");
    }

    /**
     * Fucion para borrar el servicio.
     * 
     */
    public static void borrarServicio() {
        System.out.println("¿De qué hotel desea borrar el servicio?");
        String hotel = Utils.pedirString();
        hotel = Utils.capitalizeStr(hotel);
        if (hoteles.containsKey(hotel)) {
            System.out.println("¿Y qué servicio desea borrar¿");
            String servicio = Utils.pedirString();
            servicio = servicio.toLowerCase();
            if (hoteles.get(hotel).contains(servicio)) {
                hoteles.get(hotel).remove(servicio);
                System.out.println("Servicio borrado.");
            } else
                System.out.println("El hotel " + hotel + " no tiene ese servicio");
        } else
            System.out.println("No tenemos ese hotel.");
    }
}
