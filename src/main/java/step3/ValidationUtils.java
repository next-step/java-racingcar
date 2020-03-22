package step3;

public class ValidationUtils {

    public static void validateCarCount(int carCount) {
        if(carCount <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateRoundTime(int roundTime) {
        if(roundTime <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateRandomValue(int randomValue) {
        if(randomValue < 0 || randomValue > 9) {
            throw new IllegalArgumentException();
        }
    }
}
