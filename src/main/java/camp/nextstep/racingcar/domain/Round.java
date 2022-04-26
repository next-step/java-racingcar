package camp.nextstep.racingcar.domain;

import java.util.Objects;

public class Round {

    private int round;

    public Round(String round) {
        this(parseInt(round));
    }

    public Round(int round) {
        if (round < 0) {
            throw new IllegalArgumentException("위치 값은 0보다 작을 수 없습니다.");
        }
        this.round = round;
    }

    public void finishPerRound() {
        this.round--;
    }

    public boolean isFinished() {
        return round < 1;
    }

    private static int parseInt(String rounds) {
        try {
            return Integer.parseInt(rounds);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("[ERROR] 자동차 게임 횟수는 숫자만 가능합니다.");
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
        Round that = (Round) o;
        return round == that.round;
    }

    @Override
    public int hashCode() {
        return Objects.hash(round);
    }

}
