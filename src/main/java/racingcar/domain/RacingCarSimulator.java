package racingcar.domain;

import racingcar.dto.RacingResultDTO;

import java.util.List;

public class RacingCarSimulator {
    public static RacingResultDTO simulate(List<String> carNames, int tryNumber) {
        CarRacing carRacing = CarRacing.valueOf(carNames);
        proceedRacing(tryNumber, carRacing);
        return RacingResultDTO.valueOf(carRacing);
    }

    private static void proceedRacing(int tryNumber, CarRacing carRacing) {
        for (int i = 0; i < tryNumber; i++) {
            carRacing.proceedWrap();
        }
    }
}
