package tesauro;

public interface ManejadorArchivos {
  /**
   * Añade datos al diccionario desde un fichero
   * @param nombreFichero
   * @return Verdadero si la importación se realizó con éxito
   */
  public boolean importar(String nombreFichero);

  /**
   * Exporta los datos actuales del diccionario a un fichero
   * @param nombreFichero
   * @return Verdadero si la exportación se realizó con éxito
   */
  public boolean exportar(String nombreFichero);

  /**
   * Recorre el archivo para escribir en mayúsculas la primera letra de cada palabra
   * @param nombreFichero
   * @return Verdadero si el proceso se realizó con éxito
   */
  public boolean embellecer(String nombreFichero);
}
