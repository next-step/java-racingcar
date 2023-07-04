package racingcar.car;

import java.util.Random;

public class Car {
    private static final int RANDOM_BOUND = 10;
    private static final int MOVE_THRESHOLD = 4;
    static final int DEFAULT_POSITION = 1;
    private final String name;
    private final Random random;
    private int position;

    public Car(String name) {
        this.name = name;
        this.random = new Random();
        this.position = DEFAULT_POSITION;
    }

    public Car(String name, Random random) {
        this.name = name;
        this.random = random;
        this.position = DEFAULT_POSITION;
    }

    public void move() {
        if (canMove(random.nextInt(RANDOM_BOUND))) {
            position++;
        }
    }

    private boolean canMove(int value) {
        return value >= MOVE_THRESHOLD;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name + " : " + "-".repeat(this.position);
    }
}
