package racingcar.value;

import racingcar.utils.Preconditions;

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
}
