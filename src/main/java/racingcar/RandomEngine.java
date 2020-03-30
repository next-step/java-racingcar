package racingcar;

import java.util.Random;

public class RandomEngine implements Engine {
    private final Random random;
    private int previousNumber;

    public RandomEngine() {
        random = new Random();
        previousNumber = 0;
    }

    @Override
    public int generateNumber() {
        previousNumber = random.nextInt(10);
        return previousNumber;
    }

    @Override
    public int getPreviousNumber() {
        return previousNumber;
    }
}
