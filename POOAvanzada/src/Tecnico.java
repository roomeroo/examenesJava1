/**
 * Clase hija de Empleado y que implementa la interfaz CalculosLaborales
 * 
 * @author Adrián Romero
 */
public class Tecnico extends Empleado implements CalculosLaborales {
    private String especialdad;
    private static final int DIAS_VACACIONES = 20; // variable constante que me dice el numero de dias de vacaciones
                                                   // por año trabajado.

    /**
     * Constructor de la clase Tecnico
     * 
     * @param nombre         nombre del empleado
     * @param edad           edad del empleado
     * @param idEmpleado     identificacion del empeleado
     * @param salarioBase    salario del empleado
     * @param anosTrabajados años trabajados del empleado
     */
    Tecnico(String nombre, int edad, String idEmpleado, double salarioBase, int anosTrabajados, String especialidad) {
        super(nombre, edad, idEmpleado, salarioBase, anosTrabajados);
        this.especialdad = especialidad;
    }

    /**
     * Método que me dice la bonificacion segun la especialidad.
     * REDES - 1000
     * SEGURIDAD - 1200
     * OTRO - 800
     * 
     * @return bonificacion.
     */
    public double calcularBonificacion() {
        if (especialdad.equalsIgnoreCase("redes")) {
            System.out.println(
                    utils.YELLOW_BRIGHT + "La bonificación por ser un técnico en redes es de: 1000" + utils.RESET);
            return (1000);
        } else if (especialdad.equalsIgnoreCase("seguridad")) {
            System.out.println(
                    utils.YELLOW_BRIGHT + "La bonificación por ser un técnico en seguridad es de: 1200" + utils.RESET);
            return (1200);
        } else {
            System.out.println(utils.YELLOW_BRIGHT + "La bonificación por ser un técnico en otra especialidad es: 800"
                    + utils.RESET);
            return (800);
        }
    }

    /**
     * Método que me ayuda a calcular el salario.
     * 
     * @return salario
     */
    public double calcularSalario() {
        double salario = super.getSalarioBase() + this.calcularBonificacion();
        System.out.println(utils.RED_BRIGHT + "El salario del técnico es: " + salario + utils.RESET);
        return (salario);
    }

    /**
     * Método que me calcula el numero de dias de vacaciones del empleado.
     * 
     * @return vacaciones
     */
    public int calcularVacaciones() {
        int vacaciones = super.getAnosTrabajados() * DIAS_VACACIONES;
        System.out
                .println(utils.GREEN_BRIGHT + "El técnico tiene " + vacaciones + " días de vacaciones." + utils.RESET);
        return (vacaciones);
    }

    @Override
    /**
     * Método sobreescrito de la clase padre. Añadiendo la varibale especialidad.
     * 
     * @return String que resume la calse Tecnico
     */
    public String toString() {
        return (super.toString() + ", Especialidad: " + especialdad + ".");
    }
}
