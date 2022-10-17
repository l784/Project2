package fitness;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
Gym Manager, is a User Interface Class to process the command line
Can process a single or batch of command lines or txt files
@author Leah Ranavat, Tanvi Thigle
*/
public class GymManager {

    private static final MemberDatabase MLIST_DATA = new MemberDatabase();
    private static final Date DATE_CALL = new Date();
    private static final ClassSchedule FITNESS_CLASS_DATA = new ClassSchedule();

    /**
    Checks if the command is valid
    Prints invalid if command is not valid
    @param command the command that needs to be checked
    */
    private void isValidCommand (String command){
        if(command.equals("a") || command.equals("p") || command.equals("pc") || command.equals("pn") || command.equals("pd")){
            System.out.println(command + " " + "is an invalid command!");
        }
        if(command.equals("AA") || command.equals("RR") || command.equals("r") || command.equals("s") || command.equals("c")){
            System.out.println(command + " " + "is an invalid command!");
        }
        if(command.equals("d") || command.equals("SS") || command.equals("CC") || command.equals("DD") || command.equals("q")){
            System.out.println(command + " " + "is an invalid command!");
        }
    }

    /**
    Given dateOfBirth checks whether age Is Valid
    @param dob the dateOfBirth of the person
    @return true if person ageIsValid, false otherwise.
    */
    private boolean checkAge(Date dob) {
        if(dob.ageIsValid(dob) == false){
            System.out.println("DOB" + " " + DATE_CALL.print(dob) + ": must be 18 or older to join!");
            return false;
        }
        return true;
    }

    /**
    Given member checks whether dateOfBirth or Expiration Date Is Valid
    @param member the member whose dateOfBirth or Expiration needs to be checked
    @return false if person's dateofBirth/Expiration is Not Valid, true otherwise.
    */
    private boolean checkCalenderDobExp(Member member){
        if(member.getDob().isValid()== false){
            System.out.println("DOB" + " " + DATE_CALL.print(member.getDob()) + ": invalid calendar date!");
            return false;
        }
        if(member.getExpire().isValid() == false){
            System.out.println("Expiration date" + " " + DATE_CALL.print(member.getExpire()) + ": invalid calendar date!");
            return false;
        }
        return true;
    }

    /**
    Given dateOfBirth checks if the dateOfBirth is Today or Future Date
    @param dob the member whose dateOfBirth needs to be checked
    @return false if person's dob is today or future date, true otherwise
    */
    private boolean checkTodFut(Date dob){
        if(dob.dobIsValid(dob) == false){
            System.out.println("DOB" + " " + DATE_CALL.print(dob) + ": cannot be today or a future date!");
            return false;
        }
        return true;
    }

    /**
    Given Expiration checks if the date is expired
    @param member the member whose expiration needs to be checked
    @return false if membership expired, true otherwise
    */
    private boolean checkExp(Member member){
        Date checkExp = new Date();
        if(member.getExpire().expIsValid(member.getExpire()) == false){
            System.out.println(member.getFname() + " " + member.getLname() + " " + checkExp.print(member.getDob()) + " membership expired.");
            return false;
        }
        return true;
    }

    /**
    Checks the size of MLIST_DATA
     @return boolean true if database is empty and false otherwise
    */
    private boolean checkSize(){
        if(MLIST_DATA.getSize() == 0){
            System.out.println("Member database is empty!");
            return true;
        }
        return false;
    }

    /**
    Creates the String to store tokens
    @param st the tokens that have to be stored
    @return the String Array with the tokens
    */
    private String [] createString (StringTokenizer st){
        String[] temp = new String[6];
        for(int i = 0; st.hasMoreTokens(); i++){
            temp[i]= st.nextToken();
        }
        return temp;
    }


