package step3;

import java.util.Random;

public class Car {
    private static final Integer bound = 9;

    private static final Random random = new Random();
    private int location = 0;


    public void move() {
        if (goOrStay(random.nextInt(bound))) {
            goForward();
        }
    }

    public boolean goOrStay(int key) {
        if (key > bound || key < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANDOM_VALUE);
        }
        return key > 4;
    }

    private void goForward() {
        location++;
    }

    public int getLocation() {
        return location;
    }

}
