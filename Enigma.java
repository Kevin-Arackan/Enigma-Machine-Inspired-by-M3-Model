// Author: Kevin Arackan
import java.util.Scanner;

public class Enigma {

    public static void main(String[] args) {
        // How to execute: java Enigma rotor1ID rotor2ID rotor3ID ringSetting plugboardSettings initialRotorPositions
        // Example for 1st day of month: java Enigma V II I IHQ ET LD NP OS RA UW UJJ
        Scanner reader = new Scanner(System.in);
        String ringstellung = args[3];
        Rotor rotor1 = new Rotor(args[0], ringstellung.charAt(0));
        Rotor rotor2 = new Rotor(args[1], ringstellung.charAt(1));
        Rotor rotor3 = new Rotor(args[2], ringstellung.charAt(2));
        String plugboardSettings = args[4] + " " + args[5] + " " + args[6] + " " + args[7] + " " + args[8] + " " + args[9];
        char letter = 'A';
        Plugboard plugboard = new Plugboard(plugboardSettings);
        plugboard.adjustOutput(plugboardSettings);
        Reflector reflector = new Reflector("B");
        rotor1.grundstellung(args[10].charAt(0));
        rotor2.grundstellung(args[10].charAt(1));
        rotor3.grundstellung(args[10].charAt(2));
        System.out.println("What do you want to encrypt or decrypt?");
        String input = reader.nextLine();
        String output = "";
        String testRange = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        input = input.toUpperCase();
        while (!input.isEmpty()) {
            if (testRange.indexOf(input.charAt(0)) > -1) {
                letter = input.charAt(0);
                letter = plugboard.getLetter(letter);
                rotor3.rotateRotor();
                if (rotor3.timeToTurn()) {rotor2.rotateRotor();}
                if (rotor2.timeToTurn()) {rotor1.rotateRotor();}
                letter = rotor3.getLetter(letter);
                letter = rotor2.getLetter(letter);
                letter = rotor1.getLetter(letter);
                letter = reflector.getLetter(letter);
                letter = rotor1.getOtherLetter(letter);
                letter = rotor2.getOtherLetter(letter);
                letter = rotor3.getOtherLetter(letter);
                letter = plugboard.getLetter(letter);
                output += letter;
            }
            else {
                output += input.charAt(0);
            }
            input = input.substring(1);
        }
        System.out.println(output);
        reader.close();
    }
}
// Author: Kevin Arackan