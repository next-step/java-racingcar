package racingcar.domain.car;

import racingcar.domain.RandomManager;

public class Move {

    private static final int BOUND = 4;

    public static Car isSatisfiedMoveCondition(Car car, int random) {
        if (random >= BOUND) {
            return car.go();
        }
        return car;
    }
}
