package racingcar.util;

public class RangeableRandomNumber extends AbstractRandomNumber {

    private static final int DEFAULT_MAX_RANDOM_NUMBER = RangeableRandomNumberFactory.DEFAULT_MAX_RANDOM_NUMBER;
    private static final int DEFAULT_MIN_RANDOM_NUMBER = RangeableRandomNumberFactory.DEFAULT_MIN_RANDOM_NUMBER;

    private final int max;

    private final int min;

    public RangeableRandomNumber(int number, int max, int min) {
        super(number);
        this.max = max;
        this.min = min;
        validateNumber(number);
    }

    public RangeableRandomNumber(int number) {
        super(number);
        this.max = DEFAULT_MAX_RANDOM_NUMBER;
        this.min = DEFAULT_MIN_RANDOM_NUMBER;
        validateNumber(number);
    }

    private void validateNumber(int number) {
        if (number < min || number > max) {
            throw new IllegalArgumentException("[ERROR] RangeableRandomNumber는 " + min + " 보다 크고 " + max + "보다 작아야 합니다.");
        }
    }

}
