package racingcar;

import java.util.Random;

public class RandomNumGenerator {
    public RandomNumGenerator() {
    }

    public int generateNumberLessThanTen() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
