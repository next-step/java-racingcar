package step3;

import step3.manager.RacingManager;

public class Car {
    private Count runPosition;
    private RacingManager racingManager;

    public Car(RacingManager racingManager) {
        this.racingManager = racingManager;

        runPosition = new Count();
    }

    public Count currentPosition() {
        return runPosition;
    }

    public void run() {
        if(racingManager.checkRunCondition()) {
            runPosition.plusCount();
        }
    }
}
