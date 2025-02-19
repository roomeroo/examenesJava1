/**
 * Clase hija de Empleado y que implementa la interfaz CalculosLaborales
 * 
 * @author Adrián Romero
 */
public class Gestor extends Empleado implements CalculosLaborales {
    private double presupuesto;
    private static final int DIAS_VACACIONES = 30;

    /**
     * Construtor de mi clase Gestor
     * 
     * @param nombre         nombre del empleado
     * @param edad           edad del empleado
     * @param idEmpleado     identificacion del empeleado
     * @param salarioBase    salario del empleado
     * @param anosTrabajados años trabajados del empleado
     */
    Gestor(String nombre, int edad, String idEmpleado, double salarioBase, int anosTrabajados, double presupuesto) {
        super(nombre, edad, idEmpleado, salarioBase, anosTrabajados);
        this.presupuesto = presupuesto;
    }

    /**
     * Método que calcula la bonificacion que es el 5% del presupuesto
     * 
     * @return bonificacion
     * 
     */
    public double calcularBonificacion() {
        double bonificacion = (0.05) * presupuesto;
        System.out.println(utils.YELLOW_BRIGHT + "La bonificación es de " + bonificacion + utils.RESET);
        return (bonificacion);
    }

    /**
     * Método que calcula el salario
     * 
     * @return salario
     * 
     */
    public double calcularSalario() {
        double salario = super.getSalarioBase() + this.calcularBonificacion();
        System.out.println(utils.RED_BRIGHT + "El salario del gestor es: " + salario + utils.RESET);
        return (salario);
    }

    /**
     * Método que calcula el numero de dia de las vacaciones
     * 
     * @return vacaciones. numero de dias de vacaciones
     */
    public int calcularVacaciones() {
        int vacaciones = super.getAnosTrabajados() * DIAS_VACACIONES;
        System.out.println(utils.GREEN_BRIGHT + "El gestor tiene " + vacaciones + " días de vacaciones." + utils.RESET);
        return (vacaciones);
    }

    @Override
    /**
     * Método toString
     * 
     * @return String que resume la clase Gestor.
     */
    public String toString() {
        return (super.toString() + ", Presupuesto: " + presupuesto + " €.");
    }
}
