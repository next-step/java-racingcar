package model;

import java.util.Random;

public class Car {
    private int currentPosition = 1;

    public void tryMove() {
        Random random = new Random();
        int number = random.nextInt(10);

        if (number >= 4) {
            this.currentPosition++;
        }
    }
}
