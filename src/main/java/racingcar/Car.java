package racingcar;

import java.util.Random;

public class Car {
    private static final int RANDOM_BOUND = 10;
    private static final int MOVE_THRESHOLD = 4;
    private final String name;
    private int position;

    private final Random random;

    public Car(String name) {
        this.name = name;
        this.position = 1;
        this.random = new Random();
    }

    public Car(String name, Random random) {
        this.name = name;
        this.position = 1;
        this.random = random; /* for mocking random in test */
    }

    public void move() {
        if (isMove(random.nextInt(RANDOM_BOUND))) {
            position++;
        }
    }

    private boolean isMove(int value) {
        return value >= MOVE_THRESHOLD;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
