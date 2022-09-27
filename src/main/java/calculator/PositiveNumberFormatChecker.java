package calculator;

public class PositiveNumberFormatChecker {
    private PositiveNumberFormatChecker() {
    }

    public static boolean validationCheck(String number) {
        return isNumberFormat(number) && isPositiveNumber(number);
    }

    public static boolean isNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isPositiveNumber(String number) {
        return Integer.parseInt(number) > 0;
    }
}
