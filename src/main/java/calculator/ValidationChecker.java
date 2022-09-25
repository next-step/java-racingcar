package calculator;

public class ValidationChecker {
    public static void validationCheck(String number) {
        if (Integer.parseInt(number) < 0) {
            throw new RuntimeException();
        }
    }
}