package domain;

import strategy.MovableStrategy;

public class RacingGame {
    private MovableStrategy movableStrategy;

    public RacingGame(MovableStrategy movableStrategy) {
        this.movableStrategy = movableStrategy;
    }

    public void playGame(Cars cars) {
        cars.moveAll(movableStrategy);
    }

}
