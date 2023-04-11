package step3;

import java.util.Random;

public class Car {
    public static int RANDOM_BOUND = 10;
    public static int THRESHOLD = 4;
    private static final String MARK = "-";
    private String trace = MARK;

    public void goOrStop() {
        boolean go = testGoOrStop();
        if (go) {
            plusTrace();
        }
    }

    public boolean testGoOrStop() {
        return new Random().nextInt(RANDOM_BOUND) >= THRESHOLD;
    }

    public void plusTrace() {
        this.trace += MARK;
    }

    public String getTrace() {
        return this.trace;
    }

}