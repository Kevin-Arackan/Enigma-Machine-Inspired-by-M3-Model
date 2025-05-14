// Author: Kevin Arackan
import java.util.Scanner;

public class Enigma {

    public static void main(String[] args) {
        // How to execute: java Enigma rotor1ID rotor2ID rotor3ID ringSetting plugboardSettings initialRotorPositions
        // Example: java Enigma V II I IHQ ET LD NP QS RA UW UJJ

        // Reading rotor input
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter Rotor 1:");
        String r1 = reader.nextLine();
        System.out.println("Enter Rotor 2:");
        String r2 = reader.nextLine();
        System.out.println("Enter Rotor 3:");
        String r3 = reader.nextLine();

        // Reading ring settings
        System.out.println("Enter Ring settings:");
        String ringstellung = reader.nextLine();

        // Initializing rotors
        Rotor rotor1 = new Rotor(r1, ringstellung.charAt(0));
        Rotor rotor2 = new Rotor(r2, ringstellung.charAt(1));
        Rotor rotor3 = new Rotor(r3, ringstellung.charAt(2));

        // Reading plugboard settings
        System.out.println("Enter plugboard settings:");
        String plugboardSettings = reader.nextLine();

        char letter;
        Plugboard plugboard = new Plugboard(plugboardSettings);
        plugboard.adjustOutput(plugboardSettings);
        Reflector reflector = new Reflector("B");

        // Reading rotor initial position
        System.out.println("Enter grundstellung settings:");
        String grundstellungSettings = reader.nextLine();
        rotor1.grundstellung(grundstellungSettings.charAt(0));
        rotor2.grundstellung(grundstellungSettings.charAt(1));
        rotor3.grundstellung(grundstellungSettings.charAt(2));

        // Encryption/decryption
        System.out.println("What do you want to encrypt or decrypt?");
        String input = reader.nextLine();
        StringBuilder output = new StringBuilder();
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
                output.append(letter);
            }
            else {
                output.append(input.charAt(0));
            }
            input = input.substring(1);
        }
        System.out.println(output);
        reader.close();
    }
}
// Author: Kevin Arackan