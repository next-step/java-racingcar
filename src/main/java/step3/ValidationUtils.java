package step3;

public class ValidationUtils {

    public static void isBiggerThanZero(int value) {
        if(value <= 0) {
            throw new IllegalArgumentException();
        }
    }
    public static void isSingleDigitNumber(int value) {
        if(value < 0 || value > 9) {
            throw new IllegalArgumentException();
        }
    }
}
