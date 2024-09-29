package racingcar;

import racingcar.exception.RacingGameException;

public class RacingGame {
    private final int round;
    private final int movement;

    public RacingGame(int round, int movement) {
        if (round < 1) {
            throw new RacingGameException("자동차는 최소 1대 이상이어야 합니다.");
        }
        if (movement < 1) {
            throw new RacingGameException("이동은 최소 1번 이상이어야 합니다.");
        }
        this.round = round;
        this.movement = movement;
    }
}
