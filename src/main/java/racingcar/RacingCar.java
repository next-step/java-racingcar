package racingcar;

import java.util.List;

public class RacingCar {
    private int distance;
    private String name;

    public RacingCar(String name) {
        this(name, 0);
    }

    public RacingCar(String name, int distance) {
        if (name.trim().length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다. ");
        }
        this.name = name;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public void move(RacingCarMoveBehavior racingCarMoveBehavior) {
        distance = racingCarMoveBehavior.action(distance);
    }
}
