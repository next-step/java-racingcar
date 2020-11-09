package step3;

public class CarRacingPropertyValidator {

    public boolean isNumber(String value){
        try {
            int parsedValue = Integer.parseInt(value);
            if (parsedValue <= 0) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
