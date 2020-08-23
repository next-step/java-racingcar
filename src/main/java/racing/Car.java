package racing;

import java.util.Random;

public class Car {
    private static final int MIN_NUMBER = 4;
    private static final int RANDOM_MAX_NUMBER = 10;

    private int location;

    private Random random = new Random();

    public Car() {
        this.location = 0;
    }

    public void run() {
        if (checkMove(getRandomNumber())) {
            move();
        }
    }

    private int getRandomNumber() {
        return random.nextInt(RANDOM_MAX_NUMBER);
    }

    private void move() {
        this.location++;
    }

    private boolean checkMove(int randomNumber) {
        return randomNumber >= MIN_NUMBER;
    }

    public int getLocation() {
        return location;
    }
}
