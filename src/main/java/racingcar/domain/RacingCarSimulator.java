package racingcar.domain;

import racingcar.domain.movableStrategy.MovableStrategy;
import racingcar.dto.RacingResultDTO;

import java.util.List;

public class RacingCarSimulator {
    public static RacingResultDTO simulate(List<String> carNames, int tryNumber, MovableStrategy movableStrategy) {
        CarRacing carRacing = CarRacing.valueOf(carNames, movableStrategy);
        proceedRacing(tryNumber, carRacing);
        return RacingResultDTO.valueOf(carRacing);
    }

    private static void proceedRacing(int tryNumber, CarRacing carRacing) {
        carRacing.proceedWraps(tryNumber);
    }
}
