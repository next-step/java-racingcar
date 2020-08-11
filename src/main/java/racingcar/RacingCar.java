package racingcar;

import java.util.Random;

class RacingCar {

    private final Random random = new Random();
    private int laps = 0;

    public int record() {
        return laps;
    }

    public void race() {
        if (random.nextInt(10) >= 4) {
            laps++;
        }
    }
}
