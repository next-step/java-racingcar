package racingcar;

import java.util.Random;

public class RandomEngine implements Engine {
    private final Random random;

    public RandomEngine() {
        random = new Random();
    }

    @Override
    public int generateNumber() {
        return random.nextInt(10);
    }
}
