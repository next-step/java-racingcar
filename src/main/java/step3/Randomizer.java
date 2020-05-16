package step3;

import java.util.Random;

public class Randomizer {
    private Random random;

    Randomizer() {
        random = new Random();
    }

    public int generateNumber() {
        return random.nextInt(10);
    }
}
