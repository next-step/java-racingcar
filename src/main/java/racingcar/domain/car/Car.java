package racingcar.domain.car;

import racingcar.domain.car.power.Power;

public class Car {
    private int location;

    public int move(Power power) {
        if (power.isMovable()) {
            location++;
        }

        return location;
    }
}
