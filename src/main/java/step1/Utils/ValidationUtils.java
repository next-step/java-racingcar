package step1.Utils;

public class ValidationUtils {
    public static void isBlankThrowException(String input) {
        if(input == null || input.isEmpty() || input.trim().equals("")) {
            throw new IllegalArgumentException("it is blank");
        }
    }

    public static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}
