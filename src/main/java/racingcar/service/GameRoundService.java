package racingcar.service;

import racingcar.domain.GameRound;
import racingcar.repository.GameRoundRepository;

public class GameRoundService {

    private final GameRoundRepository gameRoundRepository;

    public GameRoundService(GameRoundRepository gameRoundRepository) {
        this.gameRoundRepository = gameRoundRepository;
    }

    public void create(int gameRound) {
        gameRoundRepository.save(new GameRound(gameRound));
    }

    public GameRound loadGameRound() {
        return gameRoundRepository.load();
    }
}
