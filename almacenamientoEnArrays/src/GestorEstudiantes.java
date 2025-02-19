/**
 * Se trata de una clase que gestiona objetos de alumnos.
 * 
 * @author Adrián Romero Maldonado
 */
public class GestorEstudiantes {
    static int maxEstudiantes = 20;
    Estudiante estudiantes[] = new Estudiante[maxEstudiantes];
    int cantidadEstudianes = 0;

    /**
     * Constructor de mi clase Gestora de estudiantes.
     * 
     */
    GestorEstudiantes() {
        Utils.inicializarArray(estudiantes);
    }

    /**
     * Función que me agrega estudiantes y además me controla que no haya mas
     * alumnos con el mismo nombre
     * 
     * @param nombre nombre con el que crear/comparar los estudiantes.
     */
    public void agregarEstudiante(String nombre) {
        if (cantidadEstudianes < maxEstudiantes) {
            if (buscarEstudiante(nombre) == null) { // Compruebo que no haya mas estudiantes con ese nombre
                System.out.println(Utils.GREEN_BRIGHT + nombre + " se une a la plantilla." + Utils.RESET);
                estudiantes[cantidadEstudianes] = new Estudiante(nombre);
                cantidadEstudianes++;
            } else
                System.out.println(
                        Utils.YELLOW_BRIGHT + "Lo sentimos, ya tenemos un estudiante con ese nombre." + Utils.RESET);
        } else
            System.out.println(Utils.YELLOW_BRIGHT + "No hay espacio para el alumno " + nombre + Utils.RESET);
    }

    /**
     * Funcion que me busca el estudiante que le indico con el nombre.
     * 
     * @param nombre nombre con el que buscar el estudiante
     * @return retorna un objeto del estudiante deseado o en caso contrario devuelve
     *         nulo
     */
    public Estudiante buscarEstudiante(String nombre) {
        for (int i = 0; i < cantidadEstudianes; i++) {
            if (estudiantes[i].getNombre().equalsIgnoreCase(nombre))
                return (estudiantes[i]);
        }
        return (null);
    }

    /**
     * Función que me asigna una nota al estudiante.
     * 
     * @param nombre Nombre del estudiante al que le voy a asignar la nota
     * @param nota   Nota que le voy a asignar al alumno
     */
    public void agregarNotaEstudiante(String nombre, double nota) {
        if (buscarEstudiante(nombre) != null) { // busco estudiante, miro su nombre y lo comparo
            buscarEstudiante(nombre).agregarNota(nota);
        } else
            System.out.println(Utils.YELLOW_BRIGHT + "Estudiante no encontrado." + Utils.RESET);
    }

    /**
     * Función para mostrar todos mis estudiantes.
     */
    public void mostrarEstudiantes() {

        if (cantidadEstudianes > 0) {
            System.out.println("Estos son los estudiantes:");
            for (int i = 0; i < cantidadEstudianes; i++) {
                System.out.println(estudiantes[i]);
            }
        } else {
            System.out.println(Utils.YELLOW_BRIGHT + "No hay estudiantes todavia..." + Utils.RESET);
        }
    }

    /**
     * Función para mostrar todos los estudiantes que superen el umbral indicado.
     * 
     * @param promedio Promedio al que superar para ser mostrado.
     */
    public void mostrarEstudiantesConPromedioMayorA(double promedio) {
        System.out.println("Estos son los estudiantes con un promedio mayor a " + promedio + ":");
        int cantidad = 0;
        for (int i = 0; i < cantidadEstudianes; i++) {
            if (estudiantes[i].calcularPromedio() > promedio) { // mayor estricto
                System.out.println(estudiantes[i]);
                cantidad++;
            }
        }
        if (cantidad == 0)
            System.out.println(Utils.YELLOW_BRIGHT + "Ningun estudiante supera ese promedio" + Utils.RESET);
    }
}
