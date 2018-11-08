package racingcar.domain;

import racingcar.utils.RandomUtils;

public class RacingCarAccelerator {

    private int maxSpeed;

    public RacingCarAccelerator(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int speedUp() {
        return maxSpeed < RandomUtils.generateRandomInt() ? 1 : 0 ;
    }
}
