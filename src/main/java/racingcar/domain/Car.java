package racingcar.domain;

public class Car {

    private String name;
    private int movement = 0;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public int moveOrStop(RacingStrategy racingStrategy, int value) {
        if (racingStrategy.checkCondition(value)) {
            movement++;
        }
        return movement;
    }

    public int getMovement() {
        return movement;
    }

    public String getName() {
        return name;
    }

}
