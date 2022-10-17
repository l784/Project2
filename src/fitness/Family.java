package fitness;

/**
 Family extents Member and defines the attributes of members.
 Every member has a first name, last name, date of birth, expiration date, and location
 @author Leah Ranavat, Tanvi Thigle
 */
public class Family extends Member{

   public int GUEST_PASS;

   /**
    * Constructor creates an instance of a family given all the attributes
    * @param fname first name of member
    * @param lname last name of member
    * @param dob date of birth of member
    * @param expire expiration date of member
    * @param location location of member
    */
   public Family(String fname, String lname, Date dob, Date expire, Location location) {
      super(fname, lname, dob, expire, location);
      this.GUEST_PASS = 1;
   }

   /**
    Returns whether Member, Family or Premium
    @return String the identifier of Member
    */
   @Override
   public String whoAmI() {
      return "Family.";
   }

   /**
    The Membership Fee for Family Type
    @return double the dollar amount of membershipFee
    */
   @Override
   public double membershipFee() {
      return INITIAL + (MONTHLY_P* QUARTERLY);
   }

   /**
    Gets Guess Pass
    @return int Guest passes remaining
    */
   public int getGUEST_PASS(){
      return GUEST_PASS;
   }

   /**
    Sets Guess Pass
    @param guestPass int to set guest pass to
    */
   public void setGUEST_PASS(int guestPass){
      this.GUEST_PASS = guestPass;
   }

}
