package racingcar.usecase;

import racingcar.usecase.request.RacingGamePlayRequest;
import racingcar.usecase.response.RacingGamePlayResponse;

public interface RacingGamePlayable {

    RacingGamePlayResponse play(int round, RacingGamePlayRequest racingGamePlayRequest);

}
