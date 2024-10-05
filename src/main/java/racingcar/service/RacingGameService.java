package racingcar.service;

import racingcar.domain.FourOrMore;
import racingcar.domain.MoveStrategy;
import racingcar.domain.RacingGame;
import racingcar.domain.SystemRandomHolder;
import racingcar.dto.RaceResult;

public class RacingGameService {

    private final MoveStrategy moveStrategy = new FourOrMore(new SystemRandomHolder());

    public RaceResult play(String carNames, int attemptCount) {
        RacingGame racingGame = new RacingGame(carNames, moveStrategy);
        return racingGame.race(attemptCount);
    }
}
