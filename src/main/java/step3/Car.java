package step3;

import java.util.Random;

public class Car {
    private static int RANDOM_BOUND = 10;
    private static int THRESHOLD = 4;

    private int trace = 0;

    public void go() {
        if (canGo()) {
            plusTrace();
        }
    }

    public boolean canGo() {
        return new Random().nextInt(RANDOM_BOUND) >= THRESHOLD;
    }

    public void plusTrace() {
        this.trace += 1;
    }

    public int getTrace() {
        return this.trace;
    }
}
