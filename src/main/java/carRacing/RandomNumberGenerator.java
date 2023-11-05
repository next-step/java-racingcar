package carRacing;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final Random RANDOM = new Random();
    private static final int MAX = 10;


    @Override
    public int generate() {
        return RANDOM.nextInt(MAX);
    }
}
