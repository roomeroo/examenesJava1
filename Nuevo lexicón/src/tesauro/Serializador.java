package tesauro;

import java.util.ArrayList;

public interface Serializador {

  /** 
   * Serializa los datos de una entrada del diccionario en una cadena: palabraInglés;significadoEspañol1;significadoEspañol2 
   * @param palabraInglés Palabra en inglés
   * @param significados Lista con las acepciones en castellano asociadas a la palabra inglesa
   * @return Cadena de caracteres conteniendo todos los datos de esa entrada del diccionario
   */
  public String serializar(String palabraInglés, ArrayList<String> significados);


  /** 
   * Deserializa los datos de una entrada del diccionario devolviendo un array de cadenas 
   * @param líneaFichero Datos en el fichero de una entrada del diccionario
   * @return Array de Strings con la palabra en inglés en primera posición seguida de los significados en español
   */
  public String[] deserializar(String líneaFichero);

}