package carracing;

import java.util.Random;

public class RandomCreate {

    private static final int MAX_RANDOM_BOUND = 10;
    private static final Random random = new Random();

    public int randomNumber() {
        return random.nextInt(MAX_RANDOM_BOUND);
    }

}
