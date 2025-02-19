package productos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import crud.CRUD;

public class GestorInventario implements CRUD<Producto>{
    Connection conn;
    public GestorInventario(Connection conn){
        this.conn = conn;
    }
    
    @Override
    public ArrayList<Producto> requestAll(String sortedBy) throws SQLException {
        ArrayList<Producto> productos  = new ArrayList<>();
        String ordenes[] = sortedBy.split(" ");
        
        List<String> columnasValidas = Arrays.asList("codigo", "descripcion", "preciocompra", "precioventa", "stock");
        List<String> ordenesValidos = Arrays.asList("ASC", "DESC");
        if(!columnasValidas.contains(ordenes[0].toLowerCase()))// me protejo ante posibles inyecciones de codigo sql
            throw new SQLException("Columna invalida! O formato incorrecto");
        if(ordenes.length >= 2){    //me aseguro de no poder entorperme al meterme en un sitio del array que no existe en caso de no especificar orden
            if(!ordenesValidos.contains(ordenes[1].toUpperCase()))// me protejo ante posibles inyecciones de codigo sql
            throw new SQLException("orden invalido! o formato incorrecto");
        }
        String sqlQuery = "";
        System.out.println(ordenes.length);
        if(ordenes.length >= 2){    //Caso en el que has puesto la segunda palabra.
            System.out.println(ordenes[1].toUpperCase());
            sqlQuery = "SELECT * FROM productos ORDER BY " + ordenes[0].toLowerCase() + " " + ordenes[1].toUpperCase();
        }else sqlQuery = "SELECT * FROM productos ORDER BY " + sortedBy.toLowerCase();

        try (Statement stmt = this.conn.createStatement()) {
            ResultSet resultado = stmt.executeQuery(sqlQuery);
            while(resultado.next()){
                Long codigo = resultado.getLong("codigo");
                String descripcion = resultado.getString("descripcion");
                double precioCompra = resultado.getDouble("preciocompra");
                double precioVenta = resultado.getDouble("precioventa");
                int stock = resultado.getInt("stock");
                productos.add(new Producto(codigo, descripcion, precioCompra, precioVenta, stock));
            }
            System.out.println(Producto.RED_BRIGHT + "Ordenado por: " + Producto.RESET + sortedBy.toLowerCase());
            return productos;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }   

    @Override
    public Producto requestById(long codigoProducto) throws SQLException{  
        Producto producto = null;
        String consulta = "SELECT * FROM productos WHERE codigo = ?";

        try (PreparedStatement stmt = this.conn.prepareStatement(consulta)) {
            stmt.setLong(1, codigoProducto);
            ResultSet resultado = stmt.executeQuery();
            if(resultado.next())
                producto = new Producto(resultado.getLong("codigo"), resultado.getString("descripcion"), resultado.getLong("preciocompra"), resultado.getLong("precioventa"), resultado.getInt("stock"));
            return producto;
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public boolean create(Producto producto) throws SQLException{ 
        long codigo = producto.getCodigo();
        String descripcion = producto.getDescripcion();
        double precioCompra = producto.getPrecioCompra();
        double precioVenta = producto.getPrecioVenta();
        int stock = producto.getStock();
        
        String consulta = "INSERT INTO productos (codigo, descripcion, preciocompra, precioventa, stock) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = this.conn.prepareStatement(consulta)) {
            stmt.setLong(1, codigo);
            stmt.setString(2, descripcion);
            stmt.setDouble(3,precioCompra);
            stmt.setDouble(4,precioVenta);
            stmt.setInt(5,stock);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) throw new SQLException("Falló la creación del nuevo producto.");
            return affectedRows == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public boolean update(Producto producto) throws SQLException{   

        long codigo = producto.getCodigo();
        String descripcion = producto.getDescripcion();
        double precioCompra = producto.getPrecioCompra();
        double precioVenta = producto.getPrecioVenta();
        int stock = producto.getStock();

        String consulta = "UPDATE productos SET descripcion = ?, preciocompra = ?, precioventa = ?, stock = ? WHERE codigo = ?";
        try (PreparedStatement stmt = this.conn.prepareStatement(consulta)) {

            stmt.setString(1,descripcion);
            stmt.setDouble(2,precioCompra);
            stmt.setDouble(3,precioVenta);
            stmt.setInt(4, stock);
            stmt.setLong(5, codigo);

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) throw new SQLException("Falló la actualización de los datos del producto.");
            return affectedRows == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    @Override
    public boolean delete(long códigoProcucto) throws SQLException{

        String consulta = "DELETE FROM productos WHERE codigo = ?";

        try (PreparedStatement stmt = this.conn.prepareStatement(consulta)) {

            stmt.setLong(1, códigoProcucto);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) throw new SQLException("Falló el borrado de los datos del producto.");
            return affectedRows == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}