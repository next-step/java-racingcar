package racingcar;

import java.util.Random;

public class Car {

    public static final int BOUND = 10;
    public static final int THRESHOLD = 4;
    private int position = 0;
    private Random randomGenerator;

    public Car(){
        randomGenerator = new Random();
    }
    public Car(Random random) {
        randomGenerator = random;
    }

    public void move() {
        if (canMove()) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

    private boolean canMove() {
        return randomGenerator.nextInt(BOUND) >= THRESHOLD;
    }
}
