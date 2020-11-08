package racingcar.exeption;

import racingcar.asset.ExceptionConst;

public class GameOverException extends RuntimeException {
    public GameOverException() {
        super(ExceptionConst.GAME_OVER_MSG);
    }
}
