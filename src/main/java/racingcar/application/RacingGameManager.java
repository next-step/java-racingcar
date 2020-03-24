package racingcar.application;

import racingcar.domain.*;

public class RacingGameManager {

    private final RacingGameRepository racingGameRepository;

    public RacingGameManager(RacingGameRepository racingGameRepository) {
        this.racingGameRepository = racingGameRepository;
    }

    public RacingGameResults game(RacingGame racingGame) {
        for (int i = RacingGameConstant.NUMBER_ZERO; i < racingGame.getRound(); i++) {
            Cars game = racingGame.roundStart();
            racingGameRepository.save(game);
        }

        return new RacingGameResults(
                racingGameRepository.getWinners(),
                racingGameRepository.getGameResultSet()
        );
    }

}
