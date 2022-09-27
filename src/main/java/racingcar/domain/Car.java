package racingcar.domain;

import racingcar.strategy.MovingStrategy;

public class RacingCar {
    private int position;

    public RacingCar() {
        this.position = 0;
    }

    public void move(MovingStrategy movingStrategy) {
        if (isMovable(movingStrategy)) {
            this.position++;
            System.out.println("position = " + position);
        }
    }

    private boolean isMovable(MovingStrategy movingStrategy) {
        return movingStrategy.isMovable();
    }
}
