package step4.racingcar2.model;

import java.util.Random;

public class RacingCarEngine {

    private static final int MIN = 0;
    private static final int MAX = 9;
    private final int threshold;

    public RacingCarEngine(int threshold) {
        this.threshold = threshold;
    }

    public boolean canRun() {
        return new Random().nextInt((MAX - MIN) + 1) + MIN >= threshold;
    }

}
