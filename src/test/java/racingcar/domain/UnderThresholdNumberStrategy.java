package racingcar.domain;

public class UnderThresholdNumberStrategy implements NumberStrategy {
    @Override
    public boolean isSameOrOverThreshold(int threshold) {
        return false;
    }
}
