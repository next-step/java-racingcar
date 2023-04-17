package step3.numbergenerator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{

    private final Random random = new Random();
    @Override
    public int generate() {
        return random.nextInt(10);
    }
}
