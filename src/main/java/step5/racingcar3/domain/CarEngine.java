package step5.racingcar3.domain;

import java.util.Random;
import step5.racingcar3.exception.CarEngineException;

public class CarEngine {

    private static final int DEFAULT_THRESHOLD = 4;
    private static final int MIN = 0;
    private static final int MAX = 9;
    private final int threshold;

    public CarEngine() {
        this(DEFAULT_THRESHOLD);
    }

    public CarEngine(int threshold) {
        validate(threshold);
        this.threshold = threshold;
    }

    public boolean canRun() {
        return new Random().nextInt((MAX - MIN) + 1) + MIN >= threshold;
    }

    public void validate(int threshold) {
        if (threshold < MIN) {
            throw new CarEngineException("엔진의 기준값은 0 이상 9 이하만 가능합니다.");
        }
    }

}
