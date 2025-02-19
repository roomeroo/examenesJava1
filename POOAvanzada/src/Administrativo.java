/**
 * Clase hija de Empleado y que implementa la interfaz CalculosLaborales
 * 
 * @author Adrián Romero
 */
public class Administrativo extends Empleado implements CalculosLaborales {
    private String area;
    private static final int DIAS_VACACIONES = 15; // dias de vacaciones por año trabajado
    private static final int NUMERO_TAREAS = 30; // numero de tareas promedio

    /**
     * Constructor de la clase Administrativo
     * 
     * @param nombre         nombre del empleado
     * @param edad           edad del empleado
     * @param idEmpleado     identificacion del empeleado
     * @param salarioBase    salario del empleado
     * @param anosTrabajados años trabajados del empleado
     */
    Administrativo(String nombre, int edad, String idEmpleado, double salarioBase, int anosTrabajados, String area) {
        super(nombre, edad, idEmpleado, salarioBase, anosTrabajados);
        this.area = area;
    }

    /**
     * Método que me ayuda a calcular la bonificacion segun el numero de tareas y el
     * area del adminitrativo
     * RRHH -> coste por tarea 20€
     * OTRO -> coste por tarea 10€
     * 
     * @return bonificacion
     */
    public double calcularBonificacion() {
        double bonificacion;
        int costeTarea = 20;
        if (area.equalsIgnoreCase("recursos humanos")) {
            costeTarea = 20;
        } else
            costeTarea = 10;
        bonificacion = NUMERO_TAREAS * costeTarea;
        System.out.println(
                utils.YELLOW_BRIGHT + "La bonificacion del administrativo es de: " + bonificacion + utils.RESET);
        return bonificacion;
    }

    /**
     * Método que calcula el salario del administrativo
     *
     * @return salario
     */
    public double calcularSalario() {
        double salario = super.getSalarioBase() + this.calcularBonificacion();
        System.out.println(utils.RED_BRIGHT + "El salario del administrativo es: " + salario + utils.RESET);
        return (salario);
    }

    /**
     * Método que me dice el numero de dias de vacaciones segun años trabajados
     *
     * @return vacaciones numero de dias totales de vacaciones
     */
    public int calcularVacaciones() {
        int vacaciones = super.getAnosTrabajados() * DIAS_VACACIONES;
        System.out.println(
                utils.GREEN_BRIGHT + "El administrativo tiene " + vacaciones + " días de vacaciones." + utils.RESET);
        return (vacaciones);
    }

    @Override
    /**
     * 
     * @return String que resume la clase
     */
    public String toString() {
        return (super.toString() + ", Área: " + area);
    }
}
