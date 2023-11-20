package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.NumberOfAttempts;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomService;
import racingcar.dto.GameResultInfo;
import racingcar.dto.TotalRacingGameResult;

public class RacingCarService {

    private final RandomService randomService;
    private final RacingCars racingCars;
    private NumberOfAttempts numberOfAttempts;

    public RacingCarService(RandomService randomService, RacingCars racingCars, NumberOfAttempts numberOfAttempts) {
        this.randomService = randomService;
        this.racingCars = racingCars;
        this.numberOfAttempts = numberOfAttempts;
    }

    public TotalRacingGameResult startGame() {
        List<String> gameResults = new ArrayList<>();
        do {
            GameResultInfo gameResultInfo = startSingleGame();
            gameResults.add(gameResultInfo.getGameResult());
        } while (numberOfAttempts.isLeft());
        return new TotalRacingGameResult(gameResults, racingCars.findWinners());
    }

    private GameResultInfo startSingleGame() {
        GameResultInfo gameResultInfo = createRacingGame().startSingleGame();
        updateNumberOfAttempts(gameResultInfo.getLeftNumberOfAttempts());
        return gameResultInfo;
    }

    private RacingGame createRacingGame() {
        return new RacingGame(randomService, racingCars, numberOfAttempts);
    }

    private void updateNumberOfAttempts(NumberOfAttempts leftNumberOfAttempts) {
        this.numberOfAttempts = leftNumberOfAttempts;
    }
}
