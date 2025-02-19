/**
 * Clase principal.
 * 
 * @author Adrián Romero Maldonado
 */
public class SistemaGestorEmpleados {
    public static void main(String[] args) {
        Empleado empleados[] = new Empleado[3];

        empleados[0] = new Tecnico("Juan Pérez", 38, "T003", 2100, 5, "Redes");
        empleados[1] = new Gestor("Ana González", 43, "G017", 3000, 8, 65000);
        empleados[2] = new Administrativo("Carlos Cieza", 34, "A009", 1500, 2, "Recursos humanos");

        System.out.println(empleados[0]);
        ((CalculosLaborales) empleados[0]).calcularSalario();
        ((CalculosLaborales) empleados[0]).calcularVacaciones();

        System.out.println(empleados[1]);
        ((CalculosLaborales) empleados[1]).calcularSalario();
        ((CalculosLaborales) empleados[1]).calcularVacaciones();

        System.out.println(empleados[2]);
        ((CalculosLaborales) empleados[2]).calcularSalario();
        ((CalculosLaborales) empleados[2]).calcularVacaciones();

        System.out.println("El numero total de empleados es de: " + Empleado.getTotalEmpleados());
    }
}
