package racingGame;

import java.util.Random;

public class Car {
    private static Random random = new Random();
    private int runDistance = 0;

    public void run() {
        int forward = 0;
        forward = random.nextInt();

        if (forward >= 4) {
            runDistance++;
        }
    }

    public int getRunDistance() {
        return runDistance;
    }
}
