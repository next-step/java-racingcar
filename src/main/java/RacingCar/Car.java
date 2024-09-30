package RacingCar;

import java.util.Random;

public class Car {
    private int distance = 0;
    private static final int RANDOM_SIZE = 10;


    public void goCar() {
        setGoCar(getRandomNum());
    }

    private int getRandomNum() {
        Random random = new Random();
        return random.nextInt(RANDOM_SIZE);
    }

    public void setGoCar(int randomNum) {
        if (randomNum >= 4) {
            distance += 1;
        }
    }

    public int getDistance() {
        return distance;
    }
}
