package fitness;
import java.util.ArrayList;

/**
 Fitness class provides all the instances of different classes present.
 @author Tanvi Thigle, Leah Ranavat
 */
public class FitnessClass {
    private Time time;
    private Instructor instructor;//unique

    private Location location;//unique
    private String type;//unique

    private ArrayList <Member> participants = new ArrayList<>();
    private ArrayList <Member> guests = new ArrayList<>();


    /**
     Constructor makes instances of classes and assigns time and instructors
     @param type, @param ins, @param loc, @param time, that the member wants
     */
    public FitnessClass(String type, Instructor ins, Time time,Location loc){
        this.type = type;
        this.instructor = ins;
        this.location = loc;
        this. time = time;
    }

    /**
     Gets class location
     @return Location location
     */
    public Location getClassLocation(){
        return this.location;
    }

    /**
     Gets class instructor
     @return Instructor instructor
     */
    public Instructor getInstructor(){
        return this.instructor;
    }

    /**
     Gets class time
     @return Time time
     */
    public Time getClassTime(){
        return this.time;
    }

    /**
     Gets the participants Array
     @return ArrayList participants
     */
    public ArrayList getParticipants(){
        return this.participants;
    }

    /**
     Checks if a fitness class is the same as another.
     A fitness class is uniquely identified by type, instructor, and location.
     @param obj the object to be checked
     @return true if the same false if different
     */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof FitnessClass){
            FitnessClass testClass = (FitnessClass) obj; //casting
            return ((testClass.type.equalsIgnoreCase(this.type)) && (testClass.location.equals(this.location)) && (testClass.instructor.equals(this.instructor)));
        }
        return false;
    }


    /**
     Checks in participants if they meet all the criteria
     @param member member that needs to check in
     @return true if member checked in, false if not
     */
    public boolean checkIn(Member member){
        if(member.getDob().dobIsValid(member.getDob())){
            if(member.getExpire().expIsValid(member.getExpire())){
                if(member instanceof Member && member.getLocation().equals(this.location)){
                    if(alreadyCheckedIn(member) == false){
                        return participants.add(member);
                    }
                }
                else if(member instanceof Family || member instanceof Premium){
                    if(alreadyCheckedIn(member) == false){
                        return participants.add(member);
                    }
                }
            }
        }
        return false;
    }


    /**
     Checks in guests if they meet all the criteria
     @param member member that needs to check in
     @return true if guest checked in, false if not
     */
    public boolean guestCheckIn(Member member){
        if(member.getDob().dobIsValid(member.getDob())){
            if(member.getExpire().expIsValid(member.getExpire())){
                //put in schedule?
                return addGuest(member);
            }
        }
        return false;
    }

    /**
     Adds in guests in the respective list
     @param member the member that needs to be added
     @return true if guest added in, false if not
     */
    public boolean addGuest(Member member){
        int a;
        int b;
        if(member.whoAmI().equals("Family.") && ((Family) member).GUEST_PASS > 0){
            b = ((Family) member).getGUEST_PASS();
            guests.add(member);
            ((Family) member).setGUEST_PASS(b-1);
            return true;
        }
        else if (member.whoAmI().equals("Premium.") && ((Premium) member).GUEST_PASS > 0){
            a = ((Premium) member).getGUEST_PASS();
            guests.add(member);
            ((Premium) member).setGUEST_PASS(a-1);
            return true;
        }
        return false;
    }


    /**
     Checks if member has already checked into a class they are trying to check into again
     @param member the member to check
     @return true if already checked in, false if not.
     */
    public boolean alreadyCheckedIn(Member member){
        for(int i = 0; i < participants.size(); i++){
            if(participants.get(i)!= null) {
                if (participants.get(i).equals(member)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     Helper method to TimeConflict in ClassSchedule
     @return Fitness Class
     */
    public FitnessClass TimeConflict(){
        return this;
    }


    /**
     Removes member from participants list
     @param member the member to be dropped
     @return true if drop is successful, false if not.
     */
    public boolean doneClass(Member member){
        if(alreadyCheckedIn(member)){
            for(int i =0; i <participants.size() ; i++){
                if(member.equals(participants.get(i))){
                    participants.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     Removes member from participants list
     @param member the member to be dropped
     @return true if drop is successful, false if not.
     */
    public boolean guestDoneClass(Member member){ //exists in fit_class array then remove

        for (int i = 0; i < guests.size(); i++) {
            if (member.equals(guests.get(i))) {
                guests.remove(i);
                if(member.whoAmI().equals("Premium")){
                    ((Premium)member).setGUEST_PASS(((Premium)member).getGUEST_PASS()+1);
                }
                else {
                    ((Family)member).setGUEST_PASS(((Family)member).getGUEST_PASS()+1);
                }
                return true;
            }
        }

        return false;
    }

    /**
     Prints all the information of the member
     @return String member
     */
    @Override
    public String toString(){
        String std = type + " - " + instructor + ", " + time.getHour() + ", " + location;
        String p = "\n - Participants - ";
        String g = "\n - Guests - ";
        for(int i=0; i< participants.size(); i++){
            if(participants.get(i)!= null){
                p += "\n" + "\t" + participants.get(i).getFname() + " " + participants.get(i).getLname()
                + ", DOB: " + participants.get(i).getDob().print(participants.get(i).getDob())
                + ", Membership expires " + participants.get(i).getExpire().print(participants.get(i).getExpire())
                + ", Location: " + participants.get(i).getLocation() + ", " + participants.get(i).getLocation().getZipcode()
                + ", " + participants.get(i).getLocation().getCounty();
            }
        }
        for(int i=0; i< guests.size(); i++){
            if(guests.get(i)!= null){
                g += "\n" + "\t" + guests.get(i).getFname() + " " + guests.get(i).getLname()
                + ", DOB: " + guests.get(i).getDob().print(guests.get(i).getDob())
                + ", Membership expires " + guests.get(i).getExpire().print(guests.get(i).getExpire())
                + ", Location: " + guests.get(i).getLocation() + ", " + guests.get(i).getLocation().getZipcode()
                + ", " + guests.get(i).getLocation().getCounty()
                + (guests.get(i).whoAmI().equals("Family.")? (", (Family) Guess-pass remaining: "
                        + ((Family)guests.get(i)).getGUEST_PASS() + ", "): ", ")
                + (guests.get(i).whoAmI().equals("Premium.")? ("(Premium) Guess-pass remaining: "
                + ((Premium)guests.get(i)).getGUEST_PASS() + ", ") : "");
            }
        }
        String res = std;
        if(participants.size()>0)
            res += p;
        if(guests.size()>0)
            res += g;
        return res;
    }


}