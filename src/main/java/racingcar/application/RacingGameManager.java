package racingcar.application;

import racingcar.domain.*;

public class RacingGameManager {

    private final RacingGameRepository racingGameRepository;

    public RacingGameManager(RacingGameRepository racingGameRepository) {
        this.racingGameRepository = racingGameRepository;
    }

    public RacingGameResults game(RacingGame racingGame) {
        racingGameRepository.saveAll(racingGame.start());

        return new RacingGameResults(
                racingGameRepository.getWinners(),
                racingGameRepository.getGameResultSet()
        );
    }

}
