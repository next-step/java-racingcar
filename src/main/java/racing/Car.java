package racing;

import java.util.Random;

public class Car {
    private static final String DISTANCE_STRING = "-";

    private int distance = 0;

    public int getDistance() {
        return distance;
    }

    public void move() {
        Random random = new Random();
        if (random.nextInt(10) >= 4) {
            distance++;
        }
    }

    public void move(int n) {
        if (n >= 4) {
            distance++;
        }
    }

    public void showDistance() {
        ResultView.print(DISTANCE_STRING.repeat(distance));
    }
}
