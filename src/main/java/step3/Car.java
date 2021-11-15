package step3;

import step3.manager.RacingManager;

public class Car {
    private Position runPosition;
    private RacingManager racingManager;

    public Car(RacingManager racingManager) {
        this.racingManager = racingManager;

        runPosition = new Position();
    }

    public Position currentPosition() {
        return runPosition;
    }

    public void run() {
        if(racingManager.checkRunCondition()) {
            runPosition.plusPosition();
        }
    }
}
