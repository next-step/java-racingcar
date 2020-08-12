package pobiRacingCar.utils;

public class ValidationUtils {
    public static boolean validName(String name) {
        if (StringUtils.isNullOrBlank(name)) {
           return false;
        }
        if (name.length() > 5) {
            return false;
        }
        return true;
    }
}
