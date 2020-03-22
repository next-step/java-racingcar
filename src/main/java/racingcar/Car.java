package racingcar;

import java.util.Random;

public class Car {

    private Random randomGenerator;
    private int moveCount;

    public Car(Random randomGenerator) {
        moveCount = 0;
        this.randomGenerator = randomGenerator;
    }

    public void move() {
        if (randomGenerator.nextInt(10) >= 4) {
            moveCount += 1;
        }
    }

    public int getMoveCount() {
        return moveCount;
    }
}
