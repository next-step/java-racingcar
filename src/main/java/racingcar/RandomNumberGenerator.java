package racingcar;

import java.util.Random;

public class RandomNumberGenerator {

    private final int MIN_NUMBER = 0;
    private final int MAX_NUMBER = 10;
    private final int SUM_NUMBER = 9;

    private final Random random = new Random();

    private int minNumber = 0;
    private int maxNumber = 10;

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
            throw new IllegalArgumentException("최소값은 0보다 작을 수 없습니다.");
        }
    }

    private void validMaxNumber(final int maxNumber) {
        if (maxNumber > MAX_NUMBER || maxNumber < MIN_NUMBER) {
            throw new IllegalArgumentException("최대값은 0작거나 10보다 클수 없습니다.");
        }
    }

    private void validSumNumber(final int minNumber, final int maxNumber) {
        if (minNumber + maxNumber > SUM_NUMBER) {
            throw new IllegalArgumentException("최대값과 최소값에 합은 10보다 작아야합니다.");
        }
    }

    public int generate() {
        return minNumber + random.nextInt(maxNumber);
    }
}