    /**
     Creates the Member, Date and Location Object to be added to the Array
     @param temp the createString above with the member information
     @return the Member created
     */
    private Member createMember(String [] temp){
        Date dobtemp =  new Date(temp[2]);
        if(temp[3] == null && temp[4] == null) {
            temp[3] = "12/12/2028";
            Member tempMember = new Member(temp[0], temp[1], new Date(temp[2]), new Date(temp[3]),Location.NOVALUE);
            return tempMember;
        }
        if(temp[3] == null){
            Date threeMonth = DATE_CALL.threeMonthsDate();
            Member tempMember = new Member(temp[0], temp[1], dobtemp, threeMonth, Location.valueOf(temp[4].toUpperCase()));
            return tempMember;
        }
        Date expiretemp = new Date(temp[3]);
        Member tempMember = new Member(temp[0], temp[1], dobtemp,expiretemp , Location.valueOf(temp[4].toUpperCase()));
        return tempMember;
    }

    /**
     Creates the Family, Date and Location Object to be added to the Array
     @param temp the createString above with the member information
     @return the Family created
     */
    private Family createFamily(String [] temp){
        Date dobtemp =  new Date(temp[2]);
        if(temp[3] == null && temp[4] == null) {
            temp[3] = "12/12/2028";
            Family tempMember = new Family(temp[0], temp[1], new Date(temp[2]), new Date(temp[3]),Location.NOVALUE);
            return tempMember;
        }
        if(temp[3] == null){
            Date threeMonth = DATE_CALL.threeMonthsDate();
            Family tempMember = new Family(temp[0], temp[1], dobtemp, threeMonth, Location.valueOf(temp[4].toUpperCase()));
            return tempMember;
        }
        Date expiretemp = new Date(temp[3]);
        Family tempMember = new Family(temp[0], temp[1], dobtemp,expiretemp , Location.valueOf(temp[4].toUpperCase()));
        return tempMember;
    }

    /**
     Creates the Premium, Date and Location Object to be added to the Array
     @param temp the createString above with the member information
     @return the Premium created
     */
    private Premium createPremium(String [] temp){
        Date dobtemp =  new Date(temp[2]);
        if(temp[3] == null && temp[4] == null) {
            temp[3] = "12/12/2028";
            Premium tempMember = new Premium(temp[0], temp[1], new Date(temp[2]), new Date(temp[3]),Location.NOVALUE);
            return tempMember;
        }
        if(temp[3] == null){
            Date threeMonth = DATE_CALL.threeMonthsDate();
            Premium tempMember = new Premium(temp[0], temp[1], dobtemp, threeMonth, Location.valueOf(temp[4].toUpperCase()));
            return tempMember;
        }
        Date expiretemp = new Date(temp[3]);
        Premium tempMember = new Premium(temp[0], temp[1], dobtemp,expiretemp , Location.valueOf(temp[4].toUpperCase()));
        return tempMember;
    }

    /**
    Adds a person into the Array
    Checks if date of birth is Valid or person not in array
    @param st the tokens that have the member information
    */
    private void commandA(StringTokenizer st,String command){
        String [] createString = createString(st);
        if(Location.EDISON.isValid(createString[3]) == false){
            System.out.println(createString[3] + ": invalid location!");
        }
        else {
            Member newMember = new Member(null,null,null,null,null);
            createString[4] = createString[3];
            createString[3] = null;
            if(command.equals("AF")){
                 newMember = createFamily(createString);
            }
            else if(command.equals("AP")){
                newMember = createPremium(createString);
            }
            else {
                newMember = createMember(createString);
            }
            if(checkCalenderDobExp(newMember) == false);
            else if (checkTodFut(newMember.getDob()) == false);
            else if(checkAge(newMember.getDob()) == false);
            else if(MLIST_DATA.add(newMember) == true){
                System.out.println (newMember.getFname() + " " + newMember.getLname() + " " + "added");
            }
            else if(MLIST_DATA.add(newMember) == false){
                System.out.println(newMember.getFname() + " " + newMember.getLname() + " is already in the database.");
            }
        }
    }

    /**
    Removes a person from the Array
    Checks if person is not in the database
    @param st the tokens that have the member information
    */
    private void commandR(StringTokenizer st){
        String [] createString = createString(st);
        Member deleteMember = createMember(createString);
        boolean check = MLIST_DATA.remove(deleteMember);
        if(check == true){
            System.out.println(deleteMember.getFname() + " " + deleteMember.getLname() +  " removed");
        }
        else {
            System.out.println(deleteMember.getFname() + " " + deleteMember.getLname() +  " is not in the database.");
        }
    }

