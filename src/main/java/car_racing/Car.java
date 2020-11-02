package car_racing;

import java.util.Random;

public class Car {

    private static final int LIMIT = 10;
    private static final int THRESHOLD = 4;

    final StringBuilder forwardStrBuilder = new StringBuilder();

    public String forwardResult() {
        return forwardStrBuilder.toString();
    }

    public void forwardOrNot(Random random) {
        int randInt = random.nextInt(LIMIT);
        if (randInt >= THRESHOLD) {
            forwardStrBuilder.append("- ");
        }
    }
}
