package racingcar;

import java.util.Random;

public class Car {

    private Random randomGenerator;
    private int position;

    public Car(Random randomGenerator) {
        position = 0;
        this.randomGenerator = randomGenerator;
    }

    public void move() {
        if (randomGenerator.nextInt(10) >= 4) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }
}
