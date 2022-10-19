package racingcar.domain;

public class OverThresholdNumberStrategy implements NumberStrategy {

    @Override
    public boolean isSameOrOverThreshold(int threshold) {
        return true;
    }
}
