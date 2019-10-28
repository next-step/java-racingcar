package step1.Utils;

public class ValidationUtils {
    public static void isBlankThrowException(String input) {
        if(input == null || input.isEmpty() || input.trim().equals("")) {
            throw new IllegalArgumentException("it is blank");
        }
    }

    public static void isNotNumericThrowException(String s) {
        try {
            Double.parseDouble(s);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("it is not numeric", e);
        }
    }
}
