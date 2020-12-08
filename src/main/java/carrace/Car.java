package carrace;

import java.util.Random;

public class Car {
    private static final int MAX_RANGE = 9;
    private static final int MIN_FORWARD_NUMBER = 4;

    private final Random random = new Random();
    private int position = 1;

    private boolean canMovingForwad(int randomNumber) {
        return randomNumber > MIN_FORWARD_NUMBER;
    }

    public boolean tryMovingForward() {
        int randomNumber = random.nextInt(MAX_RANGE);
        if (canMovingForwad(randomNumber)) {
            position++;
            return true;
        }
        return false;
    }

    public int getPosition() {
        return position;
    }
}
