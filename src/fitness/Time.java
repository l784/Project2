package fitness;

/**
 Time enum class defines the times for fitness classes
 There are two set times at which different Fitness classes take place.
 @author Leah Ranavat, Tanvi Thigle
 */
public enum Time {

    MORNING ("9:30"),
    AFTERNOON("14:00"),
    EVENING("18:30"),
    NOVALUE("O");

    private final String hour;

    /**
     Constructor used to set time
     @param hour, that it needs to be set to
     */
    Time(String hour){
        this.hour = hour;
    }

    /**
     Gets the value for hour
     @return String hour to access the private instance variable
     */
    public String getHour(){
        return hour;
    }

}