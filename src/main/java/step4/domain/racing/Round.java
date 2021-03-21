package step4.domain.racing;

import step4.domain.ipnut.InputRound;

import java.util.Objects;

public final class Round {
    private final int MINIMUM = 0;
    private int round;

    public Round(InputRound inputRound) {
        this(inputRound.inputRound());
    }

    public Round(int round) {
        if (isLessThanMinimum(round)) {
            throw new IllegalArgumentException("유효하지 않은 값을 사용했습니다.");
        }
        this.round = round;
    }

    private final boolean isLessThanMinimum(int round) {
        return round < MINIMUM;
    }

    public final boolean hasNext() {
        return round > MINIMUM;
    }

    public final void nextRound() {
        round--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round1 = (Round) o;
        return round == round1.round;
    }

    @Override
    public int hashCode() {
        return Objects.hash(round);
    }

}
