package step4.domain.cargameStrategy;

import java.util.Random;

public class RandomCarRacingGameStrategy implements CarRacingGameStrategy {
    private static final int MAX_RANDOM_VALUE = 10;
    private static final int BOUND = 4;
    private static final Random random = new Random();

    @Override
    public int playGetDistanceToMove() {
        int random = random();
        return getDistanceToMove(random);
    }

    private int getDistanceToMove(int randomNumber) {
        if (randomNumber >= BOUND) {
            return 1;
        }
        return 0;
    }

    private static int random() {
        return random.nextInt(MAX_RANDOM_VALUE);
    }
}
