package step4.dto.count;

import step4.common.MyException;
import step4.common.MyNumber;

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
        return this.trialCount <= MyNumber.ZERO.getValue();
    }

    private void notValidThrow(int input) {
        if(input < MyNumber.ONE.getValue()) {
            throw new IllegalArgumentException(MyException.VALUE_GREATER_THAN_ZERO.getMessage());
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
