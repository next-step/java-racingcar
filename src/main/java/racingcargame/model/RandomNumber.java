package racingcargame.model;

import java.util.Random;

public class RandomNumber {
    private Random random;

    public RandomNumber() {
        random = new Random();
    }

    public int createRandomNumber() {
        return random.nextInt(10);
    }
}
