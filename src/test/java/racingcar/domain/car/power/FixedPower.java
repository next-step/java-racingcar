package racingcar.domain.car.power;

import racingcar.domain.car.power.Power;

public class FixedPower implements Power {
    private boolean movable;

    public FixedPower() {
        this.movable = false;
    }

    @Override
    public boolean isMovable() {
        movable = !movable;
        return movable;
    }
}
