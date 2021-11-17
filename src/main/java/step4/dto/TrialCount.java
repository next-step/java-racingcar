package step4.dto;

import step4.common.MyException;
import step4.common.Number;

import java.util.Objects;

public class TrialCount {
    private int trialCount;

    public TrialCount(int trialCount) {
        notValidThrow(trialCount);

        this.trialCount = trialCount;
    }

    public void subtractTrialCount() {
        this.trialCount -= 1;
    }

    public boolean isEndTrialCount() {
        return this.trialCount <= Number.ZERO.getValue();
    }

    private void notValidThrow(int input) {
        if(input <= Number.ONE.getValue()) {
            throw new IllegalArgumentException(MyException.VALUE_GREATER_THAN_ONE.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TrialCount that = (TrialCount) o;

        return trialCount == that.trialCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(trialCount);
    }
}