    /**
     * Creates Fitness Class if Member is found
     * @param temp String with Member information
     */
    public static FitnessClass findFitClass(String [] temp){
        FitnessClass newFitness = new FitnessClass(temp[0], Instructor.valueOf(temp[1].toUpperCase()) , Time.NOVALUE, Location.valueOf(temp[2].toUpperCase()));
        FitnessClass addData = FITNESS_CLASS_DATA.classExists(newFitness);
        return addData;
    }

    /**
     * Creates Fitness Class if Member is found
     * @param temp String from above with Member information
     * @return Member to create a list of participants
     */
    public static Member addFindMember(String [] temp){
        Member fitnessMember = new Member(temp[3],temp[4], new Date(temp[5]),new Date("12/12/2028"),Location.NOVALUE);
        Member addData = MLIST_DATA.PublicFindMember(fitnessMember);
        if(addData != null) {
            if(addData.whoAmI().equals("Family.")){
                return addData;
            }
            else if(addData.whoAmI().equals("Premium.")){
                return addData;
            }
            else {
                fitnessMember = new Member(temp[3],temp[4], new Date(temp[5]), addData.getExpire(), addData.getLocation());
            }
        }
        return fitnessMember;
    }

    /**
     Checks if classType is valid
     @param fitnessClass to check with existing classes
     @return boolean false if class does not exist true otherwise
     */
    public boolean classType(String fitnessClass){
        for(int i = 0; i < FITNESS_CLASS_DATA.getClasses().length; i++){
            if(FITNESS_CLASS_DATA.getClasses()[i] != null){
                if( !(fitnessClass.equalsIgnoreCase("Spinning") ||
                        fitnessClass.equalsIgnoreCase("Cardio") ||
                        fitnessClass.equalsIgnoreCase("Pilates")) ) {
                    System.out.println(fitnessClass + " - class does not exist.");
                    return false;
                }
            }
        }
        return true;
    }

