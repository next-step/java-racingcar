package step3;

import java.util.Random;

public class Car {

    private static Random random = new Random();
    private static final int MAX = 10;
    private static final int MOVE_CONDITION = 4;

    public void move() {
        if (random.nextInt(MAX) >= MOVE_CONDITION) {

        }
    }
}
