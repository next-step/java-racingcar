package racing.game.random;

import java.util.Random;

public class PositiveRandomNumber implements RandomNumber {
    private final Random random = new Random();

    @Override
    public int generate(int bound) {
        return random.nextInt(bound + 1);
    }
}
