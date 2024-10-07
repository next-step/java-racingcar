package racingcar.service;

import racingcar.domain.*;
import racingcar.dto.RaceResult;

public class RacingGameService {

    private final RacingGame racingGame = new RacingGame(new FourOrMore(new SystemRandomHolder()), new DelimiterCarCreationStrategy());

    public RaceResult play(String carNames, int attemptCount) {
        return racingGame.play(carNames, attemptCount);
    }
}
