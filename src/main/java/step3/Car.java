package step3;

import java.util.Random;

public class Car {
    private static final int RANDOM_BOUND = 10;
    private static final int THRESHOLD = 4;
    private static final String MARK = "-";
    private static final String DELIMITER_FOR_RESULT = " : ";
    private String trace = MARK;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

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

    public String getNowRacingResult() {
        return name + DELIMITER_FOR_RESULT + trace;
    }

    public String getTrace() {
        return this.trace;
    }

    public String getName() {
        return this.name;
    }

}