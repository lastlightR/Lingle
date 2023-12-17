/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainpackage;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Robyn
 */
public class Main {
    
    //credits to JorgeDuenasLerin on github for spanish dictionary
    //credits to redbo on github for english dictionary

    public static void main(String[] args) {
        //File dictionary = new File("src/files/dictionary.txt"); //english dictionary
        //File diccionario = new File("src/files/diccionario.txt"); //diccionario español
        
        File dictionary5 = new File("src/files/dictionary_5.txt"); //english dictionary
        File diccionario5 = new File("src/files/diccionario_5_noTildes.txt"); //diccionario español sin tildes
        File bothDictionaries5 = new File("src/files/both_dictionaries_5.txt"); //joined dictionaries
        
        //ModifyFile sf = new ModifyFile();
        //sf.reduceTo5(dictionary, "dictionary");
        //sf.reduceTo5(diccionario, "diccionario");
        //sf.removeTildes(diccionario, "diccionario_5");
        
        String guess = ""; //variable introduced by the user
        int num_of_tries = 0; //counts the amount of tries
        Scanner scanner = new Scanner(System.in);
        String chosen_dictionary = "";
        int length_dictionary = 0; //for some reason, length() is giving weird values
        
        Lingle lingle = new Lingle(bothDictionaries5);
        if (chooseDictionary() == 0) {
            length_dictionary = 8938;
            lingle.setCorrect_word(dictionary5, length_dictionary);
            chosen_dictionary = "inglés";
        }            
        else {
            length_dictionary = 5537;
            lingle.setCorrect_word(diccionario5, length_dictionary);
            chosen_dictionary = "español";
        }
        
        System.out.println("-- ¡Te damos la bienvenida a Lingle! Adivina una palabra en inglés o español de 5 letras --");
        System.out.println("--           Dispones de un total de 6 aciertos. ¡Prepárate para la aventura!            --\n");
        
        //will keep giving chances while the word is not correct or until we run out of tries
        while (!guess.equals(lingle.correct_word) && num_of_tries < 6){
            System.out.println("-- Introduce una palabra: ");
            guess = scanner.nextLine().toUpperCase();
            if (lingle.isWordValid(guess) == 1)
                System.out.println("Esta palabra no es de 5 letras, prueba otra vez.\n");
            else if (lingle.isWordValid(guess) == 2)
                System.out.println("Palabra inválida. Introduce sólo eñes como carácter especial.\n");
            else { //continues like normal if the word is valid
                if (!lingle.isInDictionary(guess))
                    System.out.println("La palabra no está en el diccionario, prueba de nuevo.\n");
                else { //goes on if the word is in the dictionary
                    lingle.setGuess(guess);
                    System.out.println("\t\t"+lingle.returnYellowGreen()+"\n\t\t"+guess+"\n"); //prints the result of the guess
                    num_of_tries++; //increments the number of tries
                    if (guess.equals(lingle.correct_word))
                        System.out.println("¡Acertaste! Te ha llevado "+num_of_tries+" intento(s). Del diccionario "+chosen_dictionary+".\n");
                    else if (num_of_tries == 6)
                        System.out.println("¡Una pena! Te has quedado sin intentos.\nLa palabra correcta era "+lingle.correct_word+" del "+chosen_dictionary+".\n");
                    else
                        System.out.println("Te quedan "+ (6-num_of_tries) +" intento(s).\n");
                }
            }
        }
        System.out.println("-- ¡Gracias por jugar! Esperamos verte de nuevo. --");
    }
    
    //0 chooses one dictionary, 1 chooses the other
    public static int chooseDictionary(){
        int rng = (int)(Math.random() * 2);
        return rng;
    }
    
}
