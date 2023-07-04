package racingcar.usecase;

import racingcar.domain.RacingGame;
import racingcar.usecase.response.RacingGamePlayResponse;

public class RacingGamePlayUsecase {

    public RacingGamePlayResponse play(int round, RacingGame racingGame) {
        return new RacingGamePlayResponse();
    }

}
