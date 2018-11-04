package racingcar;

import java.util.Random;

public class RacingCarAccelerator {

    private static final Random RANDOM = new Random();
    private int maxSpeed;

    public RacingCarAccelerator(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int stepOn(int currentPosition) {
        // TODO
        // 가속 정책이 추가될 듯...
        return currentPosition < maxSpeed ?
                RANDOM.nextInt(maxSpeed - currentPosition) :
                0;
    }
}
