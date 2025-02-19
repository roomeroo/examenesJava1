package usuario;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import pool.ConnectionPool;
import productos.Producto;
import productos.GestorInventario;

public interface Interactuador {    
    // Configuración de la conexión a la base de datos
    final String URL = "jdbc:mariadb://localhost:3306/gestisimal";
    final String USUARIO = "root";
    final String CLAVE = "";

    ConnectionPool pool = new ConnectionPool(URL, USUARIO, CLAVE);
    GestorInventario miGestor = new GestorInventario(pool.getConnection());    
    Scanner sc = new Scanner(System.in);

    // Consulta ordenada de productos 
    public static void consultaOrdenada() {

        ArrayList<Producto> productos = new ArrayList<>();
        System.out.print("Como quieres ordenar [columna | orden]: ");
        String columna = System.console().readLine();
        try {
            productos = miGestor.requestAll(columna);
            for(int i = 0; i < productos.size(); i++){
                System.out.println(productos.get(i));
            }
        } catch (SQLException e) {
            System.out.println("ERROR.");
            System.out.println(e.getMessage());
        }
    }

    // Consulta de datos por ID
    public static void consultaPorCódigo() {  
        System.out.print("Cual es el codigo: ");
        long codigo = (long) solicitarValorNumérico(Long.class); 

        try{  
            Producto producto = miGestor.requestById(codigo);  
            if(producto != null){
                System.out.println(producto);    
            }     
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void altaProducto() {    

        System.out.print("Codigo: ");
        long codigo = (long)solicitarValorNumérico(Long.class);
        System.out.print("descripcion: ");
        String descripcion = System.console().readLine();
        System.out.print("Precio compra: ");
        double preciocompra = (double)solicitarValorNumérico(Double.class);
        System.out.print("Precio venta: ");
        double precioventa = (double)solicitarValorNumérico(Double.class);
        System.out.print("Stock: ");
        int stock = (int)solicitarValorNumérico(Integer.class);

        try{  

            if(miGestor.create(new Producto(codigo, descripcion, preciocompra, precioventa, stock))){
                System.out.println("Producto creado");
            }else System.out.println("Producto no creado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void modificaciónProducto() {       

        System.out.print("Codigo: ");
        long codigo = (long)solicitarValorNumérico(Long.class);
        System.out.print("descripcion: ");
        String descripcion = System.console().readLine();
        System.out.print("Precio compra: ");
        double preciocompra = (double)solicitarValorNumérico(Double.class);
        System.out.print("Precio venta: ");
        double precioventa = (double)solicitarValorNumérico(Double.class);
        System.out.print("Stock: ");
        int stock = (int)solicitarValorNumérico(Integer.class);
        try{ 

            if(miGestor.update(new Producto(codigo, descripcion, preciocompra, precioventa, stock))){
                System.out.println("producto actualizado");
            }else System.out.println("Producto NO actualizado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Baja de un producto
    public static void bajaProducto() {  
        System.out.print("Codigo: ");   
       long codigo = (long)solicitarValorNumérico(Long.class); 

        try{

            if(miGestor.delete(codigo)){
                System.out.println("producto borrado");
            }else{
                System.out.println("Producto NO borrado");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Solicitar opción al usuario
    public static int solicitarElección(int OPCIÓN_MAX) {
        int elección = 0;
        try {
            elección = sc.nextInt();
        if (elección < 1 || elección > OPCIÓN_MAX) throw new IllegalArgumentException();
        } catch (Exception e) {
            System.out.println("Opción inválida.\n");
        } finally {
            sc.nextLine(); // Limpiamos buffer de entrada
        }
        return elección;
    }

     // Solicitar valor numérico al usuario     
     // Ejemplo de uso 1: int existencias = (Integer) solicitarValorNumérico(Integer.class);
     // Ejemplo de uso 2: long código = (Long) solicitarValorNumérico(Long.class);
     // Ejemplo de uso 3: double precioCompra = (Double) solicitarValorNumérico(Double.class);
     private static Object solicitarValorNumérico(Class<?> tipo) {
        Object resultado = null;
        while (resultado == null) {
            try { 
                if (tipo == Short.class) resultado = sc.nextShort();
                else if (tipo == Integer.class) resultado = sc.nextInt();
                else if (tipo == Long.class) resultado = sc.nextLong();
                else if (tipo == Float.class) resultado = sc.nextFloat();
                else if (tipo == Double.class) resultado = sc.nextDouble();
                else System.out.println("Tipo de dato no soportado.");
            } catch (Exception e) {
                System.out.print("Valor inválido.\nPruebe de nuevo: ");
            } finally {
                sc.nextLine(); // Limpiamos buffer de entrada
            }
        }        
        return resultado;
    }

    // Cerrar scanner
    public static void cerrarScanner() {
        sc.close();
    }

}
