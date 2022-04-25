package racing;

import java.util.Random;

public class Engine {
    private static final Integer MAX_RANDOM_NUMBER = 10;
    private static final Integer REFERENCE_NUMBER = 4;
    private final Random random;

    public Engine() {
        this.random = new Random();
    }

    public boolean cycle() {
        int randomNumber = random.nextInt(MAX_RANDOM_NUMBER);
        return randomNumber > REFERENCE_NUMBER;
    }
}
