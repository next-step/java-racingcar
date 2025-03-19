package NumberGenerator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private final Random random = new Random();

    @Override
    public int generate(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}
