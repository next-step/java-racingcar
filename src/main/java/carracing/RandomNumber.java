package carracing;

public class RandomNumber {

    private static final String OUT_OF_RANGE_EXCEPTION_MESSAGE_FORMAT = "랜덤 값이 유효하지 않습니다. randomNumber: %d";
    private static final int LOWER_LIMIT = 0;
    private static final int UPPER_LIMIT = 9;

    private final int number;

    private RandomNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    public static RandomNumber of(int number) {
        return new RandomNumber(number);
    }

    private static void validateNumberRange(int number) {
        if (number < LOWER_LIMIT || number > UPPER_LIMIT) {
            throw new IllegalArgumentException(String.format(OUT_OF_RANGE_EXCEPTION_MESSAGE_FORMAT, number));
        }
    }
}
