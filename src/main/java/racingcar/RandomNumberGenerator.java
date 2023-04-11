package racingcar;

import java.util.Random;

public class RandomNumberGenerator {

    private final Random random = new Random();
    private int minNumber = 0;
    private int maxNumber = 10;

    public RandomNumberGenerator() {}

    public RandomNumberGenerator(int minNumber, int maxNumber) {
        valid(minNumber, maxNumber);
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }

    private void valid(int minNumber, int maxNumber) {
        validMinNumber(minNumber);
        validMaxNumber(maxNumber);
        validSumNumber(minNumber, maxNumber);
    }

    private void validMinNumber(int minNumber) {
        if (minNumber < 0) {
            throw new IllegalArgumentException("최소값은 0보다 작을 수 없습니다.");
        }
    }

    private void validMaxNumber(int maxNumber) {
        if (maxNumber > 10 || maxNumber < 0) {
            throw new IllegalArgumentException("최대값은 0작거나 10보다 클수 없습니다.");
        }
    }

    private void validSumNumber(int minNumber, int maxNumber) {
        if (minNumber + maxNumber > 9) {
            throw new IllegalArgumentException("최대값과 최소값에 합은 10보다 작아야합니다.");
        }
    }

    public int generate() {
        return minNumber + random.nextInt(maxNumber);
    }
}
