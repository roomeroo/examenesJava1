/**
 * Se trata de una clase de un estudiante.
 * 
 * @author Adrián Romero Maldonado
 */
public class Estudiante {
    private String nombre;
    private double notas[];
    private int cantidadNotas = 0;
    private static int maxNotas = 10;

    /**
     * Constructor para mi clase Estudiante.
     * 
     * @param nombre
     */
    Estudiante(String nombre) {
        this.nombre = nombre;
        notas = new double[maxNotas];
        Utils.inicializarArray(notas);
        cantidadNotas = 0;
    }

    /**
     * Esta función me retorna el nombre del estudiante
     * 
     * @return El nombre del estudiante
     */
    public String getNombre() {
        return (nombre);
    }

    /**
     * Fucion que me retorne el promedio del estudiante
     * 
     * @return Promedio del estudiante.
     */
    public double calcularPromedio() {
        double sumatorio = 0.0;
        if (cantidadNotas == 0) {
            return (0.0);
        } else {
            for (int i = 0; i < cantidadNotas; i++) {
                sumatorio += notas[i];
            }
            return (sumatorio / cantidadNotas);
        }

    }

    /**
     * Esta funcion en case de haber espacio me agrega una nota a mi array de notas
     * En caso contrario me imprime un error.
     * 
     * @param nota La nota a agregar
     */
    public void agregarNota(double nota) {
        if (cantidadNotas + 1 > maxNotas) {
            System.out.println(Utils.RED_BRIGHT + "Error, no caben mas notas." + Utils.RESET);
        } else {
            notas[cantidadNotas] = nota;
            cantidadNotas++;
            System.out.println("La nota del estudiante " + nombre + " ha sido introducida de manera satisfactoria.");
        }
    }

    /**
     * Esta función "me da un resumen" de la informacion de mi objeto.
     * 
     * @return String identificativo de mi objeto.
     */
    public String toString() {
        String stringNotas = "";
        for (int i = 0; i < cantidadNotas; i++) {
            stringNotas += notas[i];
            if (i < cantidadNotas - 1)
                stringNotas += ",";
        }
        return ("Estudiante[nombre=" + nombre + ";notas=" + stringNotas + ";" + Utils.GREEN_BRIGHT + "promedio"
                + Utils.RESET + "=" + calcularPromedio() + "]");
    }
}
