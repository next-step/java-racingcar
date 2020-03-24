package racingcar.domain;

import racingcar.util.NumberUtils;

public class RacingCar {
    private String name;
    private int position;

    public RacingCar(String name) {
        this(name, NumberUtils.ZERO);
    }

    public RacingCar(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        this.position++;
    }
}
