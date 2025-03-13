package racing;

import java.util.Random;

public class Dice {
    private final Random random;

    public Dice(Random random) {
        this.random = random;
    }

    public int roll() {
        return random.nextInt() % 10;
    }
}
