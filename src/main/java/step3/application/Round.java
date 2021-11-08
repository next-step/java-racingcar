package step3.application;

import java.util.Objects;

import static step3.utils.ValidationUtils.checkPositive;

public class Round {

    private static final int END_ROUND = 0;

    private int remainingRounds;

    public Round(Integer remainingRounds) {
        checkPositive(remainingRounds, "remainingRounds is not positvie");
        this.remainingRounds = remainingRounds;
    }

    public boolean hasNext() {
        return remainingRounds > END_ROUND;
    }

    public void decrease() {
        if (!hasNext()) {
            throw new IllegalArgumentException("남은 라운드가 없습니다.");
        }
        remainingRounds--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return remainingRounds == round.remainingRounds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(remainingRounds);
    }
}
