package edu.nextstep.racing.domain;

import edu.nextstep.racing.RandomNumber;

public class RacingCarMovingCheck implements MovingCheck {
    private RandomNumber randomNumber;

    public RacingCarMovingCheck(RandomNumber randomNumber) {
        this.randomNumber = randomNumber;
    }

    @Override
    public boolean isMovable() {
        return randomNumber.generator() >= 4;
    }
}
