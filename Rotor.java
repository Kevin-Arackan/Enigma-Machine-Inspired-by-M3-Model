// Author: Kevin Arackan
public class Rotor
{
    private final String rotorInput;
    private String rotorOutput;
    private String rotorNumber;
    private char ringstellung;
    private char topLetter;
    private char turnover;
    private char var;
    private int num;
    private String input;
    private String output;
    private int iteration;

    public Rotor(String rotorNumber, char ringstellung)
    {
        this.rotorInput = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.rotorNumber = rotorNumber;
        this.ringstellung = ringstellung;
        this.topLetter = 'A';
        this.var = 'A';
        this.num = 0;
        this.iteration = 0;
        if (this.rotorNumber.equals("I"))
        {
            this.rotorOutput = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
            this.turnover = 'Q';
            settingRingstellung(this.ringstellung);
        }
        else if (this.rotorNumber.equals("II"))
        {
            this.rotorOutput = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
            this.turnover = 'E';
            settingRingstellung(this.ringstellung);
        }
        else if (this.rotorNumber.equals("III"))
        {
            this.rotorOutput = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
            this.turnover = 'V';
            settingRingstellung(this.ringstellung);
        }
        else if (this.rotorNumber.equals("IV"))
        {
            this.rotorOutput = "ESOVPZJAYQUIRHXLNFTGKDCMWB";
            this.turnover = 'J';
            settingRingstellung(this.ringstellung);
        }
        else if (this.rotorNumber.equals("V"))
        {
            this.rotorOutput = "VZBRGITYUPSDNHLXAWMJQOFECK";
            this.turnover = 'Z';
            settingRingstellung(this.ringstellung);
        }
        else
        {
            System.out.println("invalid Rotor ID");
        }
    }

    public void grundstellung(char grundstellung)
    {
        this.iteration = grundstellung - 65;
        while (this.iteration > 0)
        {
            rotateRotor();
            this.iteration--;
        }
    }

    public void rotateRotor()
    {
        this.var = 'A';
        this.num = 0;
        this.input = this.rotorOutput;
        this.output = "";
        while (!this.input.isEmpty())
        {
            this.var = this.input.charAt(0);
            if (this.var == 'A')
            {
                this.num = 90;
            }
            else
            {
                this.num = this.var - 1;
            }
            this.var = (char) this.num;
            this.output += this.var;
            this.input = this.input.substring(1);
        }
        this.rotorOutput = this.output.substring(1) + this.output.charAt(0);
    }

    public char getLetter(char letter)
    {
        return this.rotorOutput.charAt(this.rotorInput.indexOf(letter));
    }

    public char getOtherLetter(char letter)
    {
        return this.rotorInput.charAt(this.rotorOutput.indexOf(letter));
    }

    public void settingRingstellung(char ringSetting)
    {
        this.var = 'A';
        this.num = 0;
        this.input = this.rotorOutput;
        this.output = "";
        this.iteration = ringSetting - 65;
        while (this.iteration > 0)
        {
            while (this.input.length() > 0)
            {
                this.var = this.input.charAt(0);
                if (this.var == 'Z')
                {
                    this.num = this.var - 25;
                }
                else
                {
                    this.num = this.var + 1;
                }
                this.var = (char) this.num;
                this.output += this.var;
                this.input = input.substring(1);
            }
            this.input = this.output;
            this.output = "";
            this.iteration--;
        }
        this.rotorOutput = input;
    }

    public boolean timeToTurn()
    {
        if (this.topLetter != 'Z')
        {
            if (this.topLetter == this.turnover + 1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else if (this.topLetter == this.turnover - 25)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
// Author: Kevin Arackan