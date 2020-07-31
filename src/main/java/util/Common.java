package util;

public final class Common {

    public static boolean isStringNumber(String number) {
        try {
            Double.parseDouble(number);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

}
