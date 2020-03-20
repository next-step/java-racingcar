package racingcar;

import java.util.Random;

public class RandomNumGenerator {
    public RandomNumGenerator() {
    }

    public int generateNumberLessThan(int bound) {
        return new Random().nextInt(bound);
    }
}