    /**
     Checks if time conflict
     @param member to check with existing classes
     @return int true if class does not exist, index value if it does
     */
    public int memberTimeConflictGym(Member member, FitnessClass fitnessClass){
        FitnessClass[] x =  FITNESS_CLASS_DATA.timeConflict(fitnessClass.TimeConflict());
        for(int i =0; i< x.length; i++){
            if(x[i]!=null){
                for(int j =0; j< x[i].getParticipants().size(); j++){
                    if(member.equals(x[i].getParticipants().get(j))){
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    /**
     Adds a person to the fitnessClass Array
     Checks if fitness Class exists or if any time Conflicts exist
     @param st the tokens that have the member information
     */
    private void commandC(StringTokenizer st){
        String [] stAsStr = createString(st);
        Instructor instrloc = Instructor.DENISE;
        Location temploc = Location.EDISON;
        if(instrloc.isValid(stAsStr[1]) == false){
            System.out.println(stAsStr[1] + " — instructor does not exist.");
        }
        else if(temploc.isValid(stAsStr[2]) == false){
            System.out.println(stAsStr[2] + " - invalid location.");
        }
        else if(classType(stAsStr[0]) == false);
        else {
            FitnessClass newFitness = findFitClass(stAsStr);
            Member newMember = addFindMember(stAsStr);
            if(findFitClass(stAsStr) == null){
                System.out.println( stAsStr[0] + " by " + stAsStr[1] + " does not exist at " + stAsStr[2]);
            }
            else if( newMember.whoAmI().equals("Member.") && newMember.getLocation().equals(newFitness.getClassLocation()) == false && !(newMember.getLocation().equals(Location.NOVALUE)) ){
                    System.out.println(newMember.getFname() + " " + newMember.getLname() + " checking in " + newFitness.getClassLocation()
                            + ", " + newFitness.getClassLocation().getZipcode() + ", " + newFitness.getClassLocation().getCounty() + " - " +
                            "standard membership location restriction.");
            }
            else if(checkCalenderDobExp(newMember) == false);
            else if(checkExp(newMember) == false);
            else if(newFitness.alreadyCheckedIn(newMember) == true){
                System.out.println(newMember.getFname() + " " + newMember.getLname() + " already checked in.");
            }
            else if(memberTimeConflictGym(newMember,newFitness) > -1){
                System.out.println( "Time conflict - " + stAsStr[0].toUpperCase() + " — " + stAsStr[1] + ", "
                        + newFitness.getClassTime().getHour() + ", " + newFitness.getClassLocation()
                        + ", " + newFitness.getClassLocation().getZipcode()
                        + ", " + newFitness.getClassLocation().getCounty() );
            }
            else if( newFitness.checkIn(newMember) == true ){
                    System.out.print(newMember.getFname() + " " + newMember.getLname() + " checked in ");
                    System.out.println(newFitness + "\n");
            }
            else {
                System.out.println(newMember.getFname() + " " + newMember.getLname() + " " + DATE_CALL.print(newMember.getDob()) + " is not in the database.");
            }
        }
    }


    /**
     Deletes a person in the fitnessClass Array
     Checks if fitness Class exists
     @param st the tokens that have the member information
     */
    private void commandD(StringTokenizer st){
        String [] stAsStr = createString(st);
        if(Instructor.DENISE.isValid(stAsStr[1]) == false){
            System.out.println(stAsStr[1] + " — instructor does not exist");
        }
        else if(Location.EDISON.isValid(stAsStr[2]) == false){
            System.out.println(stAsStr[2] + ": invalid Location!");
        }
        else if(classType(stAsStr[0]) == false);
        else {
            FitnessClass newFitness = findFitClass(stAsStr);
            Member newMember = addFindMember(stAsStr);
            if ( findFitClass(stAsStr) == null ) {
                System.out.println(stAsStr[0] + " by " + stAsStr[1] + " does not exist at " + stAsStr[2]);
            }
            else if(MLIST_DATA.PublicFindMember(newMember) == null){
                System.out.println(newMember.getFname() + " " + newMember.getLname() + " " + DATE_CALL.print(newMember.getDob()) + " is not in the database.");
            }
            else if(checkCalenderDobExp(newMember) == false);
            else if(checkExp(newMember) == false);
            else if( newFitness.alreadyCheckedIn(newMember) == false ){
                System.out.println(newMember.getFname() + " " + newMember.getLname() + " did not check in");
            }
            else if( newFitness.doneClass(newMember) ){
                System.out.println(newMember.getFname() + " " + newMember.getLname() + " done with the class");
            }
        }
    }

    /**
     Adds a person to the Guest ArrayList
     Checks membership restrictions and guest passes
     @param st the tokens that have the member information
     */
    private void commandCG(StringTokenizer st){
        String [] stAsStr = createString(st);
        FitnessClass newFitness = findFitClass(stAsStr);
        Member newMember = addFindMember(stAsStr);
        if(newMember.whoAmI().equals("Member.")){
            System.out.println("Standard membership - guest check-in is not allowed.");
        }
        else if(newMember.getLocation().equals(newFitness.getClassLocation()) == false ){
            System.out.println(newMember.getFname() + " " + newMember.getLname() +
                    " checking in " + newFitness.getClassLocation() + ", "
                    + newFitness.getClassLocation().getZipcode() + ", "
                    + newFitness.getClassLocation().getCounty() + " - guest location restriction.");
        }
        else if( newFitness.guestCheckIn(newMember) ){
            System.out.print( newMember.getFname() + " " + newMember.getLname() + " (guest) checked in ");
            System.out.println(newFitness + "\n");
        }
        else  {
            System.out.println(newMember.getFname() + " " + newMember.getLname() + " ran out of guest pass");
        }
    }

    /**
     Deletes a guest in the Guest Array List
     when the guest is done with class
     @param st the tokens that has the member information
     */
    public void commandDG(StringTokenizer st){
        String [] stAsStr = createString(st);
        FitnessClass newFitness = findFitClass(stAsStr);
        Member newMember = addFindMember(stAsStr);
        if(newFitness.guestDoneClass(newMember) == true){
            System.out.println( newMember.getFname() + " " + newMember.getLname() + " Guest done with the class.");
        }
    }

    /**
     All Print commands for MemberDatabase Array
     Prints list as is, by expiration date and county and ZipCode
     @param command the command to be checked
     */
    private void commandP(String command){
        if(checkSize() == true);
        else {
            switch(command) {
                case "P" :
                    System.out.println("\n-list of members-");
                    MLIST_DATA.print();
                    System.out.println("-end of list-\n");
                    break;
                case "PC" :
                    MLIST_DATA.printByCounty();
                    break;
                case "PD" :
                    MLIST_DATA.printByExpirationDate();
                    break;
                case "PN" :
                    MLIST_DATA.printByName();
                    break;
                case "PF" :
                    MLIST_DATA.printMemberShip();
                    break;
            }
        }
    }

    /**
     Loads Data in from memberList.txt
     and prints the data once loaded
     */
    private void commandLM () throws IOException{
        String commandLine;
        String[] temp;
        Scanner inFile = new Scanner(new File("memberList.txt"));
        while(inFile.hasNext()){
            commandLine = inFile.nextLine();
            StringTokenizer st = new StringTokenizer(commandLine);
            temp = createString(st);
            Member createMemberTemp = createMember(temp);
            MLIST_DATA.add(createMemberTemp);
        }
        System.out.println("\n-list of members loaded-");
        MLIST_DATA.print();
        System.out.println("-end of list-\n");
    }

    /**
     * Creates a new Fitness Class Object for loading data
     * @param temp the String that holds the fitnessClass info.
     */
    private static FitnessClass createFitnessClass(String [] temp){
        FitnessClass tempFit = new FitnessClass(temp[0].toUpperCase(), Instructor.valueOf(temp[1].toUpperCase()),Time.valueOf(temp[2].toUpperCase()) ,Location.valueOf(temp[3].toUpperCase()));
        return tempFit;
    }

    /**
     Loads Data in from classSchedule.txt
     and prints the data once loaded
     */
    private void commandLS () throws IOException{
        String commandLine;
        String[] temp;
        Scanner inFile = new Scanner( new File("classSchedule.txt"));
        while(inFile.hasNext()){
            commandLine = inFile.nextLine();
            StringTokenizer st = new StringTokenizer(commandLine);
            temp = createString(st);
            FitnessClass newFit = createFitnessClass(temp);
            FITNESS_CLASS_DATA.add(newFit);
        }
        System .out.println("\n-Fitness classes loaded-");
        FITNESS_CLASS_DATA.printSchedule();
        System .out.println("-end of class list.\n");
    }

    /**
     Run, the method that begins the processing of the commandLine
     Uses Scanner class to take in commandLine Arguments
     */
    public void run() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String commandLine = scanner.nextLine();
        StringTokenizer st = new StringTokenizer(commandLine);
        String command = st.nextToken();
        System.out.println("\nGym Manager running...\n");
        while(!(command.equals("Q")) ) {
            isValidCommand(command);
            if( command.equals("LM") ) { commandLM(); }
            if( command.equals("LS") ){ commandLS(); }
            if(command.equals("A") || command.equals("AF") || command.equals("AP")){
                commandA(st,command);
            }
            if(command.equals("R")) { commandR(st); }
            if(command.equals("P") || command.equals("PC") || command.equals("PD") || command.equals("PN") || command.equals("PF")) {
                commandP(command);
            }
            if( command.equals("S") ) {
                System .out.println("\n-Fitness classes-");
                FITNESS_CLASS_DATA.printSchedule();
                System .out.println("-end of class list.\n");
            }
            if( command.equals("C") ) { commandC(st); }
            if( command.equals("D") ) { commandD(st); }
            if( command.equals("CG") ) { commandCG(st); }
            if( command.equals("DG") ) { commandDG(st); }
            if(st.hasMoreTokens() == false){
                commandLine = scanner.nextLine();
                while(commandLine.length() == 0){
                    commandLine = scanner.nextLine();
                    st = new StringTokenizer(commandLine);
                }
                st = new StringTokenizer(commandLine);
                command = st.nextToken();
            }
        }
        if(command.equals("Q")){
            System.out.println("\nGym Manager terminated.");
        }
    }
}



