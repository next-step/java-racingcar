package step3;

import java.util.Random;

public class Car {
    private int position;
    private static final int BOUND = 9;
    private final Random random = new Random();

    public void move() {
        if (this.random() >= 4) {
            this.position++;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < position; i++) {
            builder.append("-");
        }
        return builder.toString();
    }

    private int random() {
        return random.nextInt(BOUND);
    }
}
