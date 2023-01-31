/*
 * 1/22/23
 * Written by me 
 * I have no idea what im doing
 */
import java.util.Scanner;

public class DRGRunner
{
    /*
     * Future Upgrades:
     * Make it cleaner
     * Push to github to do it from phone
     */
    public static void main (String[] args)
    {
        //initializing...
        Scanner scan = new Scanner(System.in);
        int inpt;
        String stringInpt = "";

        //gets class info
        System.out.println("Class: Engineer[1], Scout[2], Driller[3], Gunner[4]");
        inpt = scan.nextInt();

        //checks if input is valid (inputing string breaks program, dont know how to fix yet)
        while (inpt != 1 && inpt != 2 && inpt != 3 && inpt != 4)
        {
            System.out.println("Invalid input");
            inpt = scan.nextInt();
        }
        //end check loop
        
        //makes loadout object (check loadoutRandomizer class) and calls randomizer function to print randomized loadout
        LoadoutRandomizer loadout = new LoadoutRandomizer(inpt);
        loadout.randomizer();

        //reroll loop
        stringInpt = scan.nextLine(); //idk why but I need this here for the loop to work :/
        while (!stringInpt.equals("q"))
        {
            System.out.println("Reroll? (q to quit)");
            stringInpt = scan.nextLine();

            if (!stringInpt.equals("q"))
            {
                loadout.randomizer();
            }
        }
        //end reroll loop
    }
}
