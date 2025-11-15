package study.racing.domain;

import java.util.Objects;

public class RoundCount {

    private int roundCount;

    public RoundCount(int roundCount) {
        validateCount(roundCount);
        this.roundCount = roundCount;
    }

    public int value() {
        return this.roundCount;
    }

    public void executeRounds(Runnable runnable) {
        for (int i = 0; i < roundCount; i++) {
            runnable.run();
        }
    }

    private void validateCount(int roundCount) {
        if (roundCount < 1) {
            throw new IllegalArgumentException("시도 수는 1이상 입력해주세요.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RoundCount that = (RoundCount) o;
        return roundCount == that.roundCount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(roundCount);
    }
}
