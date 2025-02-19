import java.util.Scanner;
import tesauro.GestorDiccionario;

public class NuevoLexicón {
  public static void main(String[] args) throws Exception {

    if(args.length != 1){
      System.out.println("Numero incorrrecto de argumentos");
    }
    else {
      // Se declaran e inicializan variables
      String nombreFichero = args[0];

      String palabraInglés, significadoEspañol;
      GestorDiccionario miGestor = new GestorDiccionario();
      Scanner s = new Scanner(System.in);
      int elección;

      // Menú
      do {
        System.out.println("\n¡Bienvenido al Nuevo Lexicón!\nPor favor, seleccione una de estas opciones:");
        System.out.println("(1) Listar todas las palabras en inglés.");
        System.out.println("(2) Consultar el diccionario.");
        System.out.println("(3) Añadir una entrada al diccionario.");
        System.out.println("(4) Borrar una entrada completa del diccionario.");
        System.out.println("(5) Borrar un significado en castellano del diccionario.");
        System.out.println("(6) Importar diccionario desde el fichero.");
        System.out.println("(7) Exportar diccionario actual al fichero.");
        System.out.println("(8) Embellecer las entradas del diccionario en el fichero.");
        System.out.println("(9) Salir del programa.");
        System.out.print("Opción: ");
        elección = NuevoLexicón.solicitarElección(s);

        switch (elección) {
          case 1: // Listar todas las palabras en inglés
            System.out.println(miGestor.muestraPalabrasEnInglés());
            break;

          case 2: // Consultar diccionario
            System.out.print("Escriba la palabra en inglés a consultar: ");
            palabraInglés = s.nextLine();
            System.out.println(miGestor.muestraSignificados(palabraInglés));
            break;

          case 3: // Añadir entrada a diccionario
            System.out.print("Escriba la palabra en inglés: ");
            palabraInglés = s.nextLine();
            System.out.print("Escriba su significado en español: ");
            significadoEspañol = s.nextLine();
            if (miGestor.añadirEntrada(palabraInglés, significadoEspañol)) System.out.println("Entrada añadida con éxito.");
            else System.out.println("No se pudo añadir la entrada");
            break;

          case 4: //Borrar entrada completa del diccionario
            System.out.print("Escriba la palabra en inglés cuya entrada se ha de borrar: ");
            palabraInglés = s.nextLine();            
            if (miGestor.eliminarEntrada(palabraInglés)) System.out.println("Entrada borrada con éxito.");
            else System.out.println("No se pudo borrar la entrada");
            break;

          case 5: // Borrar significado en castellano del diccionario
            System.out.print("Escriba la palabra en inglés: ");
            palabraInglés = s.nextLine();
            System.out.print("Escriba el significado en español que se quiere eliminar: ");
            significadoEspañol = s.nextLine();
            if (miGestor.eliminarSignificado(palabraInglés, significadoEspañol)) System.out.println("Acepción eliminada con éxito.");
            else System.out.println("No se pudo eliminar la acepción");
            break;

          case 6: // Importar desde archivo
            if (miGestor.importar(nombreFichero)) System.out.println("Importación desde fichero realizada con éxito.");
            else System.out.println("No se pudo realizar la importación");
            break;

          case 7: // Exportar desde archivo
            if (miGestor.exportar(nombreFichero)) System.out.println("Exportación a fichero realizada con éxito.");
            else System.out.println("No se pudo realizar la exportación");
            break;

          case 8: // Embellecer entradas del archivo
            if (miGestor.embellecer(nombreFichero)) System.out.println("Embellecimiento de las entradas del fichero realizada con éxito.");
            else System.out.println("No se pudo realizar el embellecimiento de las entradas del fichero");
            break;           
        }
        System.out.println("Pulse enter para continuar...");
        System.console().readLine();
      } while (elección != 9);
      s.close();
    }
  }

  private static int solicitarElección(Scanner s) {
    int elección = 0;
    try {
      elección = s.nextInt();
      if (elección < 1 || elección > 9) throw new IllegalArgumentException();
    } catch (Exception e) {
      System.out.println("Opción inválida.\n");
    } finally {
      s.nextLine(); // Limpiamos buffer de entrada
    }
    return elección;
  }
}
