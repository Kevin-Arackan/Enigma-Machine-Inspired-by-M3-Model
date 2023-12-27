// Author: Kevin Arackan
public class Reflector
{
    private String reflectorInput;
    private String reflectorOutput;
    private String reflectorID;
    private char var;

    public Reflector(String reflectorID)
    {
        this.reflectorInput = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        var = 'A';
        this.reflectorID = reflectorID;
        if (this.reflectorID.equals("B"))
        {
            this.reflectorOutput = "YRUHQSLDPXNGOKMIEBFZCWVJAT";
        }
        else if (this.reflectorID.equals("C"))
        {
            this.reflectorOutput = "FVPJIAOYEDRZXWGCTKUQSBNMHL";
        }
        else
        {
            System.out.println("Invalid ID");
        }
    }

    public char getLetter(char letter)
    {
        var = this.reflectorOutput.charAt(this.reflectorInput.indexOf(letter));
        return var;
    }
}
// Author: Kevin Arackan