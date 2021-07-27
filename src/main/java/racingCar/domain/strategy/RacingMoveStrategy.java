package racingCar.domain.strategy;

import racingCar.util.RandomNumber;

public class RacingMoveStrategy implements MoveStrategy{

    private static final int FORWARD_CRITERIA = 4;
    private static final int BOUND_BY_RACING_CAR = 10;

    public boolean isMoveable() {
        return compareToNumber();
    }

    private boolean compareToNumber() {
        return RandomNumber.getRandomNumber(BOUND_BY_RACING_CAR) >= FORWARD_CRITERIA;
    }

}
