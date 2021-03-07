package step3.validation;

public class InputValidation {


    public boolean isRandomValueMoreThenFour(int randomValue) {
        if(randomValue < 4) {
            return false;
        }

        return true;
    }
}
