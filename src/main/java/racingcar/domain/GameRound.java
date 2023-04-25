package racingcar.domain;

import racingcar.exception.InvalidGameRoundNumberException;

public class GameRound {
    private final int gameRound;

    public GameRound(int gameRound) {
        isPositiveNumber(gameRound);
        this.gameRound = gameRound;
    }

    public int getGameRound() {
        return gameRound;
    }

    private static void isPositiveNumber(Integer gameRound) {
        if (gameRound <= 0) throw new InvalidGameRoundNumberException();
    }
}
