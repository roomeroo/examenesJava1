public class Estudiante {
    private String matricula = "";
    private String nombre = "";
    private int edad = 0;
    private double promedio = 0;

    /**
     * CONSTRUCTOR DE MI CLASE ESTUDIANTE
     * 
     * @param nombre
     * @param edad
     * @param promedio
     * @param matricula
     */
    public Estudiante(String nombre, int edad, double promedio, String matricula) {
        this.nombre = nombre;
        setEdad(edad);
        setPromedio(promedio);
        this.matricula = matricula;
    }
    
    /**
     * FUNCION PARA ESTABLCER Y CONTROLAR EL RANGO DE EDAD
     * 
     * @param edad
     */
    public void setEdad(int edad) {
        if (edad >= 0 && edad <= 120) {
            this.edad = edad;
        } else
            this.edad = 0;
    }

    /**
     * FUNCION PARA ESTABLECER Y CONTROLAR EL RANGO DEL PROMEDIO
     * 
     * @param promedio
     */
    public void setPromedio(double promedio) {
        if (promedio >= 0.0 && promedio <= 10.0) {
            this.promedio = promedio;
        } else
            this.promedio = 0.0;
    }

    /**
     * FUNCION PARA OBTENER EL VALOR DEL PROMEDIO
     * 
     * @return
     */
    public double getPromedio() {
        return (this.promedio);
    }

    /**
     * FUNCION PARA OBTENER EL NOMBRE
     * 
     * @return
     */
    public String getNombre() {
        return (this.nombre);
    }

    /**
     * FUNCION PARA ESCRIBIR EL CONTENIDO DE MI OBJETO
     * 
     * @return String con la concatenación de mensaje y variables.
     */
    public String toString() {
        return ("Estudiante [matrícula = " + matricula + ", nombre = " + nombre + ", edad = " + edad + ", promedio = "
                + promedio + "]");
    }
}