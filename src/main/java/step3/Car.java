package step3;

import java.util.Random;

public class Car {

    int location;

    Car() {
        this.location = 0;
    }

    public int getCurrentLocation() {
        return this.location;
    }

    public void moveForwardOnChance() {
        move(getRandomValue());
    }

    public void move(int value) {
        if (value > 3) {
            this.location += 1;
        }
    }

    private int getRandomValue() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
