package step4.domain.startegy.move;

import racingcar.generator.RandomNumberGenerator;

public class RandomMoveStrategy implements MoveStrategy {

    private static final RandomNumberGenerator generator = RandomNumberGenerator.getInstance();

    private static final int MINIMUM = 4;
    private static final int MAXIMUM = 9;

    private static RandomMoveStrategy instance;

    private RandomMoveStrategy() {
    }

    public static RandomMoveStrategy getInstance() {
        if (isInstanceNull()) {
            instance = new RandomMoveStrategy();
        }
        return instance;
    }

    private static boolean isInstanceNull() {
        return instance == null;
    }

    @Override
    public boolean isMovable() {
        int activation = generator.generateRandomNumber();
        return ((activation >= MINIMUM) && (activation <= MAXIMUM));
    }

}
