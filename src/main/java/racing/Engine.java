package racing;

import java.util.Random;

public class Engine {
    private final static Integer MAX_RANDOM_NUMBER = 10;
    private final static Integer REFERENCE_NUMBER = 4;
    Random random;

    public Engine() {
        this.random = new Random();
    }

    public boolean cycle() {
        int randomNumber = random.nextInt(MAX_RANDOM_NUMBER);
        return randomNumber >= REFERENCE_NUMBER;
    }
}
