package racingcar;

import java.util.Random;

public class Car {

    private static final int RANDOM_BOUND = 10;
    private static final int MOVE_THRESHOLD = 4;
    private static final int INIT_POSITION = 1;

    private final CarName name;
    private int position;
    private final Random random;

    public Car(CarName name) {
        this(name, INIT_POSITION, new Random());
    }

    public Car(CarName name, Random random) {
        this(name, INIT_POSITION, random);
    }

    public Car(CarName name, int position, Random random) {
        this.name = name;
        this.position = position;
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

    public CarName getName() {
        return name;
    }
}
