package racingcar.view;

import racingcar.domain.MoveStrategy;
import racingcar.domain.Race;

public interface Input {
    Race setRaceAndRetryIfInvalid(MoveStrategy moveStrategy);
}
