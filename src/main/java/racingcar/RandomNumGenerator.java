package racingcar;

import java.util.Random;

public class RandomNumGenerator {
    private Random random;

    public RandomNumGenerator() {
    }

    public int generateNumberLessThanTen() {
        random = new Random();
        return random.nextInt(10);
    }
}
