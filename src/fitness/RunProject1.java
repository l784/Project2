package fitness;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 Calls the function to Runs the project
 @author Leah, Tanvi
 */
public class RunProject1 {

    /**
     The main that calls the Gym Manger Run method
     @param args
     */
    public static void main(String[] args) {
        try {
            new GymManager().run();
        }
        catch(IOException exp) {

        }
    }

}



