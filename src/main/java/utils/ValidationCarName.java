package utils;

public class ValidationCarName {
    public static final int CAR_NAME_MAX_LENGTH = 5;
    public static final String CAR_NAME_SPLIT = ",";

    public static boolean isCarNameLessThanFiveDigits(String carName) {
        return carName.length() <= CAR_NAME_MAX_LENGTH;
    }

    public static String[] splitBasedOnCommas(String carName) {
        return carName.split(CAR_NAME_SPLIT);
    }
}
