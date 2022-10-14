package fitness;

public enum Instructor {
    JENNIFER,
    KIM,
    DENISE,
    DAVIS,
    EMMA;

    /**
     Checks if the given location is valid
     Creates a Location type from String
     @param instructor the instructor that needs to be checked
     @return true if the location isValid, false otherwise
     */
    public boolean isValid(String instructor){
        Instructor [] instArr = Instructor.values();
        for(int i = 0; i < instArr.length;i++){
            if(instructor != null){
                if (instructor.toUpperCase().equals(instArr[i].toString())){
                    return true;
                }
            }
        }
        return false;
    }

}