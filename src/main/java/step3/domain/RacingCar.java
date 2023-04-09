package step3.domain;

import step3.strategy.move.MoveStrategy;

public class RacingCar {

    private final MoveStrategy moveStrategy;
    private int currentLocation;


    private RacingCar(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    private RacingCar(RacingCar racingCar) {
        this.currentLocation = racingCar.currentLocation;
        this.moveStrategy = racingCar.moveStrategy;
    }

    public static RacingCar of(MoveStrategy moveStrategy) {
        return new RacingCar(moveStrategy);
    }

    public static RacingCar copyOf(RacingCar racingCar) {
        return new RacingCar(racingCar);
    }

    public void move() {
        if (moveStrategy.isMovable()) {
            currentLocation++;
        }
    }

    public int getCurrentLocation() {
        return currentLocation;
    }
}
