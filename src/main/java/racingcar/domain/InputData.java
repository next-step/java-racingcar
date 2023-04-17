package racingcar.domain;

public class InputData {

    private String rawString;
    private int roundCount;

    private static final String CONFIRM_CAR_NAME = "자동차 이름을 다시 확인해 주세요.";
    private static final String CONFIRM_TRY_COUNT = "시도 횟수는 0 보다 커야 합니다.";

    public InputData(String rawString, int roundCount) {
        validate(rawString, roundCount);
        this.rawString = rawString;
        this.roundCount = roundCount;
    }

    private void validate(final String rawString, final int roundCount) {
        if (rawString == null || rawString.isEmpty() || rawString.trim().isEmpty()) {
            throw new IllegalArgumentException(CONFIRM_CAR_NAME);
        }

        if (roundCount <= 0) {
            throw new IllegalArgumentException(CONFIRM_TRY_COUNT);
        }
    }

    public String getRawString() {
        return rawString;
    }

    public int getRoundCount() {
        return roundCount;
    }
}
