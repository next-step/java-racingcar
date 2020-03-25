package racingcar.domain;

import racingcar.util.NumberUtils;

public class RacingCar {
    private String name;
    private int distance;

    public RacingCar(String name) {
        this(name, NumberUtils.ZERO);
    }

    public RacingCar(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void moveForward() {
        this.distance++;
    }
}
