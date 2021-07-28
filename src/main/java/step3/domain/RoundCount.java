package step3.domain;

import step3.exception.WrongGameSettingException;

public class RoundCount {

    private final int roundCount;

    public RoundCount(int roundCount) {
        validateRoundCount(roundCount);
        this.roundCount = roundCount;
    }

    private void validateRoundCount(int roundCount) {
        if (roundCount <= 0) {
            throw new WrongGameSettingException("시도회수는 1이상이여야만 합니다.");
        }
    }

    public int getInt() {
        return this.roundCount;
    }

}
