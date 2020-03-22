package step3;

public class ValidationUtils {

    public static void isBiggerThanZero(int value) {
        if(value <= 0) {
            throw new IllegalArgumentException();
        }
    }
    public static void validateRandomValue(int randomValue) {
        if(randomValue < 0 || randomValue > 9) {
            throw new IllegalArgumentException();
        }
    }
}
