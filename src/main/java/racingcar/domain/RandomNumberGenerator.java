package racingcar.domain;

import java.util.Random;

public class RandomNumberGenerator {

    private static final String MIN_NUMBER_FORMAT = "최소값은 %s보다 작을 수 없습니다.";
    private static final String MIN_MAX_NUMBER_FORMAT = "최대값은 %s작거나 %s보다 클수 없습니다.";
    private static final String MIN_MAX_SUM_FORMAT = "최대값과 최소값에 합은 %s보다 작아야합니다.";

    private final int MIN_NUMBER = 0;
    private final int MAX_NUMBER = 10;
    private final int SUM_NUMBER = 9;

    private final Random random = new Random();

    private int minNumber = MIN_NUMBER;
    private int maxNumber = MAX_NUMBER;

    public RandomNumberGenerator() {}

    public RandomNumberGenerator(final int minNumber, final int maxNumber) {
        validate(minNumber, maxNumber);
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }

    private void validate(final int minNumber, final int maxNumber) {
        validMinNumber(minNumber);
        validMaxNumber(maxNumber);
        validSumNumber(minNumber, maxNumber);
    }

    private void validMinNumber(final int minNumber) {
        if (minNumber < MIN_NUMBER) {
            throw new IllegalArgumentException(String.format(MIN_NUMBER_FORMAT, MIN_NUMBER));
        }
    }

    private void validMaxNumber(final int maxNumber) {
        if (maxNumber > MAX_NUMBER || maxNumber < MIN_NUMBER) {
            throw new IllegalArgumentException(String.format(MIN_MAX_NUMBER_FORMAT, MIN_NUMBER, MAX_NUMBER));
        }
    }

    private void validSumNumber(final int minNumber, final int maxNumber) {
        if (minNumber + maxNumber > SUM_NUMBER) {
            throw new IllegalArgumentException(String.format(MIN_MAX_SUM_FORMAT, SUM_NUMBER));
        }
    }

    public int generate() {
        return minNumber + random.nextInt(maxNumber);
    }
}
