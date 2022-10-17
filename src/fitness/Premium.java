package fitness;

/**
 Premium extents Family and defines the attributes of members.
 Every premium member has a first name, last name, date of birth, expiration date, and location
 @author Leah Ranavat, Tanvi Thigle
 */
public class Premium extends Family{

   public int GUEST_PASS;

   /**
    * Constructor creates an instance of a premium given all the attributes
    * @param fname first name of member
    * @param lname last name of member
    * @param dob date of birth of member
    * @param expire expiration date of member
    * @param location location of member
    */
   public Premium(String fname, String lname, Date dob, Date expire, Location location) {
      super(fname, lname, dob, expire, location);
      this.GUEST_PASS = 3;
   }

   /**
    Returns whether Member, Family or Premium
    @return String the identifier of Member
    */
   @Override
   public String whoAmI() {
      return "Premium.";
   }

   /**
    The Membership Fee for Premium Type
    @return double the dollar amount of membershipFee
    */
   @Override
   public double membershipFee() {
      return (MONTHLY_P*YEARlY);
   }

   /**
    Gets Guess Pass
    @return int Guest passes remaining
    */
   @Override
   public int getGUEST_PASS(){
      return GUEST_PASS;
   }

   /**
    Sets Guess Pass
    @param guestPass int to set guest pass to
    */
   @Override
   public void setGUEST_PASS(int guestPass){
      this.GUEST_PASS = guestPass;
   }
}
