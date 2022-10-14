package fitness;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.StringTokenizer;

public class ClassSchedule {
    private FitnessClass [] classes;
    private int numClasses;

    public ClassSchedule(){
        this.classes = null;
        this.numClasses = 0;
    }
    public int getNumClasses(){
        return numClasses;
    }

    public FitnessClass [] getClasses(){
        return classes;
    }


    /**
     Public Find, searches a member in the list
     Calls the private function find
     @param member the member to find
     @return the index i of the member or NOTFOUND(-1) if the member is not in the list
    public int PublicFind(FitnessClass ) {
        for(int i = 0; i < size; i++){
            if(member.equals(mlist[i])){
                return i;
            }
        }
        return NOTFOUND;
    }
     */

    /**
     Public Find, searches a member in the list
     Calls the private function find
     @param member the member to find
     @return the member at index i or null if the NOTFOUND
    public Member PublicFindMember(Member member) {
        int index = find(member);
        if( index == NOTFOUND ){
            return null;
        }
        return mlist[index];
    }
     */

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
     Prints the schedule of all fitness classes
     */
    public void printSchedule(){
        if(classes == null){
            System.out.println("Fitness class schedule is empty.\n");
        }
        else{
            //System .out.println("\n-Fitness class-");
            System .out.println("\n-Fitness classes loaded-");
            for(int i =0; i< numClasses; i++){
                if(classes[i]!=null){
                    System.out.println(classes[i]);
                    //System.out.println(classes[i]);
                }
            }
            System .out.println("-end of class list.\n");
        }

    }

    public static void main (String [] args) throws FileNotFoundException {
        Scanner inFile = new Scanner( new File("/Users/tanvi/Desktop/IntelliJ/Project1.1/src/fitness/classSchedule.txt"));
        String command;
        StringTokenizer st;
        String [] temp;
        ClassSchedule check = new ClassSchedule();
        while(inFile.hasNext()){
            command = inFile.nextLine();
            st = new StringTokenizer(command);
            //temp = createString(st);
            //FitnessClass newFit = createFitnessClass(temp);
            //check.add(newFit);
            // System.out.println(newFit);
        }
        //check.printSchedule();
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