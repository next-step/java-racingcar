package racing;

import java.util.Random;

public class Car {
    private static final int GO_CONDITION = 4;
    private static final int RANDOM_MAX = 10;
    private int position = 1;

    public void move() {
        Random random = new Random();
        int randomNumber = random.nextInt(RANDOM_MAX);
        if (randomNumber >= GO_CONDITION) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
