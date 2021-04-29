package utils;

public class ValidationCarName {
    public static boolean isCarNameLessThanFiveDigits(String carName) {
        return carName.length() <= 5;
    }

    public static String[] splitBasedOnCommas(String carName) {
        return carName.split(",");
    }
}
