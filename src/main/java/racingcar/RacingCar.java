package racingcar;

import java.util.Random;

public class RacingCar {

    private int location = 0;


    public static int getRandomValue() {
        Random rand = new Random();
        return rand.nextInt(10);
    }

    public void moveOrStop(int value) {
        if (value >= 4) {
            // move
            this.location += 1;
        }
    }

    public int getLocation() {
        return this.location;
    }
}
