package fitness;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
//import classSchedule.txt;

/**
Gym Manager, is a User Interface Class to process the command line
Can process a single or batch of command lines
@author Leah Ranavat, Tanvi Thigle
*/
public class GymManager {

    private static final MemberDatabase MLIST_DATA = new MemberDatabase();
    private static final Date DATE_CALL = new Date();
    private static final ClassSchedule FITNESS_CLASS_DATA = new ClassSchedule();
    public int count = 0;
    //private static final ArrayList PARTICIPANTS =
    //private static FitnessClass  newFitness = new FitnessClass(null, null,null,null);
    //private static final FitnessClass FITNESS_CALL = new FitnessClass();


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
        //System.out.println("DOB" + " " + DATE_CALL.print(newMember.getDob()) + ": must be 18 or older to join!");
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
        String[] temp = new String[5];
        for(int i = 0; st.hasMoreTokens(); i++){
            temp[i]= st.nextToken();
        }
        /*Location temploc = Location.EDISON;
        if(temploc.isValid(temp[3]) == true){
        }*/
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
        //System.out.println(expiretemp.print(expiretemp));
        Member tempMember = new Member(temp[0], temp[1], dobtemp,expiretemp , Location.valueOf(temp[4].toUpperCase()));
        return tempMember;
    }
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
        //System.out.println(expiretemp.print(expiretemp));
        Family tempMember = new Family(temp[0], temp[1], dobtemp,expiretemp , Location.valueOf(temp[4].toUpperCase()));
        return tempMember;
    }

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
        //System.out.println(expiretemp.print(expiretemp));
        Premium tempMember = new Premium(temp[0], temp[1], dobtemp,expiretemp , Location.valueOf(temp[4].toUpperCase()));
        return tempMember;
    }

    /**
    Adds a person into the Array
    Checks if date of birth is Valid or person not in array
    @param st the tokens that have the member information
    */
    private void commandA(StringTokenizer st){
        String [] createString = createString(st);
        //System.out.println(createString[4]);
        Location temploc = Location.EDISON;
        if(temploc.isValid(createString[3]) == false){
            System.out.println(createString[3] + ": invalid location!");
        }
        else {
            createString[4] = createString[3];
            createString[3] = null;
            Member newMember = createMember(createString);
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

    public void commandAF(StringTokenizer st){
        String [] createString = createString(st);
        Location temploc = Location.EDISON;
        if(temploc.isValid(createString[3]) == false){
            System.out.println(createString[3] + ": invalid location!");
        }
        else{
            createString[4] = createString[3];
            createString[3] = null;
            Family newFamily = createFamily(createString);
            if(checkCalenderDobExp(newFamily) == false);
            else if (checkTodFut(newFamily.getDob()) == false);
            else if(checkAge(newFamily.getDob()) == false);
            else if(MLIST_DATA.add(newFamily) == true){
                System.out.println (newFamily.getFname() + " " + newFamily.getLname() + " " + "added");
            }
            else if(MLIST_DATA.add(newFamily) == false){
                System.out.println(newFamily.getFname() + " " + newFamily.getLname() + " is already in the database.");
            }
        }
    }

    public void commandAP(StringTokenizer st){
        String [] createString = createString(st);
        Location temploc = Location.EDISON;
        if(temploc.isValid(createString[3]) == false){
            System.out.println(createString[3] + ": invalid location!");
        }
        else{
            createString[4] = createString[3];
            createString[3] = null;
            Premium newPremium = createPremium(createString);
            if(checkCalenderDobExp(newPremium) == false);
            else if (checkTodFut(newPremium.getDob()) == false);
            else if(checkAge(newPremium.getDob()) == false);


            else if(MLIST_DATA.add(newPremium) == true){
                System.out.println (newPremium.getFname() + " " + newPremium.getLname() + " " + "added");
            }
            else if(MLIST_DATA.add(newPremium) == false){
                System.out.println(newPremium.getFname() + " " + newPremium.getLname() + " is already in the database.");
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
     Interprets command for fitness class
     @param st to separate the tokens in the input
     @return String [] to easily access different tokens
     */
    public static String [] createFitness(StringTokenizer st){
        //C cardio Jennifer somerville Roy Brooks 13/8/1977
        /*
        temp[0] = Type
        temp[1] = Instructor
        temp[2] = Location
        temp[3] = fName
        temp[4] = lname
        temp[5] = dob
         */

        String[] temp = new String[6];
        for(int i = 0; st.hasMoreTokens(); i++){
            temp[i] = st.nextToken();
        }
        return temp;
    }

    public static FitnessClass createFitObj(String [] temp){
        /*
        temp[0] = Type
        temp[1] = Instructor
        temp[2] = Location
        temp[3] = fName
        temp[4] = lname
        temp[5] = dob
         */

        FitnessClass newFitness = new FitnessClass(temp[0], Instructor.valueOf(temp[1].toUpperCase()) , Time.NOVALUE, Location.valueOf(temp[2].toUpperCase()));
        //System.out.println("In addFit");
        //System.out.println(newFitness.getParticipants().size());
        FitnessClass addData = FITNESS_CLASS_DATA.classExists(newFitness);
        if(addData != null){
            //newFitness = new FitnessClass(temp[0], Instructor.valueOf(temp[1].toUpperCase()), addData.getClassTime(), Location.valueOf(temp[2].toUpperCase()));
            return addData;
        }
        return addData;
    }

    /**
     * Creates member for Fitness class
     *
     * @param temp String from above with Member information
     * @return Member to create a list of participants
     */

    public static Member addFitMember(String [] temp){
        //C cardio Jennifer somerville Roy Brooks 13/8/1977
        /*
        temp[0] = Type
        temp[1] = Instructor
        temp[2] = Location
        temp[3] = fName
        temp[4] = lname
        temp[5] = dob
         */
        //public FitnessClass(String type, Instructor ins, Time time,Location loc){

        Member fitnessMember = new Member(temp[3],temp[4], new Date(temp[5]),new Date("12/12/2028"),Location.NOVALUE);
        //System.out.println("IN the addFit Member class" + fitnessMember.whoAmI());
        //Do checks for date of birth and for expiration data!!!
        Member addData = MLIST_DATA.PublicFindMember(fitnessMember);
        if(addData != null) {
            //System.out.println("IN the addFit Member class" + addData.whoAmI());
            if(addData.whoAmI().equals("Family.")){
                return addData;
                //fitnessMember = new Family(temp[3],temp[4], new Date(temp[5]), addData.getExpire(), addData.getLocation());
            }
            else if(addData.whoAmI().equals("Premium.")){
                return addData;
                //fitnessMember = new Premium(temp[3],temp[4], new Date(temp[5]), addData.getExpire(), addData.getLocation());
            }
            else {
                fitnessMember = new Member(temp[3],temp[4], new Date(temp[5]), addData.getExpire(), addData.getLocation());
            }
            //System.out.println(addData.whoAmI());
        }
        return fitnessMember;
    }

    public boolean classType(String fitnessClass){
        for(int i = 0; i < FITNESS_CLASS_DATA.getClasses().length; i++){
            if(FITNESS_CLASS_DATA.getClasses()[i] != null){
                if( !(fitnessClass.equalsIgnoreCase("Spinning") ||
                        fitnessClass.equalsIgnoreCase("Cardio") ||
                        fitnessClass.equalsIgnoreCase("Pilates")) ){
                    System.out.println(fitnessClass + " does not exist.");
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
    public int memberTimeConflictGym(Member member, FitnessClass fitnessClass){ // in class schedule?
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
        String [] stAsStr = createFitness(st);
        Instructor instrloc = Instructor.DENISE;
        Location temploc = Location.EDISON;
        if(instrloc.isValid(stAsStr[1]) == false){
            System.out.println(stAsStr[1] + " — instructor does not exist");
        }
        else if(temploc.isValid(stAsStr[2]) == false){
            System.out.println(stAsStr[2] + ": invalid Location!");
        }
        else if(classType(stAsStr[0]) == false);
        else {
            FitnessClass newFitness = createFitObj(stAsStr);
            Member newMember = addFitMember(stAsStr);
            //System.out.println(newMember.whoAmI());
            if(createFitObj(stAsStr) == null){
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
                System.out.println(newMember.getFname() + " " + newMember.getLname() + " has already checked in " + newFitness.getClassType() + ".");
            }
            else if(memberTimeConflictGym(newMember,newFitness) > -1){
                //Time conflict - SPINNING - EMMA, 9:30, FRANKLIN, 08873, SOMERSET
                System.out.println("Time conflict - " + stAsStr[0] + " — " + stAsStr[1] + "," + newFitness.getClassTime() + ",");
            }
            else if( newFitness.checkIn(newMember) == true ){
                    System.out.println(newMember.getFname() + " " + newMember.getLname() + " checked in " + newFitness.getClassType());
                    System.out.println(newFitness);
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
        String [] stAsStr = createFitness(st);
        Instructor instrloc = Instructor.DENISE;
        Location temploc = Location.EDISON;
        if(instrloc.isValid(stAsStr[1]) == false){
            System.out.println(stAsStr[1] + " — instructor does not exist");
        }
        else if(temploc.isValid(stAsStr[2]) == false){
            System.out.println(stAsStr[2] + ": invalid Location!");
        }
        else if(classType(stAsStr[0]) == false);
        else {
            FitnessClass newFitness = createFitObj(stAsStr);
            Member newMember = addFitMember(stAsStr);
            //System.out.println(newMember.whoAmI());
            if ( createFitObj(stAsStr) == null ) {
                System.out.println(stAsStr[0] + " by " + stAsStr[1] + " does not exist at " + stAsStr[2]);
            }
            else if(checkCalenderDobExp(newMember) == false);
            else if(checkExp(newMember) == false);
            else if( newFitness.alreadyCheckedIn(newMember) == false ){
                System.out.println(newMember.getFname() + " " + newMember.getLname() + " did not check in");
            }
            else if( newFitness.doneClass(newMember) ){
                System.out.println(newMember.getFname() + " " + newMember.getLname() + " done with this class");
            }
            else {
                System.out.println(newMember.getFname() + " " + newMember.getLname() + " " + DATE_CALL.print(newMember.getDob()) + " is not in the database.");
            }
        }
    }

    private void commandCG(StringTokenizer st){
        //System.out.println(count++);
        String [] stAsStr = createFitness(st);
        FitnessClass newFitness = createFitObj(stAsStr);
        Member newMember = addFitMember(stAsStr);
        //System.out.println(newFitness.getClassLocation() + " " + newMember.getLocation());
        if(newMember.whoAmI().equals("Member.")){
            System.out.println("Standard membership - guest check-in is not allowed.");
        }
        else if(newMember.getLocation().equals(newFitness.getClassLocation()) == false ){
            //Jonnathan Wei Guest checking in EDISON, 08837, MIDDLESEX - guest location restriction.
            System.out.println("Check location");
        }
        else if( newFitness.guestCheckIn(newMember) ){
            //if(newMember.whoAmI().)
            //Jonnathan Wei (guest) checked in SPINNING - DENISE, 9:30, BRIDGEWATER
            System.out.println( newMember.getFname() + " " + newMember.getLname() + " checked in " +
                    newFitness.getClassType() + " - " + newFitness.getInstructor() + ", " +
                    newFitness.getClassTime().getHour() + ", " + newFitness.getClassLocation());
            System.out.println(newFitness);
        }
        else  {
            System.out.println("ran out of guest pass");
        }
    }

    public void commandDG(StringTokenizer st){
        String [] stAsStr = createFitness(st);
        System.out.println("Enters this command?");
        FitnessClass newFitness = createFitObj(stAsStr);
        Member newMember = addFitMember(stAsStr);
        if(newFitness.guestDoneClass(newMember) == true){
            System.out.println( newMember.getFname() + " " + newMember.getLname() + " Guest done with the class.");
        }
        //Brown Guest done with the class.

    }

    /**
     All Print commands for MemberDatabase Array
     Prints list as is, by expiration date and county and ZipCode
     @param command the command to be checked
     */
    private void commandP(String command){
        if(command.equals("P")){
            if(checkSize() == true);
            else MLIST_DATA.print();
        }
        else if(command.equals("PC")){
            if(checkSize() == true);
            else MLIST_DATA.printByCounty();
        }
        else if(command.equals("PD")){
            if(checkSize() == true);
            else MLIST_DATA.printByExpirationDate();
        }
        else if(command.equals("PN")){
            if(checkSize() == true);
            else MLIST_DATA.printByName();
        }
    }

    private static String [] createFit (StringTokenizer st){
        String[] temp = new String[4];
        for(int i = 0; st.hasMoreTokens(); i++){
            temp[i]= st.nextToken();
        }
        return temp;
    }

    private static FitnessClass createFitnessClass(String [] temp){
        FitnessClass tempFit = new FitnessClass(temp[0].toUpperCase(), Instructor.valueOf(temp[1].toUpperCase()),Time.valueOf(temp[2].toUpperCase()) ,Location.valueOf(temp[3].toUpperCase()));
        return tempFit;
    }

    /**
     Run, the method that begins the processing of the commandLine
     Uses Scanner class to take in commandLine Arguments
     */
    public void run() throws IOException {

        //Scanner inFile = new Scanner(new File("memberList.txt"));
        //infile contains the reference to the file that is held here.
        //Can call inFile. () to call the txt
        Scanner scanner = new Scanner(System.in);
        String commandLine = scanner.nextLine();
        StringTokenizer st = new StringTokenizer(commandLine);
        String command = st.nextToken();
        System.out.println("\nGym Manager running...\n");
        while(!(command.equals("Q")) ) {
            isValidCommand(command);
            if(command.equals("A")){ //Plan to make a new private method and return one statement for each.
                commandA(st);
            }
            if ( command.equals("AF") ) {
                commandAF(st);
            }
            if(command.equals("AP")){
                commandAP(st);
            }
            if(command.equals("R")){
                commandR(st);
            }
            if(command.equals("P") || command.equals("PC") || command.equals("PD") || command.equals("PN")) {
                commandP(command);
            }
            if(command.equals("S")){
                FITNESS_CLASS_DATA.printSchedule();
            }
            if(command.equals("C")){
                commandC(st);
            }
            if(command.equals("D")){
                commandD(st);
            }
            if(command.equals("CG")){
                commandCG(st);
            }
            if(command.equals("DG")){
                commandDG(st);
            }
            if(command.equals("LM")) {
                String[] temp;
                Scanner inFile = new Scanner(new File("/Users/leah/Desktop/CS213/Project1.1/src/fitness/memberList.txt"));
                while(inFile.hasNext()){
                    //System.out.println("Goes into the while loop");
                    commandLine = inFile.nextLine();
                    System.out.println(commandLine);
                    st = new StringTokenizer(commandLine);
                    temp = createString(st);
                    Member createMemberTemp = createMember(temp);
                    MLIST_DATA.add(createMemberTemp);
                }
               //MLIST_DATA.print();
            }
            if(command.equals("LS")){
                String[] temp;
                Scanner inFile = new Scanner( new File("classSchedule.txt"));
               //ClassSchedule check = new ClassSchedule();
                while(inFile.hasNext()){
                    commandLine = inFile.nextLine();
                    st = new StringTokenizer(commandLine);
                    temp = createFit(st);
                    FitnessClass newFit = createFitnessClass(temp);
                    FITNESS_CLASS_DATA.add(newFit);
                    // System.out.println(newFit);
                }
                FITNESS_CLASS_DATA.printSchedule();
            }
            //if(command.equals("S"))

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

/*
a
p
pc
pn
pd
pf
P
PC
PN
PD
PF
AA
r
RR
s
c
d
cg
dg
ls
lm
SS
CC
DD
S
LS

A John Doe 9/2/2022 BRIDGEWATER
A John Doe 12/2/2022 BRIDGEWATER
A John Doe 12/20/2004 BRIDGEWATER
A John Doe 2/29/2003 BRIDGEWATER
A John Doe 4/31/2003 BRIDGEWATER
A John Doe 13/31/2003 BRIDGEWATER
A John Doe 3/32/2003 BRIDGEWATER
A John Doe -1/31/2003 BRIDGEWATER

LM
A John Doe 1/20/2003 BRIDGEWATER
A john doe 1/20/2003 BRIDGEWATER
A Jane Doe 6/1/1996 ABC

PC
PN
PD

R Paul Siegel 5/1/1999
P
R Paul Siegel 5/1/1999
A Paul Siegel 6/30/1999 FRANKLIN
PD

AF Jerry Brown 6/30/2005 Edison
AF Jerry Brown 6/30/2000 BBB
AF Jerry Brown 6/30/1979 Edison
AP Jonnathan Wei 9/21/2009 bridgewater
AP Jonnathan Wei 9/21/2000 bridge
AP Jonnathan Wei 9/21/1992 bridgewater
PN

C cardio Jennifer somerville Roy Brooks 13/8/1977
C cardio Jennifer somerville Roy Brooks 8/8/1977
C cardio Mary somerville Roy Brooks 8/8/1977
C cardio Jennifer somerville Happy Brooks 8/8/1977
C Pilates Jennifer Bridgewater Mary Lindsey 12/1/1989
C Pilates Kim Franklin Mary Lindsey 12/1/1989
C Pilates Kim Franklin Mary Lindsey 12/1/1989
C Spinning Emma Franklin Mary Lindsey 12/1/1989
C abc Emma Edison Jane Doe 5/1/1996
C pilates Emma Morristown Jane Doe 5/1/1996
C pilates Amy Edison Jane Doe 5/1/1996
C pilates Emma Edison Jane Doe 13/1/1996
C Spinning Davis Edison Jane Doe 5/1/1996
C pilates Emma Edison Jane Doe 5/1/1996
C Pilates Kim Franklin Paul Siegel 6/30/1999
C pilates Emma Edison Bill Scanlan 5/1/1999
S

C pilates Davis piscataway Jerry Brown 6/30/1979
C pilates Davis piscataway Jerry Brown 6/30/1979
C pilates Davis piscataway Jonnathan Wei 9/21/1992
C cardio Davis bridgewater Jonnathan Wei 9/21/1992
C pilates Jennifer bridgewater Jonnathan Wei 9/21/1992
C pilates Kim Franklin Jonnathan Wei 9/21/1992
C SPINNING KIM FRANKLIN Jerry Brown 6/30/1979

S

CG spinning Denise bridgewater Jane Doe 5/1/1996
CG spinning Denise bridgewater Jonnathan Wei 9/21/1992
CG cardio Davis bridgewater Jonnathan Wei 9/21/1992
CG CARDIO EMMA EDISON Jonnathan Wei 9/21/1992
CG cardio Davis bridgewater Jonnathan Wei 9/21/1992
CG cardio Davis bridgewater Jonnathan Wei 9/21/1992
DG cardio Davis bridgewater Jonnathan Wei 9/21/1992
CG cardio Davis bridgewater Jonnathan Wei 9/21/1992
CG cardio Davis bridgewater Jonnathan Wei 9/21/1992

CG cardio davis bridgewater Jerry Brown 6/30/1979
CG pilates davis Edison Jerry Brown 6/30/1979
CG pilates davis Edison Jerry Brown 6/30/1979
DG pilates davis Edison Jerry Brown 6/30/1979
CG pilates davis Edison Jerry Brown 6/30/1979
CG pilates davis Edison Jerry Brown 6/30/1979
S

Q
This line is garbage!
 */


