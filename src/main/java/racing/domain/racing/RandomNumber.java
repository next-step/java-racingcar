package racing.domain.racing;

import java.util.Random;

public class RandomNumber {

    private static final Random random = new Random();
    private final int randomNumber;

    public RandomNumber(int bound) {
        this.randomNumber = random.nextInt(bound);
    }

    public int randomNumber() {
        return this.randomNumber;
    }
}
