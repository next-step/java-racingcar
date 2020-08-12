package racing;

import java.util.Random;

public class Car {
    private static final int MIN_NUMBER = 4;
    private static final int RANDOM_MAX_NUMBER = 10;
    private int location;

    public Car() {
        this.location = 0;
    }

    public void run() {
        if (checkMove(getRandomNumber())) {
            move();
        }
    }

    private int getRandomNumber() {
        return new Random().nextInt(RANDOM_MAX_NUMBER);
    }

    public void move() {
        this.location++;
    }

    public boolean checkMove(int randomNumber) {
        return randomNumber >= MIN_NUMBER;
    }

    public int getLocation() {
        return location;
    }
}
