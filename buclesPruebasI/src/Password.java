public class Password {
    static String caracteresEspeciales = "!@#$%^&*()-_+=<>?/.,;:"; // String de carácteres especiales
    public static final String RED_BRIGHT = "\033[0;91m"; // RED
    public static final String GREEN_BRIGHT = "\033[0;92m"; // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String RESET = "\033[0m"; // Text Reset
    public static void main(String[] args) throws Exception {
        boolean validPass = false;
        int tries = 3;
        while (tries > 0) {
            System.out.print("Ingrese una contraseña: ");
            String pass = System.console().readLine();
            if (pass.equals("")) /* CHEQUEAMOS QUE NO SEA NULO */
                System.out.println(RED_BRIGHT + "Error: La contraseña no puede estar vacía." + RESET);
            else if (!mayorDe8(pass)) { /* CHEQUEAMOS QUE TENGA AL MENOS 8 CARACTERES */
                System.out.println(RED_BRIGHT + "EROR: La contraseña debe tener al menos 8 carácteres." + RESET);
            } else if (!contieneMayuscula(pass)) { /* COMPROBAMOS QUE CONTENGA UNA LETRA MAYUSCULA */
                System.out.println(
                        RED_BRIGHT + "Error: La contraseña debe contener al menos una letra mayúscula." + RESET);
            } else if (!contieneMinuscula(pass)) { /* COMPROBAMOS QUE TIENE UNA MINUSCULA */
                System.out.println(RED_BRIGHT + "ERROR: La contraseña debe contener al menos una minúscula." + RESET);
            } else if (!contieneDigito(pass)) { /* COMPROBAMOS QUE CONTENGA AL MENOS UN DIGITO */
                System.out.println(RED_BRIGHT + "ERROR: La contraseña debe contener al menos un dígito." + RESET);
            } else if (!contieneCaracterEspecial(pass)) { /* COMPROBAMOS QUE AL MENOS CONTENGA UN CARACTER ESPECIAL */
                System.out.println(RED_BRIGHT
                        + "ERROR: La contraseña debe contener al menos un carácter especial (por ejemplo: !, @, #, $, etc.)."
                        + RESET);
            } else if (contieneEspacios(pass)) { /* COMPROBAMOS QUE NO CONTENGA ESPACIOS */
                System.out.println(RED_BRIGHT + "ERORR: La contraseña no debe contener espacios en blanco." + RESET);
            } else { /* LA CONTRASEÑA ES SEGURA */
                System.out.println(GREEN_BRIGHT + "Contraseña segura." + RESET);
                validPass = true;
            }
            tries--;
        }
        if (!validPass)
            System.out.println(YELLOW_BRIGHT + "Número máximo de intentos alcanzado." + RESET);
    }

    public static boolean mayorDe8(String str) {            //Funcion para comprobar que contemos con 8 caracteres al menos
        if (str.length() >= 8)
            return (true);
        return (false);
    }

    public static boolean contieneMayuscula(String str) {       //Funcioin para comprobar que contenemos una mayuscula
        int i = (str.length() - 1);
        while (i >= 0) {
            if (Character.isUpperCase(str.charAt(i))) {         //comprobamos si el caracter en la posicion i es mayuscula
                return (true);
            }
            i--;
        }
        return (false);
    }

    public static boolean contieneMinuscula(String str) {           //Funcion para comprobar que contenemos una minuscula
        int i = (str.length() - 1);
        while (i >= 0) {
            if (Character.isLowerCase(str.charAt(i))) {         //comprobamos si el caracter en la posicion i es mayuscula
                return (true);
            }
            i--;
        }
        return (false);
    }

    public static boolean contieneDigito(String str) {                //Funcion para comprobar que contenemos almenos un digito
        int i = (str.length() - 1);
        while (i >= 0) {
            if (Character.isDigit(str.charAt(i))) {                      //comprobamos si el caracter en la posicion i es un numero
                return (true);
            }
            i--;
        }
        return (false);
    }

    public static boolean contieneCaracterEspecial(String str) {               //Funcion para comprobar si la contraseña tiene caracteres especiales
        int i = (str.length() - 1);
        while (i >= 0) {
            if (caracteresEspeciales.indexOf(str.charAt(i)) != -1) { //Comprobamos caracter por caracter (de la contraseña)
                return (true);                                              //si existe en el string de caracteres especiales
            }
            i--;
        }
        return (false);
    }

    public static boolean contieneEspacios(String str) {            //Comprobamos que la funcion no contenga espacios 
        int i = (str.length() - 1);
        while (i >= 0) {
            if (str.charAt(i) == ' ') {                         //vigilamos caracter por caracter, y lo coparamos con el caracter del espacio
                return (true);
            }
            i--;
        }
        return (false);
    }
}