package homework.week1.racingcar.util;

import java.util.Random;

public class RandomNumberGenerator {
    private static final int RANDOM_NUM_RANGE = 10;
    private static final int MIN_MOVE_CONDITION_VALUE = 4;
    private int randomNumber;

    private RandomNumberGenerator(Random random) {
        this(random.nextInt(RANDOM_NUM_RANGE));
    }

    public RandomNumberGenerator(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public static RandomNumberGenerator newRandomNumber(Random random) {
        return new RandomNumberGenerator(random);
    }

    public boolean movable() {
        return MIN_MOVE_CONDITION_VALUE <= randomNumber;
    }
}
