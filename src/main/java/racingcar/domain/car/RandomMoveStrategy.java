package racingcar.domain.car;

import racingcar.generator.RandomNumberGenerator;

public class RandomMoveStrategy implements MoveStrategy {

    private static final RandomNumberGenerator generator = RandomNumberGenerator.getInstance();

    private static final int MINIMUM = 4;
    private static final int MAXIMUM = 9;

    private static RandomMoveStrategy instance;

    private RandomMoveStrategy() {
    }

    public static RandomMoveStrategy getInstance() {
        if(instance == null) {
            instance = new RandomMoveStrategy();
        }
        return instance;
    }

    @Override
    public boolean isMovable() {
        int activation = generator.generateRandomNumber();
        return (activation >= MINIMUM && activation <= MAXIMUM) ? true : false;
    }

}
