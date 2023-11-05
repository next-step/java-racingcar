package carRacing;

import java.util.Random;

public class Car {

    private static final int MAX_RANDOM_BOUND = 10;
    private static final int STANDARD_MOVE_VALUE = 4;
    private static final int START_POSITION = 1;
    private static final Random random = new Random();

    private int position;

    public Car() {
        this.position = START_POSITION;
    }

    public void move() {
        if (validate()) {
            position += 1;
        }
    }

    public int position() {
        return position;
    }

    private static boolean validate() {
        return random.nextInt(MAX_RANDOM_BOUND) >= STANDARD_MOVE_VALUE;
    }

}
