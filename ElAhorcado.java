import java.util.Scanner;
/**
 * Juego del ahorcado: adivina una pelicula.
 *
 * @author (PROG)
 * @version (Noviembre 2020)
 */
public class ElAhorcado {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        System.out.println("Pista: es el nombre de una película");
        String frase = new String("Vengadores: Infinity War").toLowerCase();
        String oculta = ocultarLetras(frase);
        System.out.println(oculta);
        int fallos = 0;
        String letrasElegidas = "";
        while (oculta.indexOf("_") != -1 && fallos < 5) {
            char letra = leerLetra(tec, letrasElegidas);
            letrasElegidas += letra;
            if (frase.indexOf(letra) == -1) {
                fallos += 1;
                System.out.println("La letra no está. Llevas " +  fallos + " fallos.");
            } else {
                oculta = mostrarLetra(letra, oculta, frase);
                System.out.println(oculta);
            }
        }
        if (fallos < 5) {
            System.out.println("Has ganado!");
        } else {
            System.out.println("Has perdido!"); 
        }
    }

    /**
     * Devuelve un String de la misma longitud que f pero
     * con todos los caracteres iguales a guión (-).
     *
     * @param  f  frase a ocultar
     * @return    String de longitud la de f y con guiones
     */
    public static String ocultarLetras(String f) {
        String res = "";
        for (int i = 0; i < f.length(); i++) {
            char ch = f.charAt(i);
            if ('a' <= ch && ch <= 'z') {
                res += '_';
            } else {
                res += ch;
            }
        }
        return res;
    }
    
    /**
     * Solicita un caracter, comprueba que no está entre los del String
     * yaElegidas. Si está vuelve a pedirlo, hasta que el usuario 
     * introduzca uno que no esté.
     *
     * @param  yaElegidas  caracteres que ya han sido seleccionados
     * @return    caracter leído que no sea ninguno de los de yaElegidas
     */
    public static char leerLetra(Scanner tec, String yaElegidas) {
        char ch = ' ';
        int pos = 0;
        do {
            System.out.println("Escribe un caracter: ");
            ch = tec.nextLine().charAt(0);
            pos = yaElegidas.indexOf(ch);
        } while (pos >= 0);
        return ch;
    }
    
    /**
     * Devuelve el String que resulta de sustituir en oculta
     * todas las apariciones del caracter ch en la frase
     *
     * @param  ch  caracter seleccionado
     * @param  oculta String frase oculta
     * @param  frase a averiguar
     * @return String que resulta de sustituir en oculta todas las apariciones de ch
     */
    public static String mostrarLetra(char ch, String oculta, String frase) {
        String res = "";
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == ch) {
                res += ch;
            } else {
                res += oculta.charAt(i);
            }
        }
        return res;
    }
}
