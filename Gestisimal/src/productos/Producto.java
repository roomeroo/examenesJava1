package productos;

/**
 * Clase producto de la base de datos gestisimal
 * 
 * @author Adrián Romero Maldonado
 */
public class Producto {
    /**COLORES PARA EMBELLECER */
    public static final String RED_BRIGHT = "\033[0;91m"; // RED
    public static final String GREEN_BRIGHT = "\033[0;92m"; // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String RESET = "\033[0m"; // Text Reset

    // variables de instancia, constructor(es), getters, setters...
    private long codigo;
    private String descripcion;
    private double precioCompra;
    private double precioVenta;
    private int stock;
    /**
     * Constructor de la clase
     * 
     * @param codigo
     * @param descripcion
     * @param precioCompra
     * @param precioVenta
     * @param stock
     */
    public Producto(long codigo, String descripcion, double precioCompra, double precioVenta, int stock){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }
    /**
     * seter de descripcion
     * 
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * setter de precioCompra
     * 
     * @param precioCompra
     */
    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    /**
     * setter de precioVenta
     * 
     * @param precioVenta
     */
    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    /** 
     * setter de stock
     * 
     * @param stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * getter de codigo
     * 
     * @return codigo
     */
    public long getCodigo() {
        return codigo;
    }
    /**
     * getter de descripcion
     * 
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * getter de precioCompra
     * 
     * @return precioCompra
     */
    public double getPrecioCompra() {
        return precioCompra;
    }
    /**
     * getter de precioVenta
     * 
     * @return precioVenta
     */
    public double getPrecioVenta() {
        return precioVenta;
    }
    /**
     * getter de stock
     * 
     * @return stock
     */
    public int getStock() {
        return stock;
    }
    /**
     * toString
     * 
     * @return String que 'resume' la instancia de Producto
     */
    @Override
    public String toString() {
        return String.format("Codigo: %10d, descripcion: " + RED_BRIGHT + "  %15s" + RESET + ", precioCompra: " + YELLOW_BRIGHT + "%-10.2f" + RESET + ", precioVenta: " + YELLOW_BRIGHT + "%-10.2f" + RESET + ", stock: " + RED_BRIGHT + "%-6d" + RESET, codigo, descripcion, precioCompra, precioVenta, stock);
    }
}