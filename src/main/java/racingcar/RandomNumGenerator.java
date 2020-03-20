package racingcar;

import java.util.Random;

public class RandomNumGenerator {
    public RandomNumGenerator() {
    }

    public int generateNumberLessThanTen() {
        return new Random().nextInt(10);
    }
}
