package RacingGame;

import java.util.Random;

public class Car {
    private int position;

    public Car() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position += 1;
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public boolean isMoveCar(int randomNumber) {
        if (randomNumber > 4) {
            return true;
        }

        return false;
    }
}
