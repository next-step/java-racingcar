package carRacing;

import java.util.Random;

public class RandomCreate {

    private static final int MAX_RANDOM_BOUND = 10;
    private static final Random random = new Random();

    private final int randomNumber;

    public RandomCreate() {
        this.randomNumber = random.nextInt(MAX_RANDOM_BOUND);
    }

    public RandomCreate(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public int randomNumber() {
        return randomNumber;
    }

}
