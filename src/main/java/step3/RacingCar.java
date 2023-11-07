package step3;

import java.util.Random;

public class RacingCar {
    private static final Random random = new Random();
    private int distance = 0;

    public int getRandomInt() {
        return random.nextInt(10);
    }

    public void move(int randomInt) {
        if (randomInt > 3) {
            this.distance++;
        }
    }

    public int getDistance() {
        return this.distance;
    }
}
