package racingcar.presentation;

import racingcar.domain.dto.RacingCarRequest;
import racingcar.domain.dto.RacingCarResult;

public interface RacingCarClient {
    RacingCarRequest getRacingCarInput();

    void showResultHeader();

    void showRacingCarResult(RacingCarResult result);
}
