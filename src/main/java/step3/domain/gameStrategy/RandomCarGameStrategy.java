package step3.domain.gameStrategy;

import java.util.Random;

public class RandomCarGameStrategy implements CarGameStrategy {

    private static final int MAX_RANDOM_VALUE = 10;
    private static final int BOUND = 4;
    private static final Random random = new Random();

    @Override
    public int getDistanceToMove() {
        int random = random(MAX_RANDOM_VALUE);
        return getGameResult(random);
    }

    private int getGameResult(int randomNumber) {
        if (randomNumber >= BOUND) {
            return 1;
        }
        return 0;
    }

    private static int random(int bound) {
        return random.nextInt(bound);
    }

}
