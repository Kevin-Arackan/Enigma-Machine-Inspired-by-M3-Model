// Author: Kevin Arackan
public class Plugboard {
    String inputArray;
    String outputArray;
    String plugboardSettings;
    char firstLetter;
    char lastLetter;
    int index;

    public Plugboard(String plugboardSettings) {
        this.plugboardSettings = plugboardSettings;
        this.inputArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.outputArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.index = 0;
    }

    public void adjustOutput(String settings) {
        while (settings.indexOf(" ") > -1) {
            firstLetter = settings.charAt(0);
            lastLetter = settings.charAt(1);
            index = inputArray.indexOf(firstLetter);
            outputArray = outputArray.substring(0, index) + lastLetter + outputArray.substring(index + 1);
            index = inputArray.indexOf(lastLetter);
            outputArray = outputArray.substring(0, index) + firstLetter + outputArray.substring(index + 1);
            settings = settings.substring(settings.indexOf(" ") + 1);
        }
        firstLetter = settings.charAt(0);
        lastLetter = settings.charAt(1);
        index = inputArray.indexOf(firstLetter);
        outputArray = outputArray.substring(0, index) + lastLetter + outputArray.substring(index + 1);
        index = inputArray.indexOf(lastLetter);
        outputArray = outputArray.substring(0, index) + firstLetter + outputArray.substring(index + 1);
    }

    public char getLetter(char letter)
    {
        index = inputArray.indexOf(letter);
        return outputArray.charAt(index);
    }
}
// Author: Kevin Arackan