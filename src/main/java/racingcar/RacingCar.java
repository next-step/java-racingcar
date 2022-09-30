package racingcar;

import racingcar.strategy.MovingStrategy;

public class RacingCar {

    private int distance = 0;

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMove()) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }
}
