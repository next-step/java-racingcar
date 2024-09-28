package step3;

import java.util.Random;

public class Car {
    private int distance = 0;

    public void goCar(int randomNum) {
        if (randomNum >= 4) {
            distance += 1;
        }
    }

    public int getDistance() {
        return distance;
    }
}
