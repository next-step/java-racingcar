package racingcar;

import racingcar.exception.RacingGameException;

public class RacingGame {
    private final int round;

    public RacingGame(int round) {
        if (round < 1) {
            throw new RacingGameException("자동차는 최소 1대 이상이어야 합니다.");
        }
        this.round = round;
    }
}
