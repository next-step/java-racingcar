package racingcar.domain;

public class Car {

    private int movement = 0;

    public int moveOrStop(RacingStrategy racingStrategy, int value) {
        if (racingStrategy.checkCondition(value)) {
            movement++;
        }
        return movement;
    }

    public int getMovement() {
        return movement;
    }
}
