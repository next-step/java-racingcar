package step3.domain;

import step3.utils.RandomGenerator;

public class Car {
    private String racingLog = "-";
    private static final int STANDARD_FOR_MOVING = 4;

    public String getRacingLog() {
        return racingLog;
    }

    public void move(RandomGenerator random) {
        if (isMoving(random)) {
            racingLog += "-";
        }
    }

    public boolean isMoving(RandomGenerator random) {
        return random.getRandom() >= STANDARD_FOR_MOVING;
    }
}
