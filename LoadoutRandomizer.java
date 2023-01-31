import java.io.File;
import java.util.Scanner;

public class LoadoutRandomizer 
{    
    //initializing...
    private String[] primary;
    private String[] secondary;
    private String[] throwable;
    String dwarfClass;

    public LoadoutRandomizer(int dwarfIndex)
    {    
        //converts int data from user input into string data for the text file    
        if (dwarfIndex == 1)
        {
            dwarfClass ="Engineer";
        }
        else if (dwarfIndex == 2)
        {
            dwarfClass ="Scout";
        }
        else if (dwarfIndex == 3)
        {
            dwarfClass ="Driller";
        }
        else if (dwarfIndex == 4)
        {
            dwarfClass ="Gunner";
        }

        //thingamajig for the reading, splitting, and organization of text file data (I copied half of this from PLTW)
        try
        {
            // The Scanner method hasNextLine returns true if there is another line of input
            Scanner sc = new Scanner(new File(dwarfClass + ".txt"));
            
            // String method trim removes whitepsace from the beginning and end of strings
            String temp = sc.nextLine().trim();
                
            // String method split splits this string based on the specified token and returns an array of individual substrings
            primary = temp.split(",");

            //repeat for secondary
            temp = sc.nextLine().trim();
            secondary = temp.split(",");

            //repeat for throwable
            temp = sc.nextLine().trim();
            throwable = temp.split(",");
              
        } catch (Exception e) { System.out.println("Error reading or parsing " + dwarfClass + ".txt" + e); } //throws an error if there is one(?) (dont know how)   
    }

    //randomizer function to randomize loadout
    public void randomizer()
    {
        int r = (int) (Math.random() * primary.length); //makes random number 
        String primaryWeapon = primary[r]; //uses random number with the array to return the random weapon

        //repeat for secondary
        r = (int) (Math.random() * secondary.length);
        String secondaryWeapon = secondary[r];

        //repeat for throwable
        r = (int) (Math.random() * throwable.length);
        String throwableWeapon = throwable[r];

        //print everything
        System.out.println("Primary: " + primaryWeapon); 
        System.out.println("Secondary: " + secondaryWeapon);   
        System.out.println("Throwable: " + throwableWeapon);  
    }
}