package carRacing;

import java.util.Random;

public class Car {

    private static final int MAX_RANDOM_BOUND = 10;
    private static final int STANDARD_MOVE_VALUE = 4;
    private static final Random random = new Random();

    private int position;

    public int move() {
        if (validate()) {
            position++;
            return position;
        }
        return position;
    }

    public int move(int moveCount) {
        if (moveCount >= 4) {
            return 1;
        }
        return 0;
    }
    private static boolean validate() {
        return random.nextInt(MAX_RANDOM_BOUND) >= STANDARD_MOVE_VALUE;
    }

}
