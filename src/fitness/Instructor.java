package fitness;

/**
 * Instructor names for all the classes
 */
public enum Instructor {
    JENNIFER,
    KIM,
    DENISE,
    DAVIS,
    EMMA;

    /**
     Checks if the given instructor is valid
     Creates a instructor type from String
     @param instructor the instructor that needs to be checked
     @return true if the instructor isValid, false otherwise
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