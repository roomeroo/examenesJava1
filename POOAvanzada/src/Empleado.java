/**
 * Clase empleado, padre de las clases tecnico, administrativo y gestor
 * 
 * @author Adrián Romero
 */
public abstract class Empleado {
    private String nombre;
    private int edad;
    private String idEmpleado;
    private double salarioBase;
    private int anosTrabajados;
    private static int totalEmpleados = 0;

    /**
     * Constructor super
     * 
     * @param nombre            nombre del empleado
     * @param edad              edad del empleado
     * @param idEmpleado        identificacion del empeleado
     * @param salarioBase       salario del empleado
     * @param anosTrabajados    años trabajados del empleado
     */
    Empleado(String nombre, int edad, String idEmpleado, double salarioBase, int anosTrabajados) {
        this.nombre = nombre;
        this.edad = utils.comprobarValidez(edad);
        this.idEmpleado = idEmpleado;
        this.salarioBase = utils.comprobarValidez(salarioBase);
        this.anosTrabajados = utils.comprobarValidez(anosTrabajados);
        totalEmpleados++;
    }

    /**
     * Getter de total empleados
     * 
     * @return totalEmpleados
     */
    public static int getTotalEmpleados() {
        return (totalEmpleados);
    }

    /**
     * setter del nombre del empleado
     * 
     * @param nombeEmpleado
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * getter del nombre del empleado
     * 
     * @return nombre
     */
    public String getNombre() {
        return (nombre);
    }

    /**
     * setter del identificador del empleado
     * 
     * @param idEmpleado
     */
    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    /**
     * getter del idEmpleado
     * 
     * @return idEmpleado
     */
    public String getIdEmpleado() {
        return (idEmpleado);
    }

    /**
     * setter del salario base del empleado (En caso negativo el valor por defecto
     * es 0)
     * 
     * @param salarioBase
     */
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    /**
     * Salario base del empleado
     * 
     * @return salarioBase
     */
    public double getSalarioBase() {
        return (salarioBase);
    }

    /**
     * setter de los años trabajados por el empleado (En caso negativo el valor por
     * defecto es 0)
     * 
     * @param anosTrabajados
     */
    public void setAnosTrabajados(int anosTrabajados) {
        this.anosTrabajados = anosTrabajados;
    }

    /**
     * getter de los años trabajados por el empleado
     * 
     * @return anosTrabajados
     */
    public int getAnosTrabajados() {
        return (anosTrabajados);
    }

    /**
     * metodo toString
     * 
     * @return String que 'resume' la clase
     */
    public String toString() {
        return ("Empleado: " + nombre + ", Edad: " + edad + ", ID: " + idEmpleado + ", Salario base: " + salarioBase
                + ", Años de trabajo: " + anosTrabajados);
    }
}
