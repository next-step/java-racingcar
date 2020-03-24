package racingcar.application;

import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameRepository;
import racingcar.domain.RacingGameResultsDto;

public class RacingGameManager {

    private final RacingGameRepository racingGameRepository;

    public RacingGameManager(RacingGameRepository racingGameRepository) {
        this.racingGameRepository = racingGameRepository;
    }

    public RacingGameResultsDto game(RacingGame racingGame) {
        racingGameRepository.saveAll(racingGame.start());

        return new RacingGameResultsDto(
                racingGameRepository.getWinners(),
                racingGameRepository.getGameResultSet()
        );
    }

}
