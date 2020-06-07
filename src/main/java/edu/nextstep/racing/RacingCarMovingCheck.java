package edu.nextstep.racing;

public class RacingCarMovingCheck implements MovingCheck {
    private RandomNumber randomNumber;

    RacingCarMovingCheck(RandomNumber randomNumber) {
        this.randomNumber = randomNumber;
    }

    @Override
    public boolean isMovable() {
        return randomNumber.generator() >= 4;
    }
}
