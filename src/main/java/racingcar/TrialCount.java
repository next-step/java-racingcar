package racingcar;

public class TrialCount {
    public static final int MIN_COUNT = 1;

    public TrialCount(int count) {
        validateNumberOverMinimum(count);
    }

    private void validateNumberOverMinimum(int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상 입니다.");
        }
    }
}
