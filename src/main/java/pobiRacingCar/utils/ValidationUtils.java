package pobiRacingCar.utils;

public class ValidationUtils {
    public static boolean validName(String name) {
        if (StringUtils.isNullOrBlank(name)) {
           return false;
        }
        return true;
    }
}
