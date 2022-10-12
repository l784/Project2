package fitness;

public class Premium extends Family{

   /**
    * Constructor creates an instance of a member given all the attributes
    *
    * @param fname
    * @param lname
    * @param dob
    * @param expire
    * @param location
    */
   public Premium(String fname, String lname, Date dob, Date expire, Location location) {
      super(fname, lname, dob, expire, location);
   }

   @Override
   public String whoAmI() {
      return "I'm a Premium. ";
   }

   @Override
   public double membershipFee() {
      return (59.99*3);
   }

}
