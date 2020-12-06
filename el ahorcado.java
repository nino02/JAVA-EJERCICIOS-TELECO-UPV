// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.Scanner;

/**
 * Juego del ahorcado:
 * @author (PROG) @version (diciembre 2020)
 */
public class a
{

    /**
     * 
     */
    static public void main(String[] args)
    {
        Scanner input =  new  Scanner(System.in);
        char letra = ' ';
        String letraselec = "";
        String fraseO = "";
        String aux = "";
        String respuesta = "";
        int error = 0;
        System.out.println("FAMOSO:)");
        String frase = "nadia comaneci";
        System.out.print("\n\n");
        int i = 0;
        while (i < frase.length()) {
            if (frase.charAt(i) < 'A' || frase.charAt(i) > 'z') {
                fraseO = fraseO + frase.charAt(i);
            }
            else {
                fraseO = fraseO + "_";
            }
            i = i + 1;
        }
        while (fraseO.indexOf("_") != -1 && error < 6 &&  ! frase.equals(respuesta)) {
            System.out.println("Errores: = " + error);
            System.out.println("Letras falladas: " + letraselec + "\n");
            System.out.println(fraseO + "\n");
            System.out.print("Introducir letra: ");
            respuesta = input.nextLine();
            letra = respuesta.charAt(0);
            int i = 0;
            while (i < frase.length()) {
                if (frase.charAt(i) == letra) {
                    aux = aux + frase.charAt(i);
                }
                else {
                    aux = aux + fraseO.charAt(i);
                }
                i = i + 1;
            }
            if (frase.indexOf(letra) == -1) {
                error = error + 1;
                letraselec = letraselec + letra + " ";
            }
            System.out.println("\n\n");
            fraseO = aux;
            aux = "";
        }
        if (error < 6) {
            System.out.println(frase);
            System.out.print("Has ganado !!");
        }
        else {
            System.out.println(fraseO);
            System.out.print("Has perdido !!");
        }
    }
}
