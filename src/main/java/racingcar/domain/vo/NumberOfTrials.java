package racingcar.domain.vo;

public class NumberOfTrials {
    private final int value;

    private NumberOfTrials(final int value) {
        this.value = value;
    }

    public static NumberOfTrials from(final int numberOfTrial) {
        if (numberOfTrial < 1) {
            throw new RuntimeException("시도 횟수는 1회 이상이어야 합니다");
        }

        return new NumberOfTrials(numberOfTrial);
    }

    public int getValue() {
        return value;
    }
}
