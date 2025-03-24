package study;

import java.util.*;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private final StringBuilder position = new StringBuilder();
    private final Random random = new Random();

    public void move() {
        if (random.nextInt(10) >= MOVE_THRESHOLD) {
            position.append("-");
        }
    }

    public String getPosition() {
        return position.toString();
    }
}
