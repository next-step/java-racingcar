package racingcar.service.value;

import racingcar.utils.Preconditions;

import java.util.Objects;

public class Round {
    private final Integer round;

    private Round(Integer round) {
        Preconditions.checkNotNull(round, "round는 필수값입니다.");

        this.round = round;
    }

    public static Round from(Integer integer) {
        return new Round(integer);
    }

    public Integer getRound() {
        return round;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round1 = (Round) o;
        return Objects.equals(round, round1.round);
    }

    @Override
    public int hashCode() {
        return Objects.hash(round);
    }
}
