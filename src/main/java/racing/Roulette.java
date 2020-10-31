package racing;

import java.util.Random;

public class Roulette {

    private final Random random;

    public Roulette() {
        this.random = new Random();
    }

    public int spin() {
        return random.nextInt(10);
    }
}
