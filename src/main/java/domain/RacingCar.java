package domain;

import domain.strategy.MovingStrategy;

public class RacingCar {

    private int position;

    private RacingCar() {}

    public static RacingCar init() {

        return new RacingCar();
    }

    public void move(final MovingStrategy movingStrategy) {

        if (movingStrategy.movable()) {
            this.position++;
        }
    }

    public int moveDistance() {

        return this.position;
    }
}