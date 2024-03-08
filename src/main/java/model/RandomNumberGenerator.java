package model;

import java.util.Random;

public class RandomNumberGenerator {

    public int generate() {
        final Random random = new Random();
        return random.nextInt(10);
    }
}
