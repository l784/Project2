package fitness;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.StringTokenizer;

/**
 * Class Schedule holds the Fitness Array consisting of all the classes from the classSchedule
 * and also the participants and guests who checked in
 */
public class ClassSchedule {

    private FitnessClass [] classes;
    private int numClasses;

    /**
     * Initializes the instances in Class Schedule
     */
    public ClassSchedule(){
        this.classes = null;
        this.numClasses = 0;
    }

    /**
     * Getter for the fitnessClass Array
     * @return the Fitness Class
     */
    public FitnessClass [] getClasses(){
        return classes;
    }

    /**
     Checks if class exists at the Gym
     @param fitnessClass to check with existing classes
     @return int -1 if class does not exist, index value if it does
     */
    public FitnessClass classExists(FitnessClass fitnessClass){ // in class schedule?
        for( int i = 0; i < classes.length; i++ ){
            if(classes[i] != null){
                if( classes[i].equals(fitnessClass) ) {
                    return classes[i];
                }
            }
        }
        return null;
    }

    /**
     Checks if class exists at the Gym
     @param fitnessClass to check with existing classes
     @return boolean true if class does not exist, index value if it does
     */
    public FitnessClass [] timeConflict(FitnessClass fitnessClass){ // in class schedule?
        FitnessClass [] temp = new FitnessClass[30];
        for(int i =0; i< numClasses; i++){
            if(classes[i] != null){
                if(classes[i].getClassTime() == fitnessClass.getClassTime() && !(classes[i].equals(fitnessClass)))
                    temp[i] = classes[i];
            }
        }
        return temp;
    }

    /**
     Grow, a growable container with an initial capacity of 4
     Grows the container by 4 automatically when full
     */
    private void grow() {
        if(numClasses == 0){
            numClasses = 4;
            this.classes = new FitnessClass[numClasses];
        }
        if(classes[numClasses-1]!=null){
            numClasses = numClasses+4;
            FitnessClass [] tempClasses = new FitnessClass[numClasses];
            for(int i =0; i<numClasses-4; i++){
                tempClasses[i] = classes[i];
            }
            this.classes = tempClasses;
        }
    }

    /**
     Adds the member to mlist
     Calls the grow() function to increase capacity
     @param fitnessClass the member to add to the list
     @return true if person was added, false otherwise.
     */
    public boolean add(FitnessClass fitnessClass) {
        if(numClasses==0) grow();
        if(classes[numClasses-1]!=null){
            grow();
        }
        for(int i=0; i<numClasses; i++){
            if(classes[i]==null){
                classes[i] = fitnessClass;
                return true;
            }
        }


        return false;
    }

    /**
     * Print the schedule of the classes
     */
    public void printSchedule(){
        if(classes == null){
            System.out.println("Fitness class schedule is empty.\n");
        }
        else {
            for(int i =0; i< numClasses; i++){
                if(classes[i]!=null){
                    System.out.println(classes[i]);
                }
            }
        }
    }

    /**
     * Main to test this method
     * @param args
     * @throws IOException
     */
    public static void main (String [] args) throws IOException {
        Scanner inFile = new Scanner( new File("classSchedule.txt"));
        String command;
        StringTokenizer st;
        String [] temp;
        ClassSchedule check = new ClassSchedule();
        while(inFile.hasNext()){
            command = inFile.nextLine();
            st = new StringTokenizer(command);
        }
        Premium t = new Premium("Tanvi", "Thigle",new Date("3/16/2002"), new Date("12/28/2027"),Location.FRANKLIN);
        Member a = new Member("Neeraj", "Pise",new Date("8/31/1999"), new Date("12/28/2023"),Location.BRIDGEWATER);

        System.out.println(check.classes[0]);
        check.classes[0].checkIn(t);
        check.classes[0].guestCheckIn(t);
        check.classes[0].checkIn(a);
        System.out.println(check.classes[0]);
        check.classes[0].doneClass(a);
        check.classes[0].guestDoneClass(t);
        System.out.println(check.classes[0]);
        System.out.print(t.GUEST_PASS);
    }


}