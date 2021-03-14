package racingcar.repository;

import racingcar.domain.GameRound;

public class GameRoundRepository {

    private GameRound gameRound;

    public void save(GameRound gameRound) {
        this.gameRound = gameRound;
    }

    public GameRound load() {
        return this.gameRound;
    }
}
