package carrace;

import java.util.Random;

public class RandomNumberGenerator {

    private static Random random = new Random();

    public int getRandomBetweenZeroAndNine() {
        return (random.nextInt() & Integer.MAX_VALUE) % 10;
    }

}
