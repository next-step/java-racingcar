package racingCar.utils;

public class Utils {

    public int toInt(String values){
        return checkPositive(values);
    }

    private static int checkPositive(String value){
        int result;
        try {
            result = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if(result < 0){
            throw new IllegalArgumentException();
        }
        return result;
    }
}
