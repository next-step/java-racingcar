package step5.racingcar3.domain;

import java.util.Objects;
import java.util.Random;
import step5.racingcar3.exception.CarEngineException;

public class CarEngine {

    public static final int MIN_THRESHOLD = 0;
    public static final int MAX_THRESHOLD = 9;
    public static final int ALWAYS_GO_THRESHOLD = 0;
    public static final int ALWAYS_STOP_THRESHOLD = 10;
    private static final int DEFAULT_THRESHOLD = 4;
    private final int threshold;

    public CarEngine() {
        this(DEFAULT_THRESHOLD);
    }

    public CarEngine(int threshold) {
        validate(threshold);
        this.threshold = threshold;
    }

    public boolean canGo() {
        return new Random().nextInt((MAX_THRESHOLD - MIN_THRESHOLD) + 1) + MIN_THRESHOLD >= threshold;
    }

    public void validate(int threshold) {
        if (threshold < MIN_THRESHOLD) {
            throw new CarEngineException(String.format("엔진의 기준값은 %d 이상 %d 이하만 가능합니다.", MIN_THRESHOLD, MAX_THRESHOLD));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CarEngine)) {
            return false;
        }
        CarEngine carEngine = (CarEngine) o;
        return threshold == carEngine.threshold;
    }

    @Override
    public int hashCode() {
        return Objects.hash(threshold);
    }

}
