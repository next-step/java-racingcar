package new_racingcar.domain;

import new_racingcar.constant.MsgConstants;

import java.util.Objects;

public class Round {
    private int round;

    public Round(int round) {
        isRoundCountVaild(round);
        this.round = round;
    }

    private void isRoundCountVaild(int roundCount) {
        if (roundCount < 1) {
            throw new IllegalArgumentException(MsgConstants.ROUND_ERROR_MESSAGE);
        }
    }

    public Boolean isGameEnd() {
        if (round > 0) {
            nextRound();
            return true;
        }

        return false;
    }

    private void nextRound() {
        --round;
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
