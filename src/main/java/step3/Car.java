package step3;

import java.util.Random;

public class Car {
    private static final int RANDOM_BOUND = 10;
    private static final int THRESHOLD = 4;
    private static final String MARK = "-";
    private String trace = MARK;

    public void goOrStop() {
        goOrStop(null);
    }

    void goOrStop(Boolean go) {
        if (go == null) {
            go = decideGoOrStop();
        }
        if (go) {
            plusTrace();
        }
    }

    private boolean decideGoOrStop() {
        return new Random().nextInt(RANDOM_BOUND) >= THRESHOLD;
    }

    private void plusTrace() {
        this.trace += MARK;
    }

    public String getTrace() {
        return this.trace;
    }

}